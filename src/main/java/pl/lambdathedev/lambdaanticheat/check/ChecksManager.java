package pl.lambdathedev.lambdaanticheat.check;

import org.bukkit.Bukkit;
import pl.lambdathedev.lambdaanticheat.LambdaAntiCheat;
import pl.lambdathedev.lambdaanticheat.check.types.BukkitCheck;
import pl.lambdathedev.lambdaanticheat.check.types.ReceivedPacketsCheck;
import pl.lambdathedev.lambdaanticheat.check.types.SentPacketsCheck;
import pl.lambdathedev.lambdaanticheat.checks.badpackets.BadPacketsA;
import pl.lambdathedev.lambdaanticheat.checks.crits.CritsA;
import pl.lambdathedev.lambdaanticheat.checks.invalidblockbreak.InvalidBlockBreakA;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;
import pl.lambdathedev.lambdaanticheat.packets.PacketsListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChecksManager
{
    private final PlayerData data;
    private final List<Check> checks;

    public ChecksManager(PlayerData data)
    {
        this.data = data;
        checks = new ArrayList<>();

        loadChecks();
    }

    public void loadChecks()
    {
        //And next checks....
        checks.addAll(Arrays.asList(
                new BadPacketsA(data),

                new CritsA(data),

                new InvalidBlockBreakA(data)
        ));

        registerChecks();
    }

    private void registerChecks()
    {
        final LambdaAntiCheat instance = LambdaAntiCheat.getInstance();

        for(Check check : checks)
        {
            if(check.isExperimental() && !LambdaAntiCheat.IS_EXPERIMENTAL) continue;

            switch (check.getType())
            {
                case BUKKIT:
                    Bukkit.getServer().getPluginManager().registerEvents((BukkitCheck)check, instance);
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
