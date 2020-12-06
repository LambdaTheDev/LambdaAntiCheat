package pl.lambdathedev.lambdaanticheat.packets;

import io.github.retrooper.packetevents.event.impl.PacketSendEvent;

public interface LambdaPacketSentEvent
{
    void onPacketSent(PacketSendEvent e);
}
