package pl.lambdathedev.lambdaanticheat.check;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import pl.lambdathedev.lambdaanticheat.LambdaAntiCheat;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;

@Getter
@AllArgsConstructor
public abstract class Check
{
    private final PlayerData playerData;
    private final String checkName;
    private final CheckType type;
    private final int maxViolations;
    private final boolean isBannable;
    private final boolean isExperimental;

    protected void report() { report("none"); }

    protected void report(String additionalInfo)
    {
        String message = String.format("&l&cLambda&4AntiCheat &r&6 -> &a%s &cis suspected of: &a%s &7(&cXX&8/&c%s&7)&c. Additional information: &6%s&c.",
                "username", checkName, maxViolations, additionalInfo);

        Bukkit.broadcast(ChatColor.translateAlternateColorCodes('&', message), LambdaAntiCheat.STAFF_PERMISSION);
    }
}
