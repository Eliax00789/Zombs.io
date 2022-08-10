package me.eliax00789.zombsio.guis.shop;

import me.eliax00789.zombsio.Zombsio;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Shop implements Listener {

    public Shop() {
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }
    @EventHandler
    public void onEnderChestPlace(PlayerInteractEvent e) {
        if (e.getMaterial().equals(Material.ENDER_CHEST)) {
            e.getPlayer().openInventory(new ShopToolsInventory().getInventory());
            e.setCancelled(true);
        }
    }
}

