package pl.lambdathedev.lambdaanticheat.checks;

import org.bukkit.entity.Player;
import pl.lambdathedev.lambdaanticheat.LambdaAntiCheat;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;
import pl.lambdathedev.lambdaanticheat.utils.MessageUtil;

public abstract class Check
{
    private final PlayerData playerData;
    private final String name;
    private final CheckType type;
    private final int maxViolations;
    private final boolean isBannable;
    private final boolean isExperimental;

    public Check(PlayerData data, String name, CheckType type, int maxViolations, boolean isBannable, boolean isExperimental)
    {
        this.playerData = data;
        this.name = name;
        this.type = type;
        this.maxViolations = maxViolations;
        this.isBannable = isBannable;
        this.isExperimental = isExperimental;
    }

    public void report()
    {
        report("none");
    }

    public void report(String content)
    {
    }

    public PlayerData getPlayerData()
    {
        return playerData;
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
