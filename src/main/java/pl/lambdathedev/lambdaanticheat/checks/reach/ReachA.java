package pl.lambdathedev.lambdaanticheat.checks.reach;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pl.lambdathedev.lambdaanticheat.checks.Check;

public class ReachA extends Check
{
    public ReachA(String name, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        super(name, maxViolations, isBannable, isExperimental);
    }

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e)
    {
        if(e.getDamager() instanceof Player)
        {
            Location playerLocation = e.getDamager().getLocation();
            Location damagedLocation = e.getEntity().getLocation();

            playerLocation.setY(0);
            damagedLocation.setY(0);

            double distance = playerLocation.distanceSquared(damagedLocation);
            double maxDistance = 3f;
            if(((Player) e.getDamager()).getGameMode() == GameMode.CREATIVE) maxDistance = 6f;

            if(distance > (maxDistance + 0.2) * (maxDistance + 0.2f))
            {
                report((Player) e.getDamager(), "distance=" + Math.sqrt(distance));
            }
        }
    }
}
