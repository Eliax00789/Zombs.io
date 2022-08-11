package me.eliax00789.zombsio.utility;

import me.eliax00789.zombsio.Zombsio;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class GUICreator implements Listener {
    private Inventory inventory;
    private Boolean cancelClicks;
    private HashMap<Integer,BukkitRunnable> actionmap;

    public GUICreator(Integer size,String title) {
        inventory = Bukkit.createInventory(null, size, title);
        cancelClicks = false;
        actionmap = new HashMap<Integer,BukkitRunnable>();
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }

    public GUICreator setCancelAllClicks(Boolean cancel) {
        cancelClicks = cancel;
        return this;
    }

    public GUICreator setItem(Integer index,ItemStack item) {
        inventory.setItem(index,item);
        return this;
    }

    public GUICreator setClickAction(BukkitRunnable action,Integer... index) {
        for (Integer i:index) {
            actionmap.put(i,action);
        }
        return this;
    }

    public GUICreator setItem(Integer index,ItemStack item,BukkitRunnable action) {
        inventory.setItem(index,item);
        setClickAction(action,index);
        return this;
    }

    public GUICreator fillPlaceHolder() {
        ItemStack item = new ItemCreator(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setName(" ").getItem();
        for (Integer i = 0; i <= (inventory.getSize() - 1); i++) {
            inventory.setItem(i,item);
        }
        return this;
    }

    public GUICreator addExitButton() {
        ItemStack item = new ItemCreator(Material.BARRIER).setName("&4EXIT").getItem();
        inventory.setItem(inventory.getSize() - 9,item);
        setClickAction(new BukkitRunnable() {
            @Override
            public void run() {
                for (HumanEntity i: inventory.getViewers()) {
                    i.closeInventory();
                }
            }
        }, inventory.getSize() - 9);
        return this;
    }

    public GUICreator addItemSwitch(Integer index,ItemStack item1,BukkitRunnable action1,ItemStack item2, Integer wood, Integer stone, Integer gold, Integer currenttier, Integer neededtier, Player player) {

        if(Config.getInstance().STONE.get(player.getName().toString()) >= stone
                && Config.getInstance().WOOD.get(player.getName().toString()) >= wood
                && Config.getInstance().GOLD.get(player.getName().toString()) >= gold
                && currenttier >= neededtier) {
            setItem(index,item1,action1);
        } else {
            setItem(index,item2);
        }
        return this;
    }

    public GUICreator addItemSwitch(Integer index,ItemStack item1,ItemStack item2, Integer wood, Integer stone, Integer gold, Integer currentstashtier, Integer neededstashtier, Player player) {

        if(Config.getInstance().STONE.get(player.getName().toString()) >= stone
                && Config.getInstance().WOOD.get(player.getName().toString()) >= wood
                && Config.getInstance().GOLD.get(player.getName().toString()) >= gold
                && currentstashtier >= neededstashtier) {
            setItem(index,item1);
        } else {
            setItem(index,item2);
        }
        return this;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().equals(inventory)) {
            if (cancelClicks) {
                e.setCancelled(true);
            }
            if (actionmap.containsKey(e.getRawSlot())) {
                actionmap.get(e.getRawSlot()).run();
            }
         }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        if (e.getInventory().equals(inventory)) {
            if (cancelClicks) {
                e.setCancelled(true);
            }
            for (Integer i:e.getInventorySlots()) {
                if (actionmap.containsKey(i)) {
                    actionmap.get(i).run();
                }
            }
        }
    }
}