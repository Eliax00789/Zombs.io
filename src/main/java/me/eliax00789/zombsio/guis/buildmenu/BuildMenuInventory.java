package me.eliax00789.zombsio.guis.buildmenu;

import me.eliax00789.zombsio.buildings.other.Door;
import me.eliax00789.zombsio.buildings.other.Wall;
import me.eliax00789.zombsio.buildings.towers.*;
import me.eliax00789.zombsio.utility.GUICreator;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.scheduler.BukkitRunnable;

class BuildMenuInventory {
    Inventory inventory;
    public BuildMenuInventory(Location location) {
        inventory = new GUICreator(9 * 4,"Build Menu")
                .setCancelAllClicks(true)
                .fillPlaceHolder()
                .addExitButton()
                .setItem(10, new ItemCreator(Material.RAW_GOLD_BLOCK).setName("&7Gold Stash")
                        .setLore("&7Cost:  Wood: 15","&7      Stone: 15","&7      Gold: 15","&7Health: 150","&7Damage: 10","&7Range: 400").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                        inventory.getViewers().get(0).closeInventory();
                    }
                })
                .setItem(11, new ItemCreator(Material.GOLD_NUGGET).setName("&7Gold Mine")
                        .setLore("&7Cost:  Wood: 15","&7      Stone: 15","&7      Gold: 15","&7Health: 150","&7Damage: 10","&7Range: 400").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                        inventory.getViewers().get(0).closeInventory();
                    }
                })
                .setItem(13, new ItemCreator(Material.IRON_BARS).setName("&7Wall")
                        .setLore("&7Cost:  Wood: 15","&7      Stone: 15","&7      Gold: 15","&7Health: 150","&7Damage: 10","&7Range: 400").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new Wall(location);
                        inventory.getViewers().get(0).closeInventory();
                    }
                })
                .setItem(14, new ItemCreator(Material.IRON_DOOR).setName("&7Door")
                        .setLore("&7Cost:  Wood: 15","&7      Stone: 15","&7      Gold: 15","&7Health: 150","&7Damage: 10","&7Range: 400").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new Door(location);
                        inventory.getViewers().get(0).closeInventory();
                    }
                })
                .setItem(16, new ItemCreator(Material.HONEYCOMB).setName("&7Slow Trap")
                        .setLore("&7Cost:  Wood: 15","&7      Stone: 15","&7      Gold: 15","&7Health: 150","&7Damage: 10","&7Range: 400").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                        inventory.getViewers().get(0).closeInventory();
                    }
                })
                .setItem(20, new ItemCreator(Material.ARROW).setName("&7Arrow Tower")
                        .setLore("&7Cost:  Wood: 15","&7      Stone: 15","&7      Gold: 15","&7Health: 150","&7Damage: 10","&7Range: 400").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new ArrowTower(location);
                        inventory.getViewers().get(0).closeInventory();
                    }
                })
                .setItem(21, new ItemCreator(Material.FIRE_CHARGE).setName("&7Cannon Tower")
                        .setLore("&7Cost:  Wood: 15","&7      Stone: 15","&7      Gold: 15","&7Health: 150","&7Damage: 10","&7Range: 400").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new CannonTower(location);
                        inventory.getViewers().get(0).closeInventory();
                    }
                })
                .setItem(22, new ItemCreator(Material.TNT).setName("&7Bomb Tower")
                        .setLore("&7Cost:  Wood: 10","&7      Stone: 10","&7      Gold: 15","&7Health: 150","&7Damage: 10","&7Range: 400").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new BombTower(location);
                        inventory.getViewers().get(0).closeInventory();
                    }
                })
                .setItem(23, new ItemCreator(Material.ENCHANTED_BOOK).setName("&7Mage Tower")
                        .setLore("&7Cost:  Wood: 15","&7      Stone: 15","&7      Gold: 15","&7Health: 150","&7Damage: 10","&7Range: 400").addEnchant(Enchantment.MULTISHOT, 69420, true).addFlag(ItemFlag.HIDE_ENCHANTS).getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new MageTower(location);
                        inventory.getViewers().get(0).closeInventory();
                    }
                })
                .setItem(24,new ItemCreator(Material.STONE_SWORD).setName("&7Melee Tower")
                        .setLore("&7Cost:  Wood: 15","&7      Stone: 15","&7      Gold: 15","&7Health: 150","&7Damage: 10","&7Range: 400").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new MeleeTower(location);
                        inventory.getViewers().get(0).closeInventory();
                    }
                })
                .getInventory();
    }


    public Inventory getInventory() {
        return inventory;
    }
}
