package pl.lambdathedev.lambdaanticheat.checks;

import io.github.retrooper.packetevents.PacketEvents;
import org.bukkit.Bukkit;
import pl.lambdathedev.lambdaanticheat.LambdaAntiCheat;
import pl.lambdathedev.lambdaanticheat.checks.reach.ReachA;
import pl.lambdathedev.lambdaanticheat.checks.reach.ReachB;
import pl.lambdathedev.lambdaanticheat.packets.PacketsListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ChecksManager
{
    private LambdaAntiCheat plugin;
    private List<Check> checks;

    public ChecksManager(LambdaAntiCheat plugin)
    {
        this.plugin = plugin;
        checks = new ArrayList<>();
    }

    public void loadChecks()
    {
        checks.addAll(Arrays.asList(
                new ReachA("Reach A", 7, false, false),
                new ReachB("Reach B", 7, false, false)

                //And next checks....
        ));

        registerChecks();
    }

    private void registerChecks()
    {
        for(Check check : checks)
        {
            if(check.isExperimental() && !LambdaAntiCheat.IS_EXPERIMENTAL) continue;

            switch (check.getType())
            {
                case BUKKIT:
                    Bukkit.getServer().getPluginManager().registerEvents((BukkitCheck)check, plugin);
                    break;
                case SENT_PACKET:
                    PacketsListener.getInstance().registerPacketSendListener((SentPacketsCheck)check);
                    break;
                case RECEIVED_PACKET:
                    PacketsListener.getInstance().registerPacketReceiveListener((ReceivedPacketsCheck)check);
            }
        }
    }
}
