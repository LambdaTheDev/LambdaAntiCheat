package pl.lambdathedev.lambdaanticheat.checks;

import io.github.retrooper.packetevents.event.impl.PacketReceiveEvent;
import pl.lambdathedev.lambdaanticheat.packets.LambdaPacketReceivedEvent;

public class ReceivedPacketsCheck extends Check implements LambdaPacketReceivedEvent
{
    public ReceivedPacketsCheck(String name, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        super(name, CheckType.RECEIVED_PACKET, maxViolations, isBannable, isExperimental);
    }

    @Override
    public void onPacketReceived(PacketReceiveEvent e)
    {

    }
}
