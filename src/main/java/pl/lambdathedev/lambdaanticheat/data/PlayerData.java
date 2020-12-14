package pl.lambdathedev.lambdaanticheat.data;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import pl.lambdathedev.lambdaanticheat.checks.Check;
import pl.lambdathedev.lambdaanticheat.data.updates.PositionUpdate;
import pl.lambdathedev.lambdaanticheat.data.updates.RotationUpdate;

import java.util.HashMap;

public class PlayerData
{
    private Player player;

    //SyncVars
    private final SyncVar<Boolean> cinematic = new SyncVar<>(false);
    private final SyncVar<Boolean> sprinting = new SyncVar<>(false);
    private final SyncVar<Double> cps = new SyncVar<>(0.0);
    private final SyncVar<Double> attackRate = new SyncVar<>(0.0);
    private final SyncVar<Entity> currentTarget = new SyncVar<>(null);
    private final SyncVar<Long> transactionPing = new SyncVar<>(0L);
    private final SyncVar<Long> keepAlivePing = new SyncVar<>(0L);
    private final SyncVar<Integer> joined = new SyncVar<>(0);
    private final SyncVar<Integer> ticks = new SyncVar<>(0);

    private final SyncVar<RotationUpdate> rotationUpdate = new SyncVar<>(new RotationUpdate(0, 0));
    private final SyncVar<PositionUpdate> positionUpdate = new SyncVar<>(new PositionUpdate(null, null, false));
}