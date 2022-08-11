package me.eliax00789.zombsio.guis.shop;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.utility.Config;
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
        inventory = new GUICreator(9 * 3,"Shop: Tools")
                .fillPlaceHolder()
                .addExitButton()
                .setCancelAllClicks(true)
                .setItem(1, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("&7Tools").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        Config.getInstance().LASTSHOPPAGE.put(inventory.getViewers().get(0).getName(),"tools");
                        inventory.getViewers().get(0).openInventory(new ShopToolsInventory().getInventory());
                    }
                })
                .setItem(2, new ItemCreator(Material.GREEN_STAINED_GLASS_PANE).setName("&aArmor").getItem())
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
                .setItem(10, new ItemCreator(Material.LEATHER_HELMET).setName("&7Helmet MK.1")
                        .setLore("&7Cost:  Gold: " + Zombsio.plugin.getConfig().getList("Items.Helmet.Gold").get(0)
                                ,"&7Health: " + Zombsio.plugin.getConfig().getList("Items.Helmet.Health").get(0)
                        ).getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(11, new ItemCreator(Material.LEATHER_CHESTPLATE).setName("&7Chestplate MK.1")
                        .setLore("&7Cost:  Gold: " + Zombsio.plugin.getConfig().getList("Items.Chestplate.Gold").get(0)
                                ,"&7Health: " + Zombsio.plugin.getConfig().getList("Items.Chestplate.Health").get(0)
                        ).getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(12, new ItemCreator(Material.LEATHER_LEGGINGS).setName("&7Leggings MK.1")
                        .setLore("&7Cost:  Gold: " + Zombsio.plugin.getConfig().getList("Items.Chestplate.Gold").get(0)
                                ,"&7Health: " + Zombsio.plugin.getConfig().getList("Items.Chestplate.Health").get(0)
                        ).getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(13, new ItemCreator(Material.LEATHER_BOOTS).setName("&7Boots MK.1")
                        .setLore("&7Cost:  Gold: " + Zombsio.plugin.getConfig().getList("Items.Leggings.Gold").get(0)
                                ,"&7Health: " + Zombsio.plugin.getConfig().getList("Items.Leggings.Health").get(0)
                        ).getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(14, new ItemCreator(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setName("&7Shield MK.1")
                        .setLore("&7Cost:  Gold: " + Zombsio.plugin.getConfig().getList("Items.Shield.Gold").get(0)
                                ,"&7Health: " + Zombsio.plugin.getConfig().getList("Items.Shield.Health").get(0)
                                ,"&7RechargeDelay: " + Zombsio.plugin.getConfig().getList("Items.Shield.RechargeDelay").get(0)
                        ).getItem(), new BukkitRunnable() {
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
