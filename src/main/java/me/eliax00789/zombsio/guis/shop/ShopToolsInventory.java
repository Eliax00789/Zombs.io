package me.eliax00789.zombsio.guis.shop;

import me.eliax00789.zombsio.utility.Config;
import me.eliax00789.zombsio.utility.GUICreator;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

class ShopToolsInventory {

    private Inventory inventory;
    public ShopToolsInventory() {
        inventory = new GUICreator(9 * 3,"Shop: Tools")
                .fillPlaceHolder()
                .addExitButton()
                .setCancelAllClicks(true)
                .setItem(1, new ItemCreator(Material.GREEN_STAINED_GLASS_PANE).setName("&aTools").getItem())
                .setItem(2, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("&7Armor").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        Config.getInstance().LASTSHOPPAGE.put(inventory.getViewers().get(0).getName(),"armor");
                        inventory.getViewers().get(0).openInventory(new ShopArmorInventory().getInventory());
                    }
                })
                .setItem(3, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("&7Pets").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        Config.getInstance().LASTSHOPPAGE.put(inventory.getViewers().get(0).getName(),"pets");
                        inventory.getViewers().get(0).openInventory(new ShopPetsInventory().getInventory());
                    }
                })
                .setItem(4, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("&7Potions").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        Config.getInstance().LASTSHOPPAGE.put(inventory.getViewers().get(0).getName(),"potions");
                        inventory.getViewers().get(0).openInventory(new ShopPotionsInventory().getInventory());
                    }
                })
                .setItem(10, new ItemCreator(Material.WOODEN_AXE).setName("&7Axe MK.1").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(11, new ItemCreator(Material.WOODEN_SWORD).setName("&7Sword MK.1").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(12, new ItemCreator(Material.BOW).setName("&7Bow MK.1").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(13, new ItemCreator(Material.FIRE_CHARGE).setName("&7Cannon MK.1").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .getInventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
