package pl.lambdathedev.lac;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pl.lambdathedev.lac.checks.Check;

import java.util.HashMap;

public final class LambdaAntiCheat extends JavaPlugin
{
    public static LambdaAntiCheat LAC;
    public static boolean isExperimental = false;

    private HashMap<Player, HashMap<Check, Integer>> violations;

    @Override
    public void onEnable()
    {
        LAC = this;
        violations = new HashMap<>();
    }

    @Override
    public void onDisable()
    {
    }
}
