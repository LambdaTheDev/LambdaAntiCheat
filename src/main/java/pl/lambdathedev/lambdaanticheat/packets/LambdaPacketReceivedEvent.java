package pl.lambdathedev.lambdaanticheat.packets;

import io.github.retrooper.packetevents.event.impl.PacketReceiveEvent;

public interface LambdaPacketReceivedEvent
{
    void onPacketReceived(PacketReceiveEvent e);
}
