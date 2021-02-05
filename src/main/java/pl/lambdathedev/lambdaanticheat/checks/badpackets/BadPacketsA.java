package pl.lambdathedev.lambdaanticheat.checks.badpackets;

import io.github.retrooper.packetevents.event.impl.PacketReceiveEvent;
import pl.lambdathedev.lambdaanticheat.check.types.ReceivedPacketsCheck;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;
import pl.lambdathedev.lambdaanticheat.packets.PacketInfo;

public class BadPacketsA extends ReceivedPacketsCheck
{
    public BadPacketsA(PlayerData data)
    {
        super(data, "Bad Packets (A)", 10, false, false);
    }

    @Override
    public void onPacketReceived(final PacketReceiveEvent e)
    {
        if(PacketInfo.isFlying(e.getPacketId()))
        {
            final float pitch = Math.abs(e.getPlayer().getLocation().getPitch());
            if(pitch > 90f)
            {
                report("pitch=" + pitch);
            }
        }
    }
}
