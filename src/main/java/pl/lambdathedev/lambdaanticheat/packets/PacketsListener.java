package pl.lambdathedev.lambdaanticheat.packets;

import io.github.retrooper.packetevents.event.PacketListenerDynamic;
import io.github.retrooper.packetevents.event.impl.PacketReceiveEvent;
import io.github.retrooper.packetevents.event.impl.PacketSendEvent;
import io.github.retrooper.packetevents.event.priority.PacketEventPriority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacketsListener extends PacketListenerDynamic
{
    private static PacketsListener instance;

    private final List<LambdaPacketReceivedEvent> packetReceivedListeners;
    private final List<LambdaPacketSentEvent> packetSentListeners;

    public PacketsListener()
    {
        super(PacketEventPriority.MONITOR);

        packetReceivedListeners = new ArrayList<>();
        packetSentListeners = new ArrayList<>();

        instance = this;
    }

    public void registerPacketReceiveListener(LambdaPacketReceivedEvent... listeners)
    {
        packetReceivedListeners.addAll(Arrays.asList(listeners));
    }

    public void registerPacketSendListener(LambdaPacketSentEvent... listeners)
    {
        packetSentListeners.addAll(Arrays.asList(listeners));
    }

    @Override
    public void onPacketReceive(PacketReceiveEvent event)
    {
        for(LambdaPacketReceivedEvent listener : packetReceivedListeners)
        {
            listener.onPacketReceived(event);
        }
    }

    @Override
    public void onPacketSend(PacketSendEvent event)
    {
        for(LambdaPacketSentEvent listener : packetSentListeners)
        {
            listener.onPacketSent(event);
        }
    }

    public static PacketsListener getInstance()
    {
        return instance;
    }
}
