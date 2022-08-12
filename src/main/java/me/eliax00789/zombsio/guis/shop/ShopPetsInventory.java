package me.eliax00789.zombsio.guis.shop;

import me.eliax00789.zombsio.utility.Config;
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
        inventory = new GUICreator(9 * 3,"Shop: Tools")
                .fillPlaceHolder()
                .addExitButton()
                .setCancelAllClicks(true)
                .setItem(1, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("§7Tools").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        Config.getInstance().LASTSHOPPAGE.put(inventory.getViewers().get(0).getName(),"tools");
                        inventory.getViewers().get(0).openInventory(new ShopToolsInventory().getInventory());
                    }
                })
                .setItem(2, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("§7Armor").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        Config.getInstance().LASTSHOPPAGE.put(inventory.getViewers().get(0).getName(),"armor");
                        inventory.getViewers().get(0).openInventory(new ShopArmorInventory().getInventory());
                    }
                })
                .setItem(3, new ItemCreator(Material.GREEN_STAINED_GLASS_PANE).setName("§aPets").getItem())
                .setItem(4, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("§7Potions").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        Config.getInstance().LASTSHOPPAGE.put(inventory.getViewers().get(0).getName(),"potions");
                        inventory.getViewers().get(0).openInventory(new ShopPotionsInventory().getInventory());
                    }
                })
                .setItem(10, new ItemCreator(Material.RAVAGER_SPAWN_EGG).setName("§7Carl").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(11, new ItemCreator(Material.GOAT_SPAWN_EGG).setName("§7Woody").getItem(), new BukkitRunnable() {
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
