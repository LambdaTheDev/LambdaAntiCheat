package pl.lambdathedev.lambdaanticheat.data.managers;

import org.bukkit.Bukkit;
import pl.lambdathedev.lambdaanticheat.LambdaAntiCheat;
import pl.lambdathedev.lambdaanticheat.check.Check;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;

import java.util.HashMap;

public class ViolationsManager
{
    private final PlayerData playerData;
    private final HashMap<Check, Integer> violations;

    public ViolationsManager(PlayerData data)
    {
        playerData = data;
        violations = new HashMap<>();

        scheduleViolationsReset();
    }

    public void violate(Check check)
    {
        final int currentViolations = violations.getOrDefault(check, 0) + 1;
        if(currentViolations > check.getMaxViolations())
        {
            punish(check);
        }
    }

    public void punish(Check check)
    {
        if(check.isBannable())
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban USERNAME Do not hac"); //todo: add Player
            return;
        }

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick USERNAME Do not hac");
        //todo: Player.kick("Do not hac");
    }

    private void scheduleViolationsReset()
    {
        long tenMinutes = 20L * 60L * 10;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(LambdaAntiCheat.getInstance(), violations::clear, tenMinutes, tenMinutes);
    }
}
