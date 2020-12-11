package pl.lambdathedev.lambdaanticheat.data;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import pl.lambdathedev.lambdaanticheat.checks.Check;

import java.util.HashMap;

public class PlayerData
{
    private Player player;

    //SyncVars
    private final SyncVar<Float> cps = new SyncVar<>(0f);
    private final SyncVar<Integer> ticks = new SyncVar<>(0);
    private final SyncVar<Entity> currentTarget = new SyncVar<>(null);
    private final SyncVar<Long> ping = new SyncVar<>(0L);
    private final SyncVar<Long> transactionPing = new SyncVar<>(0L);
}