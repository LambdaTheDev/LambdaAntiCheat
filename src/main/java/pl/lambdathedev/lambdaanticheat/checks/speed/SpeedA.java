package pl.lambdathedev.lambdaanticheat.checks.speed;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import pl.lambdathedev.lambdaanticheat.checks.BukkitCheck;

public class SpeedA extends BukkitCheck
{
    private double lastDistance;
    private boolean lastOnGround;

    public SpeedA(String name, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        super(name, maxViolations, isBannable, isExperimental);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e)
    {
        double distanceX = e.getTo().getX() - e.getFrom().getX();
        double distanceZ = e.getTo().getZ() - e.getFrom().getZ();
        double distance = (distanceX * distanceX) + (distanceZ * distanceZ);

        double lastDistance = this.lastDistance;
        this.lastDistance = distance;

        LivingEntity entity = e.getPlayer();
        boolean isGrounded = entity.isOnGround();

        float friction = 0.91f;
    }
}
