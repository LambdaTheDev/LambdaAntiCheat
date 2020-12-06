package pl.lambdathedev.lambdaanticheat.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import pl.lambdathedev.lambdaanticheat.LambdaAntiCheat;

import java.util.Collection;

public class MessageUtil
{
    public static void notifyStaff(String message)
    {
        Collection<? extends Player> onlinePlayers =  Bukkit.getServer().getOnlinePlayers();
        for(Player player : onlinePlayers)
        {
            if(player.hasPermission(LambdaAntiCheat.STAFF_PERMISSION))
            {
                player.sendMessage(message);
            }
        }
    }

    public static void notifyConsole(String message)
    {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(message);
    }
}
