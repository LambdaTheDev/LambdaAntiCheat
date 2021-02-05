package pl.lambdathedev.lambdaanticheat.check.types;

import org.bukkit.event.Listener;
import pl.lambdathedev.lambdaanticheat.check.Check;
import pl.lambdathedev.lambdaanticheat.check.CheckType;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;

public class BukkitCheck extends Check implements Listener
{
    public BukkitCheck(PlayerData data, String checkName, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        super(data, checkName, CheckType.BUKKIT, maxViolations, isBannable, isExperimental);
    }
}
