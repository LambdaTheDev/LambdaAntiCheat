package pl.lambdathedev.lambdaanticheat;

import io.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.utils.server.ServerVersion;
import org.bukkit.plugin.java.JavaPlugin;
import pl.lambdathedev.lambdaanticheat.checks.ChecksManager;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;
import pl.lambdathedev.lambdaanticheat.listeners.OnPlayerJoin;
import pl.lambdathedev.lambdaanticheat.listeners.OnPlayerQuit;

import java.util.HashMap;
import java.util.UUID;

public final class LambdaAntiCheat extends JavaPlugin
{
    public static LambdaAntiCheat instance;
    public static final String STAFF_PERMISSION = "lac.staff";

    public HashMap<UUID, PlayerData> playerData;
    public ChecksManager manager;

    @Override
    public void onLoad()
    {
        PacketEvents.load();
    }

    @Override
    public void onEnable()
    {
        PacketEvents.getSettings().backupServerVersion(ServerVersion.v_1_16_4);
        playerData = new HashMap<>();
        manager = new ChecksManager();
        registerListeners();

        PacketEvents.init(this);
        instance = this;
    }

    @Override
    public void onDisable()
    {
        PacketEvents.stop();
    }

    private void registerListeners()
    {
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerQuit(), this);
    }
}
