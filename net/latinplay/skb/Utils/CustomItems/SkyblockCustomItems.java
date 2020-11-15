package net.latinplay.skb.Utils.CustomItems;

import net.latinplay.skb.Utils.Interfaces.StringUtils;
import net.latinplay.skb.Utils.Interfaces.SKAddon;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SkyblockCustomItems implements SKAddon {
    public static ItemStack axe = new ItemStack(Material.DIAMOND_AXE,1 );
    public static ItemMeta axem = axe.getItemMeta();

    public static ItemStack mazo = new ItemStack(Material.IRON_AXE,1 );
    public static ItemMeta mazom = axe.getItemMeta();

    //Hacha de Zeus
    public static void giveAxe(Player p){
        axem.setDisplayName(StringUtils.toColor("&aHacha de Zeus"));
        ArrayList<String> loreaxe = new ArrayList<>();
        loreaxe.add((StringUtils.toColor("&7Una hacha muy poderosa digan de un dios")));
        loreaxe.add((StringUtils.toColor("&f")));
        loreaxe.add((StringUtils.toColor("&aHabilidad: &fLanzar rayo &7(Click derecho a un bloque)")));
        loreaxe.add((StringUtils.toColor("&aCooldown: &c10 segundos")));
        loreaxe.add((StringUtils.toColor("&f")));
        loreaxe.add((StringUtils.toColor("&fAfilado: 6")));
        axem.setLore(loreaxe);
        axem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        axem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        axem.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
        axe.setItemMeta(axem);

        p.getInventory().addItem(axe);
    }

    //Mazo de thor
    public static void giveMazo(Player p){
        mazom.setDisplayName(StringUtils.toColor("&cMazo de thor"));
        ArrayList<String> loremazo = new ArrayList<>();
        loremazo.add((StringUtils.toColor("&7El gran mazo de thor")));
        loremazo.add((StringUtils.toColor("&f")));
        loremazo.add((StringUtils.toColor("&aHabilidad: &fLanzar a un jugador por los aires")));
        loremazo.add((StringUtils.toColor("&fcon una probabilidad del 70% &7(Golpea al jugador)")));
        loremazo.add((StringUtils.toColor("&aCooldown: &c¡Ninguno!")));
        loremazo.add((StringUtils.toColor("&f")));
        loremazo.add((StringUtils.toColor("&fAfilado: 5")));
        loremazo.add((StringUtils.toColor("&fEmpuje: 2")));
        mazom.setLore(loremazo);
        mazom.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        mazom.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        mazom.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        mazom.addEnchant(Enchantment.KNOCKBACK, 2, true);
        mazo.setItemMeta(mazom);

        p.getInventory().addItem(mazo);
    }

}
