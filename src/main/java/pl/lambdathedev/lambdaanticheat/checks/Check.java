package pl.lambdathedev.lambdaanticheat.checks;

import io.github.retrooper.packetevents.event.PacketListenerDynamic;
import io.github.retrooper.packetevents.event.priority.PacketEventPriority;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import pl.lambdathedev.lambdaanticheat.LambdaAntiCheat;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;
import pl.lambdathedev.lambdaanticheat.utils.MessageUtil;

public abstract class Check extends PacketListenerDynamic implements Listener
{
    private String name;
    private int maxViolations;
    private boolean isBannable;
    private boolean isExperimental;

    public Check(String name, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        super(PacketEventPriority.HIGHEST);
    }

    public void report(Player p)
    {
        report(p, "No additional info provided.");
    }

    public void report(Player p, String content)
    {
        PlayerData data = LambdaAntiCheat.instance.playerData.get(p.getUniqueId());

        //Send message to the console and online staff members
    }
}
