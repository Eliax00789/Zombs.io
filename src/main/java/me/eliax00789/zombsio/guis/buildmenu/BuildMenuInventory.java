package me.eliax00789.zombsio.guis.buildmenu;

import me.eliax00789.zombsio.utility.GUICreator;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;

class BuildMenuInventory {
    Inventory inventory;
    public BuildMenuInventory() {
        inventory = new GUICreator(9 * 4,"Build Menu")
                .setCancelAllClicks(true)
                .fillPlaceHolder()
                .addExitButton()
                .setItem(10, new ItemCreator(Material.RAW_GOLD_BLOCK).setName("Gold Stash").getItem())
                .setItem(11, new ItemCreator(Material.GOLD_NUGGET).setName("Gold Mine").getItem())
                .setItem(13, new ItemCreator(Material.IRON_BARS).setName("Wall").getItem())
                .setItem(14, new ItemCreator(Material.IRON_DOOR).setName("Door").getItem())
                .setItem(16, new ItemCreator(Material.HONEYCOMB).setName("Slow Trap").getItem())
                .setItem(19, new ItemCreator(Material.ARROW).setName("Arrow Tower").getItem())
                .setItem(20, new ItemCreator(Material.FIRE_CHARGE).setName("Cannon Tower").getItem())
                .setItem(21, new ItemCreator(Material.TNT).setName("Bomb Tower").getItem())
                .setItem(22, new ItemCreator(Material.BOOK).setName("Mage Tower").addEnchant(Enchantment.MULTISHOT,1,false).getItem())
                .setItem(23,new ItemCreator(Material.STONE_SWORD).setName("Melee Tower").getItem())
                .getInventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
