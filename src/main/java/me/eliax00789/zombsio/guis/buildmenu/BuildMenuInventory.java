package me.eliax00789.zombsio.guis.buildmenu;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.Building;
import me.eliax00789.zombsio.buildings.other.Door;
import me.eliax00789.zombsio.buildings.other.SlowTrap;
import me.eliax00789.zombsio.buildings.other.Wall;
import me.eliax00789.zombsio.buildings.resources.GoldMine;
import me.eliax00789.zombsio.buildings.resources.GoldStash;
import me.eliax00789.zombsio.buildings.resources.ResourceHarvester;
import me.eliax00789.zombsio.buildings.towers.*;
import me.eliax00789.zombsio.utility.Config;
import me.eliax00789.zombsio.utility.GUICreator;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.scheduler.BukkitRunnable;

class BuildMenuInventory {
    private Inventory inventory;
    public BuildMenuInventory(Location location, Player player) {
        Integer currentStashLvl = 0;
        Integer neededStashLvl = 1;
        for (int i = 0; i < Zombsio.buildings.getInt("nextid"); i++) {
            if (Zombsio.buildings.contains("buildings." + i + ".name") && Zombsio.buildings.getString("buildings." + i + ".name").equals("GoldStash")) {
               currentStashLvl = Zombsio.buildings.getInt("buildings." + i + ".level");
            }
        }
        Bukkit.broadcastMessage(String.valueOf(currentStashLvl));

        inventory = new GUICreator(9 * 4,"Build Menu")
                .setCancelAllClicks(true)
                .fillPlaceHolder()
                .addExitButton()
                .setItem(10, new ItemCreator(Material.RAW_GOLD_BLOCK).setName("§7Gold Stash")
                        .setLore("§7Cost:  Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldStash.Gold").get(0)
                                ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldStash.Health").get(0)
                                ,"§7Unlocks: " + Zombsio.plugin.getConfig().getList("Buildings.GoldStash.Unlocks").get(0)
                        ).getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        new GoldStash(player,location, 1);
                        player.closeInventory();
                    }
                })
                .addItemSwitch(11, new ItemCreator(Material.GOLD_NUGGET).setName("§7Gold Mine")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Health").get(0)
                                        ,"§7Production: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Goldgen").get(0) + " gold/sec"
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {
                                new GoldMine(player, location, 1);
                                player.closeInventory();
                            }
                        }, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Gold Mine (Not Enough Resources)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Health").get(0)
                                        ,"§7Production: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Goldgen").get(0) + " gold/sec"
                                ).getItem()
                        , new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Gold Mine (Higher Stash Level Needed)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Health").get(0)
                                        ,"§7Production: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Goldgen").get(0) + " gold/sec"
                                ).getItem()
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.GoldMine.Wood").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.GoldMine.Stone").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.GoldMine.Gold").get(0)
                        , currentStashLvl
                        , neededStashLvl
                        , player)
                .addItemSwitch(12, new ItemCreator(Material.DIAMOND_PICKAXE).setName("§7Resource Harvester")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.ResourceHarvester.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.ResourceHarvester.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.ResourceHarvester.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.ResourceHarvester.Health").get(0)
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {
                                new ResourceHarvester(player, location, 1);
                                player.closeInventory();
                            }
                        }, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Resource Harvester (Not Enough Resources)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.ResourceHarvester.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.ResourceHarvester.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.ResourceHarvester.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.ResourceHarvester.Health").get(0)
                                ).getItem()
                        , new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Resource Harvester (Higher Stash Level Needed)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Health").get(0)
                                        ,"§7Production: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Goldgen").get(0) + " gold/sec"
                                ).getItem()
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.ResourceHarvester.Wood").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.ResourceHarvester.Stone").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.ResourceHarvester.Gold").get(0)
                        , currentStashLvl
                        , neededStashLvl
                        , player)
                .addItemSwitch(14, new ItemCreator(Material.IRON_BARS).setName("§7Wall")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.Wall.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.Wall.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.Wall.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.Wall.Health").get(0)
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {
                                new Wall(player,location, 1);
                                player.closeInventory();
                            }
                        }, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Wall (Not Enough Resources)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.Wall.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.Wall.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.Wall.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.Wall.Health").get(0)
                                ).getItem()
                        , new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Wall (Higher Stash Level Needed)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Health").get(0)
                                        ,"§7Production: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Goldgen").get(0) + " gold/sec"
                                ).getItem()
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.Wall.Wood").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.Wall.Stone").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.Wall.Gold").get(0)
                        , currentStashLvl
                        , neededStashLvl
                        , player)
                .addItemSwitch(15, new ItemCreator(Material.IRON_DOOR).setName("§7Door")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.Door.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.Door.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.Door.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.Door.Health").get(0)
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {
                                new Door(player,location, 1);
                                player.closeInventory();
                            }
                        }, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Door (Not Enough Resources)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.Door.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.Door.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.Door.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.Door.Health").get(0)
                                ).getItem()
                        , new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Door (Higher Stash Level Needed)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Health").get(0)
                                        ,"§7Production: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Goldgen").get(0) + " gold/sec"
                                ).getItem()
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.Door.Wood").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.Door.Stone").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.Door.Gold").get(0)
                        , currentStashLvl
                        , neededStashLvl
                        , player)
                .addItemSwitch(16, new ItemCreator(Material.HONEYCOMB).setName("§7Slow Trap")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.SlowTrap.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.SlowTrap.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.SlowTrap.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.SlowTrap.Health").get(0)
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {
                                new SlowTrap(player, location, 1);
                                player.closeInventory();
                            }
                        }, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Slow Trap (Not Enough Resources)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.SlowTrap.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.SlowTrap.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.SlowTrap.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.SlowTrap.Health").get(0)
                                ).getItem()
                        , new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Slow Trap (Higher Stash Level Needed)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Health").get(0)
                                        ,"§7Production: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Goldgen").get(0) + " gold/sec"
                                ).getItem()
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.SlowTrap.Wood").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.SlowTrap.Stone").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.SlowTrap.Gold").get(0)
                        , currentStashLvl
                        , neededStashLvl
                        , player)
                .addItemSwitch(20, new ItemCreator(Material.ARROW).setName("§7Arrow Tower")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.ArrowTower.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.ArrowTower.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.ArrowTower.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.ArrowTower.Health").get(0)
                                        ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Buildings.ArrowTower.Damage").get(0)
                                        ,"§7Range: " + Zombsio.plugin.getConfig().getList("Buildings.ArrowTower.Range").get(0)
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {
                                new ArrowTower(player,location, 1);
                                player.closeInventory();
                            }
                        }, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Arrow Tower (Not Enough Resources)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.ArrowTower.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.ArrowTower.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.ArrowTower.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.ArrowTower.Health").get(0)
                                        ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Buildings.ArrowTower.Damage").get(0)
                                        ,"§7Range: " + Zombsio.plugin.getConfig().getList("Buildings.ArrowTower.Range").get(0)
                                ).getItem()
                        , new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Arrow Tower (Higher Stash Level Needed)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Health").get(0)
                                        ,"§7Production: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Goldgen").get(0) + " gold/sec"
                                ).getItem()
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.ArrowTower.Wood").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.ArrowTower.Stone").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.ArrowTower.Gold").get(0)
                        , currentStashLvl
                        , neededStashLvl
                        , player)
                .addItemSwitch(21, new ItemCreator(Material.FIRE_CHARGE).setName("§7Cannon Tower")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.CannonTower.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.CannonTower.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.CannonTower.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.CannonTower.Health").get(0)
                                        ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Buildings.CannonTower.Damage").get(0)
                                        ,"§7Range: " + Zombsio.plugin.getConfig().getList("Buildings.CannonTower.Range").get(0)
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {
                                new CannonTower(player, location, 1);
                                player.closeInventory();
                            }
                        }, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Cannon Tower (Not Enough Resources)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.CannonTower.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.CannonTower.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.CannonTower.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.CannonTower.Health").get(0)
                                        ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Buildings.CannonTower.Damage").get(0)
                                        ,"§7Range: " + Zombsio.plugin.getConfig().getList("Buildings.CannonTower.Range").get(0)
                                ).getItem()
                        , new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Cannon Tower (Higher Stash Level Needed)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Health").get(0)
                                        ,"§7Production: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Goldgen").get(0) + " gold/sec"
                                ).getItem()
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.CannonTower.Wood").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.CannonTower.Stone").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.CannonTower.Gold").get(0)
                        , currentStashLvl
                        , neededStashLvl
                        , player)
                .addItemSwitch(22, new ItemCreator(Material.TNT).setName("§7Bomb Tower")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Health").get(0)
                                        ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Damage").get(0)
                                        ,"§7Range: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Range").get(0)
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {
                                new BombTower(player,location, 1);
                                player.closeInventory();
                            }
                        }, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Bomb Tower (Not Enough Resources)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Health").get(0)
                                        ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Damage").get(0)
                                        ,"§7Range: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Range").get(0)
                                ).getItem()
                        , new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Bomb Tower (Higher Stash Level Needed)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Health").get(0)
                                        ,"§7Production: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Goldgen").get(0) + " gold/sec"
                                ).getItem()
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.BombTower.Wood").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.BombTower.Stone").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.BombTower.Gold").get(0)
                        , currentStashLvl
                        , neededStashLvl
                        , player)
                .addItemSwitch(23, new ItemCreator(Material.ENCHANTED_BOOK).setName("§7Mage Tower")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Health").get(0)
                                        ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Damage").get(0)
                                        ,"§7Range: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Range").get(0)
                                ).addEnchant(Enchantment.MULTISHOT, 69420, true).addFlag(ItemFlag.HIDE_ENCHANTS).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {
                                new MageTower(player,location, 1);
                                player.closeInventory();
                            }
                        }, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Mage Tower (Not Enough Resources)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.MageTower.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.MageTower.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.MageTower.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.MageTower.Health").get(0)
                                        ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Buildings.MageTower.Damage").get(0)
                                        ,"§7Range: " + Zombsio.plugin.getConfig().getList("Buildings.MageTower.Range").get(0)
                                ).getItem()
                        , new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Mage Tower (Higher Stash Level Needed)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Health").get(0)
                                        ,"§7Production: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Goldgen").get(0) + " gold/sec"
                                ).getItem()
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.MageTower.Wood").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.MageTower.Stone").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.MageTower.Gold").get(0)
                        , currentStashLvl
                        , neededStashLvl
                        , player)
                .addItemSwitch(24, new ItemCreator(Material.STONE_SWORD).setName("§7Melee Tower")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Health").get(0)
                                        ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Damage").get(0)
                                        ,"§7Range: " + Zombsio.plugin.getConfig().getList("Buildings.BombTower.Range").get(0)
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {
                                new MeleeTower(player,location, 1);
                                player.closeInventory();
                            }
                        }, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Melee Tower (Not Enough Resources)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.MeleeTower.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.MeleeTower.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.MeleeTower.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.MeleeTower.Health").get(0)
                                        ,"§7Damage: " + Zombsio.plugin.getConfig().getList("Buildings.MeleeTower.Damage").get(0)
                                        ,"§7Range: " + Zombsio.plugin.getConfig().getList("Buildings.MeleeTower.Range").get(0)
                                ).getItem()
                        , new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Melee Tower (Higher Stash Level Needed)")
                                .setLore("§7Cost:  Wood: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Wood").get(0)
                                        ,"§7      Stone: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Stone").get(0)
                                        ,"§7      Gold: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Gold").get(0)
                                        ,"§7Health: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Health").get(0)
                                        ,"§7Production: " + Zombsio.plugin.getConfig().getList("Buildings.GoldMine.Goldgen").get(0) + " gold/sec"
                                ).getItem()
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.MeleeTower.Wood").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.MeleeTower.Stone").get(0)
                        , Zombsio.plugin.getConfig().getIntegerList("Buildings.MeleeTower.Gold").get(0)
                        , currentStashLvl
                        , neededStashLvl
                        , player)
                .getInventory();
    }


    public Inventory getInventory() {
        return inventory;
    }
}
