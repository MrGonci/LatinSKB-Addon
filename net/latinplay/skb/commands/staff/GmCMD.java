package net.latinplay.skb.commands.staff;

import net.latinplay.skb.Utils.Interfaces.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmCMD implements CommandExecutor {
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        Player p = (Player)s;
        if (s.hasPermission("skyblock.gamemode"))
            if (args.length == 0) {
                s.sendMessage(StringUtils.toColor("&aSkyblock &8» &cUso /gamemode [c, s, a]"));
            } else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(StringUtils.toColor("&aSkyblock &8» &eModo de juego cambiado a: &2Survival"));
            } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(StringUtils.toColor("&aSkyblock &8» &eModo de juego cambiado a: &eCreativo"));
            } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(StringUtils.toColor("&aSkyblock &8» &eModo de juego cambiado a: &cAventura"));
            }
        return false;
    }
}

