package net.latinplay.skb.Events.skbevents;

import net.latinplay.skb.Utils.Interfaces.StringUtils;
import net.latinplay.skb.Utils.StaffUtils.AntiDupeUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.ItemStack;

import java.nio.charset.Charset;

public class PlayerBlockItem implements Listener {
    @EventHandler
    public void onPlayerEditBook(final PlayerEditBookEvent event) {
        for (final String page : event.getNewBookMeta().getPages()) {
            if (!this.isValidCharset(page)) {
                ItemStack item = new ItemStack(Material.WRITTEN_BOOK, 64);
                event.setCancelled(true);
                Player duper = event.getPlayer();
                for (Player staff : Bukkit.getOnlinePlayers()){
                    if(staff.hasPermission("latinstaff.staff")){
                        if(AntiDupeUtils.antidupe.contains(staff.getName())) {
                            staff.sendMessage(StringUtils.toColor("&7(Anti-Dupe) &c" + duper.getName() + "&f Intento usar un libro con caracteres ilegales."));
                        }
                    }
                }
            }
        }
    }


    public boolean isValidCharset(final String input) {
        return Charset.forName("ISO-8859-1").newEncoder().canEncode(input);
    }
}
