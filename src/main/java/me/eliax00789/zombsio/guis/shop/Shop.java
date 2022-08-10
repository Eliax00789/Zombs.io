package me.eliax00789.zombsio.guis.shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;

public class Shop implements Listener {
    @EventHandler
    public void onEnderChestPlace(BlockPlaceEvent event) {
        if (event.getBlockPlaced().getType().equals(Material.ENDER_CHEST)) {
            event.getPlayer().openInventory(new ShopToolsInventory().getInventory());
            event.setCancelled(true);
        }
    }
}

