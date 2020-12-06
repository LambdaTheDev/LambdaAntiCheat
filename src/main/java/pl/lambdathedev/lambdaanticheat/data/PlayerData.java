package pl.lambdathedev.lambdaanticheat.data;

import org.bukkit.entity.Player;
import pl.lambdathedev.lambdaanticheat.checks.Check;
import pl.lambdathedev.lambdaanticheat.utils.PunishmentUtil;

import java.util.HashMap;

public class PlayerData
{
    private final Player player;
    private final HashMap<Check, Integer> violations;

    public PlayerData(Player p)
    {
        this.player = p;
        violations = new HashMap<>();
    }

    public Player getPlayer()
    {
        return player;
    }

    public void violate(Check check)
    {
        violations.put(check, violations.getOrDefault(check, 0) + 1);

        if(violations.get(check) > check.getMaxViolations())
        {
            PunishmentUtil.punish(check, this);
        }
    }

    public int getViolations(Check check)
    {
        return violations.getOrDefault(check, 0);
    }

    public void clearViolations()
    {
        violations.clear();
    }
}