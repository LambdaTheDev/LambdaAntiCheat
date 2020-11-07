package pl.lambdathedev.lac.checks.combat;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pl.lambdathedev.lac.checks.Check;
import pl.lambdathedev.lac.checks.CheckType;

public class Reach extends Check
{
    public Reach() {
        super(CheckType.COMBAT, "Reach", 5);
    }

    public void onAttack(EntityDamageByEntityEvent e)
    {
        if(!(e.getDamager() instanceof Player)) return;

        float range = 4f;
        if(((Player) e.getDamager()).getGameMode() == GameMode.CREATIVE) range = 4.5f;


    }
}
