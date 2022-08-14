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
import org.bukkit.inventory.ItemFlag;
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
        for (Integer i = 8; i <= 35; i++) {
            e.getPlayer().getInventory().setItem(i,new ItemCreator(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setName(" ").getItem());
        }
        e.getPlayer().getInventory().setItem(0,new ItemCreator(Material.WOODEN_AXE).setName("§7" + Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(0))
                .setLore("§7Damage: " + (Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Damage").get(0))
                        , "§7Resource Amount: " + (Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Harvest").get(0))
                        , "§7Attackspeed: " + (Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Attackspeed").get(0))
                ).setUnbreakable(true).addFlag(ItemFlag.HIDE_UNBREAKABLE).getItem());

        e.getPlayer().getInventory().setItem(7, new ItemCreator(Material.CRAFTING_TABLE).setName("Build Menu").getItem());
        e.getPlayer().getInventory().setItem(8, new ItemCreator(Material.ENDER_CHEST).setName("Shop").getItem());

        new ResourceScoreboard(e.getPlayer());

    }
}