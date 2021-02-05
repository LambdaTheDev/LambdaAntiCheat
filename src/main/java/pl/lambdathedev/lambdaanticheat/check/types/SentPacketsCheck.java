package pl.lambdathedev.lambdaanticheat.check.types;

import io.github.retrooper.packetevents.event.impl.PacketSendEvent;
import pl.lambdathedev.lambdaanticheat.check.Check;
import pl.lambdathedev.lambdaanticheat.check.CheckType;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;
import pl.lambdathedev.lambdaanticheat.packets.LambdaPacketSentEvent;

public class SentPacketsCheck extends Check implements LambdaPacketSentEvent
{
    public SentPacketsCheck(PlayerData data, String checkName, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        super(data, checkName, CheckType.SENT_PACKET, maxViolations, isBannable, isExperimental);
    }

    @Override
    public void onPacketSent(final PacketSendEvent e)
    {

    }
}
