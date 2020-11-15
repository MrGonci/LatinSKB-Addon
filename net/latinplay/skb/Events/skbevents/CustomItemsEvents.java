package net.latinplay.skb.Events.skbevents;

import net.latinplay.skb.Utils.Interfaces.StringUtils;
import net.latinplay.skb.Utils.Interfaces.SKAddon;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Random;

public class CustomItemsEvents implements Listener, SKAddon {

    int cooldown = 10;
    HashMap<String, Long> cooldownp = new HashMap<>();

    //Hacha de Zeus
    @EventHandler
    public void onPlayerInteractBlock(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();
        String ItemName = StringUtils.toColor("&aHacha de Zeus");
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (item != null && item.hasItemMeta()) {
                if (item.getType() == Material.DIAMOND_AXE && item.getItemMeta().getDisplayName().equals(ItemName)) {
                    //player.getWorld().strikeLightning(player.getLocation());
                    if (!player.getWorld().getName().equalsIgnoreCase("island_normal_world") && !player.getWorld().getName().equalsIgnoreCase("world")){
                    if(cooldownp.containsKey(player.getName())) {
                        long restantes = ((cooldownp.get(player.getName()) / 1000) + cooldown) - (System.currentTimeMillis() / 1000);
                        if(restantes > 0){
                            player.sendMessage(StringUtils.toColor("&cTienes que esperar &f" + restantes + " &csegundos.") );
                        }else {
                            cooldownp.remove(player.getName());
                        }
                    }else{
                        int y = event.getClickedBlock().getY();
                        int x = event.getClickedBlock().getX();
                        int z = event.getClickedBlock().getZ();
                        World world = player.getWorld();
                        Location loc = new Location(world, x, y, z);
                        player.getWorld().strikeLightning(loc);
                        cooldownp.put(player.getName(), System.currentTimeMillis());
                        clearcooldown(player);
                        player.sendMessage(StringUtils.toColor("&8¡&fLanzaste un &erayo &ften cuidado con la madera&8!"));
                        }
                    }
                    else  {
                        player.sendMessage(StringUtils.toColor("Esta Habilidad esta desactivada en este mundo"));
                    }
                }
            }
        }
    }



    //Mazo de thor
    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) { Entity ent = e.getEntity();

        String ItemName = StringUtils.toColor("&cMazo de thor");

        Entity d = e.getDamager();

        if(!(ent instanceof Player)) return;
        if(!(d instanceof Player)) return;

        Player damaged = (Player) ent;
        Player damager = (Player) d;

        ItemStack item = damager.getItemInHand();
        Material weapon = item.getType();

        if (weapon == Material.IRON_AXE) {
            if(item != null && item.hasItemMeta()){
                ItemMeta mazo = item.getItemMeta();
                if(mazo.getDisplayName().equals(ItemName)){
                    if(!damager.getWorld().getName().equalsIgnoreCase("island_normal_world") && !damager.getWorld().getName().equalsIgnoreCase("world")) {
                        //DO WHATEVER YOU WANT HERE IF PVP IS OFF
                        Random r = new Random();
                        int number = r.nextInt(100);
                        if (number >= 70) {
                            //launchPlayer(damaged);
                            double launchBoost = 7.2;
                            double x = e.getEntity().getVelocity().getX();
                            double z = e.getEntity().getVelocity().getZ();
                            double y = e.getEntity().getVelocity().getY() + launchBoost;
                            Bukkit.getScheduler().runTaskLater(plugin, () -> e.getEntity().setVelocity(new Vector(x, y, z)), 1);
                            damager.sendMessage(StringUtils.toColor("&a!Lanzaste a &f" + damaged.getDisplayName() + " &apors los aires!"));
                        } else {
                            damager.sendMessage(StringUtils.toColor("&c!Fallaste el golpe pero lo dejaste aturido¡"));
                        }
                    }else{
                        damager.sendMessage(StringUtils.toColor("Esta Habilidad esta desactivada en este mundo"));
                    }
                }
            }
        }
    }

    public void launchPlayer(Player p) {
        p.setVelocity(new Vector(50, 50, 50));
    }

    public void clearcooldown(final Player p) {
        new BukkitRunnable() {
            int counter = 30;
            @Override
            public void run() {
                counter--;
                if (counter == 0) {
                    cooldownp.remove(p.getName());
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 12000);

    }
}
