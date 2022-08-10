package me.eliax00789.zombsio.guis.shop;

import me.eliax00789.zombsio.utility.GUICreator;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

class ShopArmorInventory {

    private Inventory inventory;
    public ShopArmorInventory() {
        //TODO: THIS FUCKING SHIT

        inventory = new GUICreator(9 * 3,"Shop: Tools")
                .fillPlaceHolder()
                .addExitButton()
                .setCancelAllClicks(true)
                .setItem(1, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("Tools").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (HumanEntity i: inventory.getViewers()) {
                            i.openInventory(new ShopToolsInventory().getInventory());
                        }
                    }
                })
                .setItem(2, new ItemCreator(Material.GREEN_STAINED_GLASS_PANE).setName("Armor").getItem())
                .setItem(3, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("Pets").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (HumanEntity i: inventory.getViewers()) {
                            i.openInventory(new ShopPetsInventory().getInventory());
                        }
                    }
                })
                .setItem(4, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("Potions").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (HumanEntity i: inventory.getViewers()) {
                            i.openInventory(new ShopPotionsInventory().getInventory());
                        }
                    }
                })
                .setItem(10, new ItemCreator(Material.LEATHER_HELMET).setName("Axe MK.1").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(11, new ItemCreator(Material.LEATHER_CHESTPLATE).setName("Axe MK.1").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(12, new ItemCreator(Material.LEATHER_LEGGINGS).setName("Axe MK.1").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(13, new ItemCreator(Material.LEATHER_BOOTS).setName("Axe MK.1").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(14, new ItemCreator(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setName("Axe MK.1").getItem(), new BukkitRunnable() {
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
