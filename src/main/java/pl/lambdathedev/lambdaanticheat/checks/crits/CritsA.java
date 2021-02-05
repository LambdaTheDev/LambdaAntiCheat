package pl.lambdathedev.lambdaanticheat.checks.crits;

import io.github.retrooper.packetevents.event.impl.PacketReceiveEvent;
import io.github.retrooper.packetevents.packettype.PacketType;
import io.github.retrooper.packetevents.packetwrappers.in.flying.WrappedPacketInFlying;
import io.github.retrooper.packetevents.packetwrappers.in.useentity.WrappedPacketInUseEntity;
import org.bukkit.Location;
import pl.lambdathedev.lambdaanticheat.check.types.ReceivedPacketsCheck;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;
import pl.lambdathedev.lambdaanticheat.packets.PacketInfo;

public class CritsA extends ReceivedPacketsCheck
{
    private final float groundCheck = 1 / 64f;

    private double lastY = 0.0;

    public CritsA(PlayerData data)
    {
        super(data, "Crits (A)", 5, false, false);
    }

    @Override
    public void onPacketReceived(PacketReceiveEvent e)
    {
        if(PacketInfo.isPosition(e.getPacketId()))
        {
            WrappedPacketInFlying flying = new WrappedPacketInFlying(e.getNMSPacket());
            lastY = flying.getY();
        }

        if(e.getPacketId() == PacketType.Client.USE_ENTITY)
        {
            final WrappedPacketInUseEntity wrapper = new WrappedPacketInUseEntity(e.getNMSPacket());

            if(wrapper.getAction() == WrappedPacketInUseEntity.EntityUseAction.ATTACK)
            {
                final Location playerLocation = e.getPlayer().getLocation();

                getPlayerData().getPlayer().sendMessage("mod Y = " + playerLocation.getY() % groundCheck);
                getPlayerData().getPlayer().sendMessage("delta Y = " + (playerLocation.getY() - lastY));
            }
        }
    }
}
