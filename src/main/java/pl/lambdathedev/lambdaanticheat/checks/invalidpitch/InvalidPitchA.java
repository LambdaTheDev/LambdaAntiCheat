package pl.lambdathedev.lambdaanticheat.checks.invalidpitch;

import io.github.retrooper.packetevents.event.impl.PacketReceiveEvent;
import io.github.retrooper.packetevents.packettype.PacketType;
import pl.lambdathedev.lambdaanticheat.checks.BukkitCheck;
import pl.lambdathedev.lambdaanticheat.checks.ReceivedPacketsCheck;
import pl.lambdathedev.lambdaanticheat.packets.PacketInfo;

public class InvalidPitchA extends ReceivedPacketsCheck
{
    public InvalidPitchA(String name, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        super(name, maxViolations, isBannable, isExperimental);
    }

    @Override
    public void onPacketReceived(PacketReceiveEvent e)
    {
        PacketInfo info = new PacketInfo(e.getPacketId());
        if(info.isFlying())
        {
            final float pitch = Math.abs(e.getPlayer().getLocation().getPitch());
            if(pitch > 90f)
            {
                report(e.getPlayer());
            }
        }
    }
}
