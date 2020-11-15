package net.latinplay.skb.Utils.Interfaces;

import org.bukkit.ChatColor;

public interface StringUtils {
    static String toColor(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
