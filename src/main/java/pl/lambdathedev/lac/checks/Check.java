package pl.lambdathedev.lac.checks;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import pl.lambdathedev.lac.LambdaAntiCheat;

import java.util.HashMap;

public class Check implements Listener
{
    public final LambdaAntiCheat LAC = LambdaAntiCheat.LAC;

    private CheckType type;
    private String name;
    private int maxViolations;
    private HashMap<Player, Integer> violations;

    public Check(CheckType type, String name, int maxViolations)
    {
        this.type = type;
        this.name = name;
        this.maxViolations = maxViolations;
        violations = new HashMap<>();
    }

    public LambdaAntiCheat getLAC() {
        return LAC;
    }

    public CheckType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getMaxViolations() {
        return maxViolations;
    }

    public HashMap<Player, Integer> getViolations() {
        return violations;
    }
}
