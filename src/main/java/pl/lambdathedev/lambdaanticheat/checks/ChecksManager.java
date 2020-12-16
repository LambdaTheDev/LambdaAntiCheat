package pl.lambdathedev.lambdaanticheat.checks;

import org.bukkit.Bukkit;
import pl.lambdathedev.lambdaanticheat.LambdaAntiCheat;
import pl.lambdathedev.lambdaanticheat.checks.invalidpitch.InvalidPitchA;
import pl.lambdathedev.lambdaanticheat.checks.speed.SpeedA;
import pl.lambdathedev.lambdaanticheat.packets.PacketsListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        //And next checks....
        checks.addAll(Collections.emptyList());

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
                    break;
            }
        }
    }
}
