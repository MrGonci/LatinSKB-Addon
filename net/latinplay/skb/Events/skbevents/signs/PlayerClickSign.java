package net.latinplay.skb.Events.skbevents.signs;

import com.mojang.brigadier.Message;
import net.latinplay.skb.Events.skbevents.CustomItemsEvents;
import net.latinplay.skb.Main;
import net.latinplay.skb.Utils.Interfaces.ServerSender;
import net.latinplay.skb.Utils.Interfaces.StringUtils;
import net.latinplay.skb.Utils.MessageUtils;
import net.latinplay.skb.Utils.TypeItem;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import net.latinplay.skb.Utils.CustomItems.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class PlayerClickSign implements Listener {

    @EventHandler
    public void LSignChangeEvent(SignChangeEvent e){
        Player p = e.getPlayer();
        if(p.hasPermission("latinstaff.staff")) {
            if (Objects.requireNonNull(e.getLine(0)).equalsIgnoreCase("[lthor]")) {

            }
        }
    }

    @EventHandler
    public void onCLickSign(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Block block = e.getClickedBlock();
        if(!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
            if (e.getClickedBlock().getState() instanceof Sign) {
                Sign sign = (Sign) e.getClickedBlock().getState();
                String line1 = sign.getLine(0);
                String line2 = sign.getLine(1);
                String line4 = sign.getLine(3);
                if(line1.equalsIgnoreCase(StringUtils.toColor("&6&lLatin&e&lPLay"))){
                if (line2.equalsIgnoreCase(StringUtils.toColor("&fComprar"))) {
                    if (line4.equalsIgnoreCase(StringUtils.toColor("&7Mazo de Thor"))) {
                        if (Main.getEconomy().hasAccount(p)) {
                            if (Main.getEconomy().getBalance(p) >= 5000000) {
                                SkyblockCustomItems.giveMazo(p);
                                MessageUtils.giveMessageAtBuy(p, TypeItem.THOR);
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco take " + p.getName() + " 5000000");
                            } else {
                                p.sendMessage(StringUtils.toColor("&cNo tienes suficiente dinero, este item cuesta: &f$5M"));
                            }
                        } else {
                            p.sendMessage(StringUtils.toColor("&c¡Error al crear tu cuenta! Ven a nuestro discord para pedir soporte."));
                        }

                    } else if (line4.equalsIgnoreCase(StringUtils.toColor("&7Hacha de Zeus"))) {
                        if (Main.getEconomy().hasAccount(p)) {
                            if (Main.getEconomy().getBalance(p) >= 5000000) {
                                SkyblockCustomItems.giveAxe(p);
                                MessageUtils.giveMessageAtBuy(p, TypeItem.ZEUS);
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco take " + p.getName() + " 5000000");
                            } else {
                                p.sendMessage(StringUtils.toColor("&cNo tienes suficiente dinero, este item cuesta: &f$5M"));
                            }
                        } else {
                            p.sendMessage(StringUtils.toColor("&c¡Error al crear tu cuenta! Ven a nuestro discord para pedir soporte."));
                        }
                    }
                }
            }
        }
    }
}
