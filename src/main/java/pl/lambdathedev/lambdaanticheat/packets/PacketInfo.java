package pl.lambdathedev.lambdaanticheat.packets;

import io.github.retrooper.packetevents.packettype.PacketType;

public class PacketInfo
{
    private byte type;
    private boolean flying;
    private boolean position;
    private boolean rotation;
    private boolean blockPlace;

    public PacketInfo(byte type)
    {
        this.type = type;
        this.flying = type == PacketType.Client.FLYING
                || type == PacketType.Client.POSITION
                || type == PacketType.Client.POSITION_LOOK
                || type == PacketType.Client.LOOK;

        this.position = type == PacketType.Client.POSITION
                || (type == PacketType.Client.POSITION_LOOK);

        this.rotation = type == PacketType.Client.POSITION_LOOK
                || type == PacketType.Client.LOOK;

        this.blockPlace = type == PacketType.Client.USE_ITEM
                || type == PacketType.Client.BLOCK_PLACE;
    }

    public byte getType()
    {
        return type;
    }

    public boolean isFlying()
    {
        return flying;
    }

    public boolean isPosition()
    {
        return position;
    }

    public boolean isRotation()
    {
        return rotation;
    }

    public boolean isBlockPlace()
    {
        return blockPlace;
    }
}
