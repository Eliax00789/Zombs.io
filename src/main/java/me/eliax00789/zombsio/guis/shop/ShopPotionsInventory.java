package me.eliax00789.zombsio.guis.shop;

import me.eliax00789.zombsio.utility.GUICreator;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

class ShopPotionsInventory {

    private Inventory inventory;
    public ShopPotionsInventory() {
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
                .setItem(3, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("Pets").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (HumanEntity i: inventory.getViewers()) {
                            i.openInventory(new ShopPetsInventory().getInventory());
                        }
                    }
                })
                .setItem(4, new ItemCreator(Material.GREEN_STAINED_GLASS_PANE).setName("Potions").getItem())
                .setItem(10, new ItemCreator(Material.POTION).setName("Health Potion").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(11, new ItemCreator(Material.POTION).setName("Pet Health Potion").getItem(), new BukkitRunnable() {
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
