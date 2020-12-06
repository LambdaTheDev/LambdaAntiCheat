package pl.lambdathedev.lambdaanticheat.checks;

import org.bukkit.event.Listener;

public class BukkitCheck extends Check implements Listener
{
    public BukkitCheck(String name, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        super(name, CheckType.BUKKIT, maxViolations, isBannable, isExperimental);
    }
}
