package pl.lambdathedev.lambdaanticheat.check.types;

import io.github.retrooper.packetevents.event.impl.PacketReceiveEvent;
import pl.lambdathedev.lambdaanticheat.check.Check;
import pl.lambdathedev.lambdaanticheat.check.CheckType;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;
import pl.lambdathedev.lambdaanticheat.packets.LambdaPacketReceivedEvent;

public class ReceivedPacketsCheck extends Check implements LambdaPacketReceivedEvent
{
    public ReceivedPacketsCheck(PlayerData data, String checkName, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        super(data, checkName, CheckType.RECEIVED_PACKET, maxViolations, isBannable, isExperimental);
    }

    @Override
    public void onPacketReceived(final PacketReceiveEvent e)
    {

    }
}
