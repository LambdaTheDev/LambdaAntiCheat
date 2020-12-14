package pl.lambdathedev.lambdaanticheat.data.updates;

public final class RotationUpdate
{
    private float deltaYaw;
    private float deltaPitch;

    public RotationUpdate(float deltaYaw, float deltaPitch)
    {
        this.deltaYaw = deltaYaw;
        this.deltaPitch = deltaPitch;
    }

    public float getDeltaYaw()
    {
        return deltaYaw;
    }

    public void setDeltaYaw(float deltaYaw)
    {
        this.deltaYaw = deltaYaw;
    }

    public float getDeltaPitch()
    {
        return deltaPitch;
    }

    public void setDeltaPitch(float deltaPitch)
    {
        this.deltaPitch = deltaPitch;
    }
}
