package me.eliax00789.zombsio.guis.shop;

import me.eliax00789.zombsio.Zombsio;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class Shop implements Listener {

    public Shop() {
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }
    @EventHandler
    public void onEnderChestPlace(BlockPlaceEvent e) {
        if (e.getBlockPlaced().getType().equals(Material.ENDER_CHEST)) {
            e.getPlayer().openInventory(new ShopToolsInventory().getInventory());
            e.setCancelled(true);
        }
    }
}

