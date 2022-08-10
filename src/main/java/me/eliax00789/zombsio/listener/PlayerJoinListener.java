package me.eliax00789.zombsio.listener;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.guis.ResourceScoreboard;
import me.eliax00789.zombsio.utility.Config;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinListener implements Listener {

    public PlayerJoinListener() {
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (!Config.getInstance().WOOD.containsKey(e.getPlayer().getName())) {
            Config.getInstance().WOOD.put(e.getPlayer().getName(), 0);
            Config.getInstance().STONE.put(e.getPlayer().getName(), 0);
            Config.getInstance().GOLD.put(e.getPlayer().getName(), 0);
            Config.getInstance().LASTSHOPPAGE.put(e.getPlayer().getName(), "tools");
        }
        e.getPlayer().getInventory().clear();
        e.getPlayer().setGameMode(GameMode.SURVIVAL);


        e.getPlayer().getInventory().setItem(7, new ItemCreator(Material.CRAFTING_TABLE).setName("Build Menu").getItem());
        e.getPlayer().getInventory().setItem(8, new ItemCreator(Material.ENDER_CHEST).setName("Shop").getItem());

        new ResourceScoreboard(e.getPlayer());

    }
}