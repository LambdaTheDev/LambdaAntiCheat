package pl.lambdathedev.lambdaanticheat;

import io.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.utils.server.ServerVersion;
import org.bukkit.plugin.java.JavaPlugin;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;
import pl.lambdathedev.lambdaanticheat.listeners.OnPlayerJoin;
import pl.lambdathedev.lambdaanticheat.listeners.OnPlayerQuit;
import pl.lambdathedev.lambdaanticheat.packets.PacketsListener;

import java.util.HashMap;
import java.util.UUID;

public final class LambdaAntiCheat extends JavaPlugin
{
    public static final String STAFF_PERMISSION = "lac.staff";
    public static final boolean IS_EXPERIMENTAL = false;
    private static LambdaAntiCheat instance;

    private HashMap<UUID, PlayerData> playerData;

    @Override
    public void onLoad()
    {
        PacketEvents.load();
    }

    @Override
    public void onEnable()
    {
        playerData = new HashMap<>();

        PacketEvents.getSettings().backupServerVersion(ServerVersion.v_1_16_4);
        PacketEvents.getAPI().getEventManager().registerListener(new PacketsListener());
        PacketEvents.init(this);

        loadConfig();
        registerListeners();

        instance = this;
    }

    @Override
    public void onDisable()
    {
        PacketEvents.stop();
    }

    private void registerListeners()
    {
        //Bukkit listeners
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerQuit(), this);
    }

    private void loadConfig()
    {

    }

    public static LambdaAntiCheat getInstance()
    {
        return instance;
    }

    public HashMap<UUID, PlayerData> getPlayerData()
    {
        return playerData;
    }
}
