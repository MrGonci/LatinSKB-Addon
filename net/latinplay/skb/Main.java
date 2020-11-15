package net.latinplay.skb;

import io.netty.util.internal.StringUtil;
import net.latinplay.skb.Events.skbevents.CustomItemsEvents;
import net.latinplay.skb.Events.skbevents.PlayerBlockItem;
import net.latinplay.skb.Events.skbevents.SPlayerJoinEvent;
import net.latinplay.skb.Events.skbevents.signs.PlayerClickSign;
import net.latinplay.skb.Utils.Interfaces.ServerSender;
import net.latinplay.skb.Utils.Interfaces.StringUtils;
import net.latinplay.skb.Utils.Timer.Timer;
import net.latinplay.skb.commands.staff.FlyCMD;
import net.latinplay.skb.commands.staff.GmCMD;
import net.latinplay.skb.commands.staff.LSkyblockCMD;
import net.latinplay.skb.commands.RecivirLibroCMD;
import net.latinplay.skb.commands.staff.ReloadCommand;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class Main extends JavaPlugin {

    private static Economy econ = null;

    @Override
    public void onEnable() {
        ServerSender.send("");
        ServerSender.send("&7&oPlugin activado correctamente");
        ServerSender.send("&aSkyblock-Addon &7| v1.4.2");
        ServerSender.send("");
        Bukkit.getPluginManager().registerEvents(new PlayerBlockItem(), this);
        Bukkit.getPluginManager().registerEvents(new SPlayerJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new CustomItemsEvents(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerClickSign(), this);
        Objects.requireNonNull(this.getCommand("skbreload")).setExecutor(new ReloadCommand());
        Objects.requireNonNull(this.getCommand("recivirlibro")).setExecutor(new RecivirLibroCMD());
        Objects.requireNonNull(this.getCommand("lskb")).setExecutor(new LSkyblockCMD());
        Objects.requireNonNull(this.getCommand("fly")).setExecutor(new FlyCMD());
        //gamemode
        Objects.requireNonNull(this.getCommand("gm")).setExecutor(new GmCMD());

        RegisterConfig();
        if (!setupEconomy() ) {
            ServerSender.send(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        startRunnable();
    }
    @Override
    public void onDisable() {
        ServerSender.send("");
        ServerSender.send("&7&oPlugin desactivado correctamente");
        ServerSender.send("&aSkyblock-Addon &7| v1.4.2");
        ServerSender.send("");
    }

    public void RegisterConfig(){
        ServerSender.send(" Config registrados con exito ");
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public void startRunnable(){
        Timer timer = new Timer(1, true);
        timer.addExecutable(0, () -> {
            for (Player pp : Bukkit.getOnlinePlayers()){
                startCheackingInvs(pp);
            }
        });
    }

    public void startCheackingInvs(Player p){
        Timer timer = new Timer(1, false);
        timer.addExecutable(0, () -> {
            if (p.getInventory().contains(Material.WRITTEN_BOOK)){
                ItemStack item = new ItemStack(Material.WRITTEN_BOOK, 64);
                p.getInventory().removeItem(item);
                p.sendMessage(StringUtils.toColor("&aSkyblock &8» &4No puedes tener este item en tu invenyario."));
            }
        });
    }
}