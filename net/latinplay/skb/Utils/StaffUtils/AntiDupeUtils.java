package net.latinplay.skb.Utils.StaffUtils;

import net.latinplay.skb.Utils.Interfaces.ServerSender;
import net.latinplay.skb.Utils.Interfaces.StringUtils;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashSet;

public class AntiDupeUtils {
    public static ArrayList<String> antidupe = new ArrayList<>();

    public static void setPlayerAntidupe(Player p){
        antidupe.add(p.getName());
        p.sendMessage(StringUtils.toColor("&aActivaste las alertas del sistema AntiDUpe"));
        ServerSender.send("[Logs] " + p.getName() + " activo las alertas del antidupe");
    }
    public static void removePlayerAndiDupe(Player p){
        antidupe.remove(p.getName());
        p.sendMessage(StringUtils.toColor("&cDesactivaste las alertas del sistema AntiDUpe"));
        ServerSender.send("[Logs] " + p.getName() + " desactivo las alertas del antidupe");
    }

}
