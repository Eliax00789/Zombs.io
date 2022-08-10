package me.eliax00789.zombsio.guis.buildmenu;

import me.eliax00789.zombsio.buildings.towers.*;
import me.eliax00789.zombsio.utility.GUICreator;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

class BuildMenuInventory {
    Inventory inventory;
    public BuildMenuInventory(Location location) {
        inventory = new GUICreator(9 * 4,"Build Menu")
                .setCancelAllClicks(true)
                .fillPlaceHolder()
                .addExitButton()
                .setItem(10, new ItemCreator(Material.RAW_GOLD_BLOCK).setName("Gold Stash").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(11, new ItemCreator(Material.GOLD_NUGGET).setName("Gold Mine").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(13, new ItemCreator(Material.IRON_BARS).setName("Wall").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(14, new ItemCreator(Material.IRON_DOOR).setName("Door").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(16, new ItemCreator(Material.HONEYCOMB).setName("Slow Trap").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(20, new ItemCreator(Material.ARROW).setName("Arrow Tower").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new ArrowTower(location);
                    }
                })
                .setItem(21, new ItemCreator(Material.FIRE_CHARGE).setName("Cannon Tower").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new CannonTower(location);
                    }
                })
                .setItem(22, new ItemCreator(Material.TNT).setName("Bomb Tower").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new BombTower(location);
                    }
                })
                .setItem(23, new ItemCreator(Material.ENCHANTED_BOOK).setName("Mage Tower").addEnchant(Enchantment.MULTISHOT,1,false).getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new MageTower(location);
                    }
                })
                .setItem(24,new ItemCreator(Material.STONE_SWORD).setName("Melee Tower").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new MeleeTower(location);
                    }
                })
                .getInventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
