package net.latinplay.skb.Events.CustomEvents;

import net.latinplay.skb.Utils.Interfaces.ServerSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.StringUtil;

public class BookOpenEVent extends Event {
    private static final HandlerList handlers = new HandlerList();

    ItemStack item;
    Player duper;

    public BookOpenEVent(Player dupe, ItemStack item) {
        this.duper = dupe;
        this.item = item;
        ServerSender.send("&7(AntiDupe) &c" + duper.getName() + " &fIntento duplicar usando el bug del libro");
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public ItemStack getItem(){
        return item;
    }
    public Player getPlayer(){
        return duper;
    }
    public HandlerList getHandlersList() {
        return handlers;
    }
}
