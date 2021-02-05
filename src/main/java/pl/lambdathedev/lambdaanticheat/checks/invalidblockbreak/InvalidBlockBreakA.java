package pl.lambdathedev.lambdaanticheat.checks.invalidblockbreak;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import pl.lambdathedev.lambdaanticheat.check.types.BukkitCheck;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;

public class InvalidBlockBreakA extends BukkitCheck
{
    public InvalidBlockBreakA(PlayerData data)
    {
        super(data, "Invalid Block Break (A)", 5, false, false);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e)
    {
        final Player player = e.getPlayer();
        final Material itemInHand = player.getInventory().getItemInMainHand().getType();

        final boolean isHoldingSword = itemInHand.name().contains("SWORD");

        if(isHoldingSword && player.getGameMode() == GameMode.CREATIVE)
        {
            final Location blockLocation = e.getBlock().getLocation();
            blockLocation.getBlock().setType(e.getBlock().getType());

            report("Tried to dig " + e.getBlock().getType().toString() + " using " + itemInHand.toString());
        }
    }
}
