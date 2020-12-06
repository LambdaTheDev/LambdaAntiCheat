package pl.lambdathedev.lambdaanticheat.data;

import org.bukkit.entity.Player;
import pl.lambdathedev.lambdaanticheat.checks.Check;
import pl.lambdathedev.lambdaanticheat.utils.PunishmentUtil;

import java.util.HashMap;

public class PlayerData
{
    private Player player;
    private HashMap<Check, Integer> violations;

    public PlayerData(Player p)
    {
        player = p;
        violations = new HashMap<>();
    }

    public Player getPlayer()
    {
        return player;
    }
}