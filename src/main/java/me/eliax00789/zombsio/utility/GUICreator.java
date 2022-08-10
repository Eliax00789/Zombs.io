package me.eliax00789.zombsio.utility;

import me.eliax00789.zombsio.Zombsio;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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
        ItemStack item = new ItemCreator(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setName("").getItem();
        for (Integer i = 0; i <= inventory.getSize(); i++) {
            inventory.setItem(i,item);
        }
        return this;
    }

    public GUICreator addExitButton() {
        ItemStack item = new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("EXIT").getItem();
        inventory.setItem(inventory.getSize() - 8,item);
        setClickAction(new BukkitRunnable() {
            @Override
            public void run() {
                for (HumanEntity i: inventory.getViewers()) {
                    i.closeInventory();
                }
            }
        }, inventory.getSize() - 8);
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