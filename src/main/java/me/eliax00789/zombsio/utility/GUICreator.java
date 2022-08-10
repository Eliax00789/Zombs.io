package me.eliax00789.zombsio.utility;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class GUICreator {
    private Inventory inventory;

    public GUICreator(Integer size) {
        inventory = Bukkit.createInventory(null, size);
    }

    public GUICreator setTitle(String title) {
        Inventory newinventory = Bukkit.createInventory(null,inventory.getSize(),title);
        newinventory.setContents(inventory.getContents());
        inventory = newinventory;
        return this;
    }

    public GUICreator setItem(Integer index,ItemStack item) {
        inventory.setItem(index,item);
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
        return this;
    }

    public Inventory getInventory() {
        return inventory;
    }
}