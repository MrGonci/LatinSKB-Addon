package net.latinplay.skb.Utils.Interfaces;

import net.latinplay.skb.Main;
import org.bukkit.plugin.java.JavaPlugin;

public interface SKAddon {
    Main plugin = (Main) JavaPlugin.getProvidingPlugin(Main.class);
}
