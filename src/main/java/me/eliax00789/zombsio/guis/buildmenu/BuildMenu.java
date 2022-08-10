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
    public void onCraftingTablePlace(BlockPlaceEvent event) {
        if (event.getBlockPlaced().getType().equals(Material.CRAFTING_TABLE)) {
            event.getPlayer().openInventory(new BuildMenuInventory().getInventory());
            event.setCancelled(true);
        }
    }
}