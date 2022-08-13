package me.eliax00789.zombsio.guis.shop;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.utility.Config;
import me.eliax00789.zombsio.utility.GUICreator;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

class ShopToolsInventory {

    private Inventory inventory;
    private Integer[] Pickaxe, Spear, Bow, Bomb;
    public ShopToolsInventory(Player player) {
        Integer playergold = Config.getInstance().GOLD.get(player.getName());

        if (player.getInventory().getItem(0) != null) {
            if (player.getInventory().getItem(0).hasItemMeta()) {
                Pickaxe = new Integer[]{
                        Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Name")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(0).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Gold")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(0).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Damage")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(0).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(0).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Attackspeed")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(0).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                };
            }
        } else {
            Pickaxe = new Integer[]{
                    Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Name").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Gold").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Damage").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Attackspeed").get(0)
            };
        }


        if (player.getInventory().getItem(1) != null) {
            if (player.getInventory().getItem(1).hasItemMeta()) {
                Spear = new Integer[]{
                        Zombsio.plugin.getConfig().getIntegerList("Items.Spear.Name")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(1).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Spear.Gold")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(1).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Spear.Damage")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(1).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Spear.Range")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(1).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Spear.Attackspeed")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(1).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                };
            }
        } else {
            Spear = new Integer[]{
                    Zombsio.plugin.getConfig().getIntegerList("Items.Spear.Name").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Spear.Gold").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Spear.Damage").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Spear.Range").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Spear.Attackspeed").get(0)
            };
        }


        if (player.getInventory().getItem(2) != null) {
            if (player.getInventory().getItem(2).hasItemMeta()) {
                Bow = new Integer[]{
                        Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Name")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(2).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Gold")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(2).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Damage")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(2).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Attackspeed")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(2).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                };
            }
        } else {
            Bow = new Integer[]{
                    Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Name").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Gold").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Damage").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Attackspeed").get(0)
            };
        }


        if (player.getInventory().getItem(3) != null) {
            if (player.getInventory().getItem(3).hasItemMeta()) {
                Bomb = new Integer[]{
                        Zombsio.plugin.getConfig().getIntegerList("Items.Bomb.Name")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(3).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Bomb.Gold")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(3).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Bomb.Damage")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(3).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Bomb.Range")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(3).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Bomb.Attackspeed")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(3).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                };
            }
        } else {
            Bomb = new Integer[]{
                    Zombsio.plugin.getConfig().getIntegerList("Items.Bomb.Name").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Bomb.Gold").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Bomb.Damage").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Bomb.Range").get(0)
                    ,Zombsio.plugin.getConfig().getIntegerList("Items.Bomb.Attackspeed").get(0)
            };
        }



        inventory = new GUICreator(9 * 3,"Shop: Tools")
                .fillPlaceHolder()
                .addExitButton()
                .setCancelAllClicks(true)
                .setItem(1, new ItemCreator(Material.GREEN_STAINED_GLASS_PANE).setName("§aTools").getItem())
                .setItem(2, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("§7Armor").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        Config.getInstance().LASTSHOPPAGE.put(inventory.getViewers().get(0).getName(),"armor");
                        inventory.getViewers().get(0).openInventory(new ShopArmorInventory(player).getInventory());
                    }
                })
                .setItem(3, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("§7Pets").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        Config.getInstance().LASTSHOPPAGE.put(inventory.getViewers().get(0).getName(),"pets");
                        inventory.getViewers().get(0).openInventory(new ShopPetsInventory(player).getInventory());
                    }
                })
                .setItem(4, new ItemCreator(Material.GRAY_STAINED_GLASS_PANE).setName("§7Potions").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        Config.getInstance().LASTSHOPPAGE.put(inventory.getViewers().get(0).getName(),"potions");
                        inventory.getViewers().get(0).openInventory(new ShopPotionsInventory(player).getInventory());
                    }
                })
                .addItemSwitch(10
                        , new ItemCreator(Material.WOODEN_AXE).setName("§7" + Pickaxe[0])
                                .setLore("§7Cost:  Gold: " + Pickaxe[1]
                                        , "§7Damage: " + Pickaxe[2]
                                        , "§7Resource Amount: " + Pickaxe[3]
                                        , "§7Attackspeed: " + Pickaxe[4]
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {

                            }
                        }
                        , new ItemCreator(Material.WOODEN_AXE).setName("§7" + Pickaxe[0])
                                .setLore("§4You can afford this upgrade"
                                        ,"§7" + (Pickaxe[1] - playergold) + " More Gold needed"
                                ).getItem()
                        , null
                        , 0
                        , 0
                        , Pickaxe[1]
                        , null
                        , null
                        , player)
                .addItemSwitch(11
                        , new ItemCreator(Material.WOODEN_SWORD).setName("§7" + Spear[0])
                                .setLore("§7Cost:  Gold: " + Spear[1]
                                        , "§7Damage: " + Spear[2]
                                        , "§7Range: " + Spear[3]
                                        , "§7Attackspeed: " + Spear[4]
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {

                            }
                        }
                        , new ItemCreator(Material.WOODEN_SWORD).setName("§7" + Spear[0])
                                .setLore("§4You can afford this upgrade"
                                        ,"§7" + (Spear[1] - playergold) + " More Gold needed"
                                ).getItem()
                        , null
                        , 0
                        , 0
                        , Spear[1]
                        , null
                        , null
                        , player)
                .addItemSwitch(12
                        , new ItemCreator(Material.BOW).setName("§7" + Bow[0])
                                .setLore("§7Cost:  Gold: " + Bow[1]
                                        , "§7Damage: " + Bow[2]
                                        , "§7Attackspeed: " + Bow[3]
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {

                            }
                        }
                        , new ItemCreator(Material.BOW).setName("§7" + Bow[0])
                                .setLore("§4You can afford this upgrade"
                                        ,"§7" + (Bow[1] - playergold) + " More Gold needed"
                                ).getItem()
                        , null
                        , 0
                        , 0
                        , Bow[1]
                        , null
                        , null
                        , player)
                .addItemSwitch(13
                        , new ItemCreator(Material.FIRE_CHARGE).setName("§7" + Bomb[0])
                                .setLore("§7Cost:  Gold: " + Bomb[1]
                                        , "§7Damage: " + Bomb[2]
                                        , "§7Range: " + Bomb[3]
                                        , "§7Attackspeed: " + Bomb[4]
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {

                            }
                        }
                        , new ItemCreator(Material.FIRE_CHARGE).setName("§7" + Bomb[0])
                                .setLore("§4You can afford this upgrade"
                                        ,"§7" + (Bomb[1] - playergold) + " More Gold needed"
                                ).getItem()
                        , null
                        , 0
                        , 0
                        , Bomb[1]
                        , null
                        , null
                        , player)
                .getInventory();
    }

    public Inventory getInventory() {
        return inventory;
    }
}
