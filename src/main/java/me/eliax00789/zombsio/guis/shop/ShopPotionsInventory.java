package me.eliax00789.zombsio.guis.shop;

import me.eliax00789.zombsio.utility.Config;
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
                .setItem(3, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("§7Pets").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        Config.getInstance().LASTSHOPPAGE.put(inventory.getViewers().get(0).getName(),"pets");
                        inventory.getViewers().get(0).openInventory(new ShopPetsInventory().getInventory());
                    }
                })
                .setItem(4, new ItemCreator(Material.GREEN_STAINED_GLASS_PANE).setName("§aPotions").getItem())
                .setItem(10, new ItemCreator(Material.POTION).setName("§7Health Potion").setPotion(new PotionEffect(PotionEffectType.HEAL,0,2), false).getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(11, new ItemCreator(Material.POTION).setName("§7Pet Health Potion").setPotion(new PotionEffect(PotionEffectType.REGENERATION,0,2), false).getItem(), new BukkitRunnable() {
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
