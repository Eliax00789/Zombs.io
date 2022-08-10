package me.eliax00789.zombsio.guis.buildmenu;

import me.eliax00789.zombsio.utility.GUICreator;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

class BuildMenuInventory {
    Inventory inventory;
    public BuildMenuInventory() {
        inventory = new GUICreator(9 * 4,"Build Menu")
                .setCancelAllClicks(true)
                .fillPlaceHolder()
                .addExitButton()
                .
                .getInventory();
        //TODO REST OF INVENTORY;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
