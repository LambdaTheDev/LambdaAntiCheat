package pl.lambdathedev.lambdaanticheat.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.lambdathedev.lambdaanticheat.LambdaAntiCheat;

public class OnPlayerQuit implements Listener
{
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e)
    {
        LambdaAntiCheat.getInstance().getPlayerData().remove(e.getPlayer().getUniqueId());
        //MessageUtil.notifyConsole("Player " + e.getPlayer().getName() + "(" + e.getPlayer().getUniqueId() + ") has left the server and has been unloaded from LAC.");
    }
}
