package pl.lambdathedev.lambdaanticheat.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.lambdathedev.lambdaanticheat.LambdaAntiCheat;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;
import pl.lambdathedev.lambdaanticheat.utils.MessageUtil;

public class OnPlayerJoin implements Listener
{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        PlayerData data = new PlayerData(e.getPlayer());
        LambdaAntiCheat.getInstance().getPlayerData().put(e.getPlayer().getUniqueId(), data);
        MessageUtil.notifyConsole("Player " + e.getPlayer().getName() + " (" + e.getPlayer().getUniqueId() + ") has joined the server and has been loaded by LAC.");
    }
}
