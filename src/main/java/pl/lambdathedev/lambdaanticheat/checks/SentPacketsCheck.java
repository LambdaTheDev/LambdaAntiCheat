package pl.lambdathedev.lambdaanticheat.checks;

import io.github.retrooper.packetevents.event.impl.PacketSendEvent;
import pl.lambdathedev.lambdaanticheat.packets.LambdaPacketSentEvent;

public class SentPacketsCheck extends Check implements LambdaPacketSentEvent
{
    public SentPacketsCheck(String name, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        super(name, CheckType.SENT_PACKET, maxViolations, isBannable, isExperimental);
    }

    @Override
    public void onPacketSent(PacketSendEvent e)
    {

    }
}
