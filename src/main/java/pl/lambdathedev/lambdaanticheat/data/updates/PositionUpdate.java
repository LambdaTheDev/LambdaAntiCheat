package pl.lambdathedev.lambdaanticheat.data.updates;

import org.bukkit.Location;

public final class PositionUpdate
{
    private final Location from;
    private final Location destination;
    private final boolean onGround;

    public PositionUpdate(Location from, Location destination, boolean onGround)
    {
        this.from = from;
        this.destination = destination;
        this.onGround = onGround;
    }

    public Location getFrom()
    {
        return from;
    }

    public Location getDestination()
    {
        return destination;
    }

    public boolean isOnGround()
    {
        return onGround;
    }
}
