package net.latinplay.skb.Events.skbevents;

import net.latinplay.skb.Utils.Interfaces.SKAddon;
import net.latinplay.skb.Utils.Interfaces.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;


public class SPlayerJoinEvent implements Listener, SKAddon {
    @EventHandler
    public void PlayerJoin(PlayerLoginEvent e){
        Player p = e.getPlayer();
        if(!p.hasPlayedBefore()) {
            p.performCommand("recivirlibro");
        }
    }
    @EventHandler
    public void PlayerJoinAntiGeis(PlayerJoinEvent e){
        if(e.getPlayer().getName().equalsIgnoreCase("Establecido ")){
            e.getPlayer().kickPlayer("&cMaricones Extremos no aceptados en skyblock.");
        }
    }
}
