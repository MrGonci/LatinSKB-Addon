package net.latinplay.skb.commands.staff;

import net.latinplay.skb.Utils.CustomItems.*;
import net.latinplay.skb.Utils.Interfaces.ServerSender;
import net.latinplay.skb.Utils.Interfaces.StringUtils;
import net.latinplay.skb.Utils.MessageUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LSkyblockCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("latinstaff.items")) {
                if (args[0].equalsIgnoreCase("items")) {
                    if (args[1].equalsIgnoreCase("comandos")) {
                        MessageUtils.itemHelpMsg(p);
                    } else if (args[1].equalsIgnoreCase("lista")) {
                        MessageUtils.listaItemsMsg(p);
                    }
                    else if (args[1].equalsIgnoreCase("dar")) {
                        if (args[2].equalsIgnoreCase("zeus")) {
                            //SkyblockCustomItems.giveAxe(p);
                            try{
                                SkyblockCustomItems.giveAxe(p);
                            }catch (Exception ex){
                                ex.printStackTrace();
                                ServerSender.send("&cPlugin think that player is null");
                            }
                            p.sendMessage(StringUtils.toColor(""));
                            p.sendMessage(StringUtils.toColor("&aHas recivido el hacha de Zeus"));
                            p.sendMessage(StringUtils.toColor(""));
                        } else if (args[2].equalsIgnoreCase("thor")) {
                            //SkyblockCustomItems.giveMazo(p);
                            try{
                                SkyblockCustomItems.giveMazo(p);
                            }catch (Exception ex){
                                ex.printStackTrace();
                                ServerSender.send("&cPlugin think that player is null");
                            }
                            p.sendMessage(StringUtils.toColor(""));
                            p.sendMessage(StringUtils.toColor("&aHas recivido el mazo the thor"));
                            p.sendMessage(StringUtils.toColor(""));
                        }else{
                            MessageUtils.listaItemsMsg(p);
                        }
                    }else{
                        MessageUtils.GlobalItemHelp(p);
                    }
                } else {
                    p.sendMessage("&a");
                    p.sendMessage(StringUtils.toColor("&6Latin&eSkyblock &7| &8Items"));
                    p.sendMessage("&a");
                    p.sendMessage(StringUtils.toColor(" &fZeus | &8Nombre: &7Hacha de Zeus "));
                    p.sendMessage(StringUtils.toColor(" &fThor | &8Nombre: &7Mazo de thor"));
                    p.sendMessage("&a");
                }
            }else{
                p.sendMessage(ChatColor.RED + "No tienes permisos para usar este comando");
            }
        }else{
            sender.sendMessage("&cEste comando solo se puede utilizar dentro del juego.");
        }
        return false;
    }
}
