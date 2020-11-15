package net.latinplay.skb.commands.staff;

import net.latinplay.skb.Utils.Interfaces.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player)sender;
        if (!player.hasPermission("skyblock.fly")) {
            player.sendMessage(StringUtils.toColor("&aSkyblock &8» &cNo tienes permisos para usar esto."));
            return true;
        }
        player.setAllowFlight(!player.getAllowFlight());
        if (player.getAllowFlight()) {
            player.sendMessage(StringUtils.toColor("&aSkyblock &8» &2Su vuelo ha sido activado"));
        }
        else {
            player.sendMessage(StringUtils.toColor("&aSkyblock &8» &cSu vuelo ha sido desactivado."));
        }
        return true;
    }
}
