package pl.lambdathedev.lambdaanticheat.checks;

import io.github.retrooper.packetevents.PacketEvents;
import org.bukkit.Bukkit;
import pl.lambdathedev.lambdaanticheat.LambdaAntiCheat;
import pl.lambdathedev.lambdaanticheat.checks.reach.ReachA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChecksManager
{
    private List<Check> checks;

    public ChecksManager()
    {
        checks = new ArrayList<>();
        collectChecks();
        registerChecks();
    }

    private void collectChecks()
    {
        checks.addAll(
                (Collection<? extends Check>) new ReachA("Reach A", 7, false, false)
        );
    }

    private void registerChecks()
    {
        for(Check check : checks)
        {
            Bukkit.getServer().getPluginManager().registerEvents(check, LambdaAntiCheat.instance);
            PacketEvents.getAPI().getEventManager().registerListener(check);
        }
    }
}
