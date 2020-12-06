package pl.lambdathedev.lambdaanticheat.checks;

import org.bukkit.entity.Player;
import pl.lambdathedev.lambdaanticheat.LambdaAntiCheat;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;
import pl.lambdathedev.lambdaanticheat.utils.MessageUtil;

public abstract class Check
{
    private final String name;
    private final CheckType type;
    private final int maxViolations;
    private final boolean isBannable;
    private final boolean isExperimental;

    public Check(String name, CheckType type, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        this.name = name;
        this.type = type;
        this.maxViolations = maxViolations;
        this.isBannable = isBannable;
        this.isExperimental = isExperimental;
    }

    public void report(Player p)
    {
        report(p, "No additional info provided");
    }

    public void report(Player p, String content)
    {
        PlayerData data = LambdaAntiCheat.getInstance().getPlayerData().get(p.getUniqueId());
        data.violate(this);
        String message = "LAC VIOLATION >> " + p.getName() + " failed: " + getName() + " (" + data.getViolations(this) + "/" + getMaxViolations() + ")! Additional information: " + content;
        MessageUtil.notifyStaff(message);
    }

    public String getName()
    {
        return name;
    }

    public CheckType getType()
    {
        return type;
    }

    public int getMaxViolations()
    {
        return maxViolations;
    }

    public boolean isBannable()
    {
        return isBannable;
    }

    public boolean isExperimental()
    {
        return isExperimental;
    }
}
