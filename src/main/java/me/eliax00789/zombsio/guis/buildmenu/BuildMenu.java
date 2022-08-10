package me.eliax00789.zombsio.guis.buildmenu;

import me.eliax00789.zombsio.Zombsio;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildMenu implements Listener {

    public BuildMenu() {
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }
    @EventHandler
    public void onCraftingTablePlace(BlockPlaceEvent e) {
        if (e.getBlockPlaced().getType().equals(Material.CRAFTING_TABLE)) {
            e.getPlayer().openInventory(new BuildMenuInventory(e.getBlockPlaced().getLocation()).getInventory());
            e.setCancelled(true);
        }
    }
}