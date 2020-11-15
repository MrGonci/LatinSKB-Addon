package net.latinplay.skb.commands;

import net.latinplay.skb.Utils.Interfaces.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class KitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(args.length >= 1){
            if(args[1].equalsIgnoreCase("inicial"))
        }else{
            sender.sendMessage(StringUtils.toColor("&cKits Disponibles: &a7Inicial, VipC, VipG, VipD, VipE"));
        }
        return false;
    }
}
