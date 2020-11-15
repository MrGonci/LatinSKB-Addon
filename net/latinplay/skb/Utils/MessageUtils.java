package net.latinplay.skb.Utils;

import net.latinplay.skb.Utils.Interfaces.StringUtils;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class MessageUtils {
    public static void listaItemsMsg(Player p){
        p.sendMessage("&a");
        p.sendMessage(StringUtils.toColor("&6Latin&eSkyblock &7| &8Items"));
        p.sendMessage("&a");
        p.sendMessage(StringUtils.toColor(" &fZeus | &8Nombre: &7Hacha de Zeus "));
        p.sendMessage(StringUtils.toColor(" &fThor | &8Nombre: &7Mazo de thor"));
        p.sendMessage("&a");
    }
    public static void itemHelpMsg(Player p){
        p.sendMessage(StringUtils.toColor("&a"));
        p.sendMessage(StringUtils.toColor("&6Latin&eSkyblock &7| &8Items"));
        p.sendMessage(StringUtils.toColor("&a"));
        p.sendMessage(StringUtils.toColor(" &a/lskb "));
        p.sendMessage(StringUtils.toColor(" &a/lskb items dar (nombre del item)"));
        p.sendMessage(StringUtils.toColor("&a"));
    }
    public static void GlobalItemHelp(Player p){
        p.sendMessage(StringUtils.toColor("&a"));
        p.sendMessage(StringUtils.toColor("&6Latin&eSkyblock &7| &8Items"));
        p.sendMessage(StringUtils.toColor("&a"));
        p.sendMessage(StringUtils.toColor(" &a/lskb items comandos"));
        p.sendMessage(StringUtils.toColor(" &a/recivirlibro"));
        p.sendMessage(StringUtils.toColor("&a"));
    }

    public static void giveMessageAtBuy(Player p, TypeItem Items){
        switch (Items){
            case ZEUS:
                p.sendMessage(StringUtils.toColor("&aHas comprado el hacha de Zeus"));
                break;
            case THOR:
                p.sendMessage(StringUtils.toColor("&aHas comprado el mazo de thor"));
                break;
            default:
                p.sendMessage(StringUtils.toColor("&c[!] Ocurrio un error en el plugin: &eLatinSKB-Addon&c. Reporta este error en nuestro discord."));
        }
    }

}
