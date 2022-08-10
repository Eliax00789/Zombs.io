package me.eliax00789.zombsio.guis.shop;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Shop implements Listener {

    public Shop() {
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }
    @EventHandler
    public void onEnderChestPlace(PlayerInteractEvent e) {
        if (e.getMaterial().equals(Material.ENDER_CHEST)) {
            if (Config.getInstance().LASTSHOPPAGE.get(e.getPlayer().getName()).equalsIgnoreCase("tools")) {
                e.getPlayer().openInventory(new ShopToolsInventory().getInventory());
            }
            else if (Config.getInstance().LASTSHOPPAGE.get(e.getPlayer().getName()).equalsIgnoreCase("armor")) {
                e.getPlayer().openInventory(new ShopArmorInventory().getInventory());
            }
            else if (Config.getInstance().LASTSHOPPAGE.get(e.getPlayer().getName()).equalsIgnoreCase("pets")) {
                e.getPlayer().openInventory(new ShopPetsInventory().getInventory());
            }
            else if (Config.getInstance().LASTSHOPPAGE.get(e.getPlayer().getName()).equalsIgnoreCase("potions")) {
                e.getPlayer().openInventory(new ShopPotionsInventory().getInventory());
            }
            else {
                e.getPlayer().sendMessage("something just went very wrong whilst trying to open the shop");
            }
            e.setCancelled(true);
        }
    }
}

