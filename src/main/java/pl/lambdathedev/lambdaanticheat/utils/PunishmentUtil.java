package pl.lambdathedev.lambdaanticheat.utils;

import pl.lambdathedev.lambdaanticheat.checks.Check;
import pl.lambdathedev.lambdaanticheat.data.PlayerData;

public class PunishmentUtil
{
    public static void punish(Check check, PlayerData data)
    {
        if(check.isBannable())
        {
            data.getPlayer().kickPlayer("BANNED");
        }
        else
        {
            data.getPlayer().kickPlayer("KICKED");
        }
    }
}
