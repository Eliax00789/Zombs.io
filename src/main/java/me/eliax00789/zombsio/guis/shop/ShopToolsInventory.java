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
    private Integer[] IntegerPickaxe, IntegerSpear, IntegerBow, IntegerBomb;
    public ShopToolsInventory(Player player) {
        Integer playergold = Config.getInstance().GOLD.get(player.getName());

        if (player.getInventory().getItem(0) != null) {
            if (player.getInventory().getItem(0).hasItemMeta()) {
                this.IntegerPickaxe = new Integer[]{
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
        }

        if (player.getInventory().getItem(1) != null) {
            if (player.getInventory().getItem(1).hasItemMeta()) {
                this.IntegerSpear = new Integer[]{
                        Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Name")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(1).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Gold")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(1).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Damage")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(1).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Range")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(1).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                        ,Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Attackspeed")
                        .get(java.lang.Integer.parseInt(player.getInventory().getItem(1).getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-1)
                };
            }
        }

        if (player.getInventory().getItem(2) != null) {
            if (player.getInventory().getItem(2).hasItemMeta()) {
                this.IntegerBow = new Integer[]{
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
        }

        if (player.getInventory().getItem(3) != null) {
            if (player.getInventory().getItem(3).hasItemMeta()) {
                this.IntegerBomb = new Integer[]{
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
                        , new ItemCreator(Material.WOODEN_AXE).setName("§7" + IntegerPickaxe[0])
                                .setLore("§7Cost:  Gold: " + IntegerPickaxe[1]
                                        , "§7Damage: " + IntegerPickaxe[2]
                                        , "§7Resource Amount: " + IntegerPickaxe[3]
                                        , "§7Attackspeed: " +IntegerPickaxe[4]
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {

                            }
                        }
                        , new ItemCreator(Material.WOODEN_AXE).setName("§7" + Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(0))
                                .setLore("§4You can afford this upgrade"
                                        ,"§7" + ((Zombsio.plugin.getConfig().getIntegerList("Buildings.MageTower.Gold").get(0)) - playergold) + " More Gold needed"
                                ).getItem()
                        , null
                        , 0
                        , 0
                        , Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Gold").get(0)
                        , null
                        , null, player)
                .setItem(10, new ItemCreator(Material.WOODEN_AXE).setName("§7" + Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(0))
                        .setLore("§7Cost:  Gold: " + Zombsio.plugin.getConfig().getList("Items.Pickaxe.Gold").get(0)
                                ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Items.Pickaxe.Damage").get(0)
                                ,"§7Resource Amount: " + Zombsio.plugin.getConfig().getList("Items.Pickaxe.Harvest").get(0)
                                ,"§7Attackspeed: " + Zombsio.plugin.getConfig().getList("Items.Pickaxe.Attackspeed").get(0)
                        ).getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(11, new ItemCreator(Material.WOODEN_SWORD).setName("§7" + Zombsio.plugin.getConfig().getStringList("Items.Spear.Name").get(0))
                        .setLore("§7Cost:  Gold: " + Zombsio.plugin.getConfig().getList("Items.Spear.Gold").get(0)
                                ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Items.Spear.Damage").get(0)
                                ,"§7Range: " + Zombsio.plugin.getConfig().getList("Items.Spear.Range").get(0)
                                ,"§7Attackspeed: " + Zombsio.plugin.getConfig().getList("Items.Spear.Attackspeed").get(0)
                        ).getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(12, new ItemCreator(Material.BOW).setName("§7" + Zombsio.plugin.getConfig().getStringList("Items.Bow.Name").get(0))
                        .setLore("§7Cost:  Gold: " + Zombsio.plugin.getConfig().getList("Items.Bow.Gold").get(0)
                                ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Items.Bow.Damage").get(0)
                                ,"§7Attackspeed: " + Zombsio.plugin.getConfig().getList("Items.Bow.Attackspeed").get(0)
                        ).getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {

                    }
                })
                .setItem(13, new ItemCreator(Material.FIRE_CHARGE).setName("§7" + Zombsio.plugin.getConfig().getStringList("Items.Bomb.Name").get(0))
                        .setLore("§7Cost:  Gold: " + Zombsio.plugin.getConfig().getList("Items.Bomb.Gold").get(0)
                                ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Items.Bomb.Damage").get(0)
                                ,"§7Range: " + Zombsio.plugin.getConfig().getList("Items.Bomb.Range").get(0)
                                ,"§7Attackspeed: " + Zombsio.plugin.getConfig().getList("Items.Bomb.Attackspeed").get(0)
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
