package me.eliax00789.zombsio.guis.shop;

import me.eliax00789.zombsio.utility.GUICreator;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

class ShopPetsInventory {

    private Inventory inventory;
    public ShopPetsInventory() {
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
                .setItem(2, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("Armor").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (HumanEntity i: inventory.getViewers()) {
                            i.openInventory(new ShopArmorInventory().getInventory());
                        }
                    }
                })
                .setItem(3, new ItemCreator(Material.GREEN_STAINED_GLASS_PANE).setName("Pets").getItem())
                .setItem(4, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("Potions").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (HumanEntity i: inventory.getViewers()) {
                            i.openInventory(new ShopPotionsInventory().getInventory());
                        }
                    }
                })
                .setItem(13, new ItemCreator(Material.LEATHER_BOOTS).getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(13, new ItemCreator(Material.LEATHER_BOOTS).getItem(), new BukkitRunnable() {
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
