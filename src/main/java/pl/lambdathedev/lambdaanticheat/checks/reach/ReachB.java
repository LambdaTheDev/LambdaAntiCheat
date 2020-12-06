package pl.lambdathedev.lambdaanticheat.checks.reach;

import io.github.retrooper.packetevents.event.impl.PacketReceiveEvent;
import io.github.retrooper.packetevents.packettype.PacketType;
import io.github.retrooper.packetevents.packetwrappers.out.animation.WrappedPacketOutAnimation;
import pl.lambdathedev.lambdaanticheat.checks.Check;

public class ReachB extends Check
{
    public ReachB(String name, int maxViolations, boolean isBannable, boolean isExperimental) {
        super(name, maxViolations, isBannable, isExperimental);
    }

    public void onPacketReceive(PacketReceiveEvent e)
    {
        if(e.getPacketId() == PacketType.Client.ARM_ANIMATION)
        {
            WrappedPacketOutAnimation packet = new WrappedPacketOutAnimation(e.getNMSPacket());
        }
    }
}
