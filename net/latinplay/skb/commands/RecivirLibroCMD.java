package net.latinplay.skb.commands;

import net.latinplay.skb.Utils.Interfaces.StringUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

public class RecivirLibroCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player) sender;
        String n1 = "\n";
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta bookm = (BookMeta) book.getItemMeta();
        bookm.setTitle(StringUtils.toColor("&aBienvenido"));
        ArrayList<String> pages = new ArrayList<>();
        bookm.setAuthor("LatinPlay");
        pages.add(0, StringUtils.toColor("&aBienvenido a SkyBlock, en este libro podras ver un tutorial basico" + n1 + "de como poder jugar esta modalidad." + " Actualmente la modalidad esta en fase &cBeta&a."));
        pages.add(1, StringUtils.toColor("&71- Usando el comando /is podras crear tu isla." + n1 + "2- Una vez en tu isla, debes de hacer un generador de piedra usando los materiales del cofre"));
        pages.add(2, StringUtils.toColor("&73- Recuerda que puedes vender tus items en la tienda para ganar dinero y asi mejorar tu isla" + n1 + "&74- No olvides de llevar cuidado donde pisas!."));
        pages.add(3, StringUtils.toColor("&cEsta informacion es basica, recuerda que puedes visitar los warps con /warp e ir al warp informacion, tambien puedes pedir ayuda usando /ayuda (texto)"));
        pages.add(4, StringUtils.toColor("&2¡Disfruta del servidor!"));

        bookm.setPages(pages);
        book.setItemMeta(bookm);
        p.getInventory().setItem(1, book);
        return false;
    }
}
