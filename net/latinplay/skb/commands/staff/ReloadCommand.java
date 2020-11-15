package net.latinplay.skb.commands.staff;

import net.latinplay.skb.Utils.Interfaces.SKAddon;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor, SKAddon {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender.hasPermission("latinstaff.reload")){
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Config recargada con exto");
        }else{
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNo puedes hacer esto"));
        }
        return false;
    }
}
