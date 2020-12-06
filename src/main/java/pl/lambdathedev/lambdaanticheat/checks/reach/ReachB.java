package pl.lambdathedev.lambdaanticheat.checks.reach;

import io.github.retrooper.packetevents.event.impl.PacketReceiveEvent;
import io.github.retrooper.packetevents.packettype.PacketType;
import io.github.retrooper.packetevents.packetwrappers.in.useentity.WrappedPacketInUseEntity;
import io.github.retrooper.packetevents.packetwrappers.out.animation.WrappedPacketOutAnimation;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import pl.lambdathedev.lambdaanticheat.checks.Check;
import pl.lambdathedev.lambdaanticheat.checks.ReceivedPacketsCheck;

public class ReachB extends ReceivedPacketsCheck
{
    public ReachB(String name, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        super(name, maxViolations, isBannable, isExperimental);
    }

    @Override
    public void onPacketReceived(PacketReceiveEvent e)
    {
        if(e.getPacketId() == PacketType.Client.USE_ENTITY)
        {
            WrappedPacketInUseEntity wrapper = new WrappedPacketInUseEntity(e.getNMSPacket());

            if(wrapper.getAction() == WrappedPacketInUseEntity.EntityUseAction.ATTACK)
            {
                Location attackerLocation = e.getPlayer().getLocation();
                Location victimLocation = wrapper.getEntity().getLocation();

                attackerLocation.setY(0);
                victimLocation.setY(0);

                final float maxRange = 3.3f;
                final double distance = attackerLocation.distanceSquared(victimLocation);

                if(distance > maxRange * maxRange)
                {
                    report(e.getPlayer(), "distance=" + distance);
                }
            }
        }
    }
}
