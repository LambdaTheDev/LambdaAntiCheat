package pl.lambdathedev.lambdaanticheat.packets;

import io.github.retrooper.packetevents.packettype.PacketType;

public class PacketInfo
{
    public static boolean isFlying(byte type)
    {
        return type == PacketType.Client.FLYING
                || type == PacketType.Client.POSITION
                || type == PacketType.Client.POSITION_LOOK
                || type == PacketType.Client.LOOK;
    }

    public static boolean isPosition(byte type)
    {
        return type == PacketType.Client.POSITION
                || (type == PacketType.Client.POSITION_LOOK);
    }

    public static boolean isRotation(byte type)
    {
        return type == PacketType.Client.POSITION_LOOK
                || type == PacketType.Client.LOOK;
    }

    public static boolean isBlockPlace(byte type)
    {
        return type == PacketType.Client.USE_ITEM
                || type == PacketType.Client.BLOCK_PLACE;
    }
}
