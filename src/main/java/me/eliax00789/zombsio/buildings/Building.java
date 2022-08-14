package me.eliax00789.zombsio.buildings;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.other.Door;
import me.eliax00789.zombsio.buildings.other.SlowTrap;
import me.eliax00789.zombsio.buildings.other.Wall;
import me.eliax00789.zombsio.buildings.resources.GoldMine;
import me.eliax00789.zombsio.buildings.resources.GoldStash;
import me.eliax00789.zombsio.buildings.towers.projectiles.CustomProjectile;
import me.eliax00789.zombsio.utility.Config;
import me.eliax00789.zombsio.utility.GUICreator;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Building implements Listener {
    public Integer id;
    public String name;
    public Integer level;
    private Integer maxLevel;
    public Location location;
    private Material [][][][] structure;
    private Integer currentHealth;
    private List<Integer>  health;
    private List<Integer>  damage;
    private List<Integer>  range;
    private List<Integer>  wood;
    private List<Integer>  stone;
    private List<Integer>  gold;
    private Inventory inventory;
    private BukkitRunnable projectileLoop;
    private BukkitRunnable goldLoop;

    public Building(@Nullable Player builder,String name, Integer level, Integer maxLevel, Location location,
                    @Nullable CustomProjectile projectile, @Nullable Location projectileShootOffset, @Nullable Integer shootCoolDown,
                    Material[][][][] structure,
                    @Nullable List<Integer> health,@Nullable List<Integer> damage,@Nullable List<Integer> range,
                    @Nullable List<Integer> wood,@Nullable List<Integer> stone,@Nullable List<Integer> gold) {
        if (locationSuits(location,structure) || builder == null) {
            this.id = Zombsio.buildings.getInt("nextid");
            BuildSave.buildingsMap.put(this.id,this);
            this.name = name;
            this.level = level;
            this.maxLevel = maxLevel;
            this.location = location;
            this.structure = structure;
            this.currentHealth = health.get(0);
            this.health = health;
            this.damage = damage;
            this.range = range;
            this.wood = wood;
            this.stone = stone;
            this.gold = gold;
            if (health == null) {
                this.health = new ArrayList<Integer>();
                for (Integer i = 0;i <= maxLevel;i++) {
                    this.health.add(0);
                }
            }
            if (damage == null) {
                this.damage = new ArrayList<Integer>();
                for (Integer i = 0;i <= maxLevel;i++) {
                    this.damage.add(0);
                }
            }
            if (range == null) {
                this.range = new ArrayList<Integer>();
                for (Integer i = 0;i <= maxLevel;i++) {
                    this.range.add(0);
                }
            }
            if (wood == null) {
                this.wood = new ArrayList<Integer>();
                for (Integer i = 0;i <= maxLevel;i++) {
                    this.wood.add(0);
                }
            }
            if (stone == null) {
                this.stone = new ArrayList<Integer>();
                for (Integer i = 0;i <= maxLevel;i++) {
                    this.stone.add(0);
                }
            }
            if (gold == null) {
                this.gold = new ArrayList<Integer>();
                for (Integer i = 0;i <= maxLevel;i++) {
                    this.gold.add(0);
                }
            }
            if (builder != null) {
                if (hasResources(builder)) {
                    removeResources(builder);
                    build();
                    Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
                }
            }
            else {
                build();
                Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
            }

            if (this instanceof GoldMine) {
                goldLoop = new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (Player player: Bukkit.getOnlinePlayers()) {
                            if (player.getWorld().equals(location.getWorld())) {
                                Config.getInstance().GOLD.put(player.getName(),Config.getInstance().GOLD.get(player.getName()) + Zombsio.plugin.getConfig().getIntegerList("Buildings.GoldMine.Goldgen").get(level - 1));
                            }
                        }
                    }
                };
                goldLoop.runTaskTimer(Zombsio.plugin, 0, 20);
            }

            if (projectile != null) {
                projectileLoop = new BukkitRunnable() {
                    @Override
                    public void run() {
                        projectile.shoot();
                    }
                };
                projectileLoop.runTaskTimer(Zombsio.plugin,0,shootCoolDown);
            }

        }
        else {
            if (builder != null) {
                builder.sendMessage("Not enough space for " + name);
            }
        }
    }

    private void build() {
        Material[][][] temp;
        if (level.equals(1)) {temp = structure[0];}
        else if (level.equals(2)) {temp = structure[1];}
        else if (level.equals(3)) {temp = structure[2];}
        else if (level.equals(4)) {temp = structure[3];}
        else if (level.equals(5)) {temp = structure[4];}
        else if (level.equals(6)) {temp = structure[5];}
        else if (level.equals(7)) {temp = structure[6];}
        else if (level.equals(8)) {temp = structure[7];}
        else {temp = structure[0];}
        Location structOrigin;
        if(this instanceof Door || this instanceof Wall) {
            structOrigin = location.clone();
        } else if (this instanceof SlowTrap) {
            structOrigin = location.clone().add(0,-1,0);
        } else {
            structOrigin = location.clone().add(-1, 0, -1);
        }
        for ( int x = 0; x < temp.length; x ++) {
            for (int y = 0; y < temp[x].length; y++) {
                for (int z = 0; z < temp[x][y].length; z++) {
                    Location tmp = structOrigin.clone();
                    tmp.add(x,y,z).getBlock().setType(temp[x][y][z]);
                }
            }
        }
        BuildSave.save();
    }

    private void upgrade(Player player) {
        if (!(level == maxLevel)) {
            if (hasResources(player)) {
                removeResources(player);
                level++;
                build();
            }
        }
    }

    private boolean hasResources(Player player) {
        if (Config.getInstance().WOOD.get(player.getName()) >= wood.get(level -1)
                && Config.getInstance().STONE.get(player.getName()) >= stone.get(level - 1 )
                && Config.getInstance().GOLD.get(player.getName()) >= gold.get(level - 1)) {return true;}
        else {return false;}
    }

    private void removeResources(Player player) {
        Config.getInstance().WOOD.put(player.getName(),Config.getInstance().WOOD.get(player.getName()) - wood.get(level - 1 ));
        Config.getInstance().STONE.put(player.getName(),Config.getInstance().STONE.get(player.getName()) - stone.get(level - 1));
        Config.getInstance().GOLD.put(player.getName(),Config.getInstance().GOLD.get(player.getName()) - gold.get(level - 1));
    }

    private Boolean locationSuits(Location location, Material[][][][] structure) {
        Boolean locationTrue = true;
        Material[][][] temp = structure[0];
        Location structOrigin;
        if(this instanceof Door || this instanceof Wall) {
            structOrigin = location.clone();
        } else if (this instanceof SlowTrap) {
            structOrigin = location.clone().add(0,-1,0);
        }  else {
            structOrigin = location.clone().add(-1, 0, -1);
        }
        for ( int x = 0; x < temp.length; x ++) {
            for (int y = 0; y < temp[x].length; y++) {
                for (int z = 0; z < temp[x][y].length; z++) {
                    Location tmp = structOrigin.clone();
                    if (!tmp.add(x,y,z).getBlock().getType().equals(Material.AIR)){
                        locationTrue = false;
                    }
                }
            }
        }
        return locationTrue;
    }

    private void remove() {
        BuildSave.buildingsMap.remove(this.id);
        PlayerInteractEvent.getHandlerList().unregister(this);
        if (projectileLoop != null) {
            projectileLoop.cancel();
        }
        if (goldLoop != null) {
            goldLoop.cancel();
        }
        Location structOrigin;
        if(this instanceof Door || this instanceof Wall) {
            structOrigin = location.clone();
        } else if (this instanceof SlowTrap) {
            structOrigin = location.clone().add(0,-1,0);
        }  else {
            structOrigin = location.clone().add(-1, 0, -1);
        }
        for ( int x = 0; x < structure[0].length; x ++) {
            for (int y = 0; y < structure[0][x].length; y++) {
                for (int z = 0; z < structure[0][x][y].length; z++) {
                    Location tmp = structOrigin.clone();
                    tmp.add(x,y,z).getBlock().setType(Material.AIR);
                }
            }
        }
        BuildSave.save();
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Location structOrigin;
            if(this instanceof Door || this instanceof Wall) {
                structOrigin = location.clone();
            } else if (this instanceof SlowTrap) {
                structOrigin = location.clone().add(0,-1,0);
            }  else {
                structOrigin = location.clone().add(-1, 0, -1);
            }
            for ( int x = 0; x < structure[level - 1].length; x ++) {
                for (int y = 0; y < structure[level - 1][x].length; y++) {
                    for (int z = 0; z < structure[level - 1][x][y].length; z++) {
                        Location tmp = structOrigin.clone();
                        if (e.getClickedBlock().equals(tmp.add(x,y,z).getBlock())) {
                            e.getPlayer().openInventory(getInventory(e.getPlayer()));
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }

    private Inventory getInventory(Player player) {
        String nextHealth;
        String nextDamage;
        String nextRange;
        String nextWood;
        String nextStone;
        String nextGold;
        if (level == maxLevel) {
            nextHealth = "0";
            nextDamage = "0";
            nextRange = "0" ;
            nextWood = "0";
            nextStone = "0";
            nextGold = "0";

        }
        else {
            nextHealth = String.valueOf(health.get(level));
            nextDamage = String.valueOf(damage.get(level));
            nextRange = String.valueOf(range.get(level));
            nextWood = String.valueOf(wood.get(level));
            nextStone = String.valueOf(stone.get(level));
            nextGold = String.valueOf(gold.get(level));
        }

        Integer currentStashLvl = 0;
        Integer neededStashLvl = level + 1;
        for (int i = 0; i < Zombsio.buildings.getInt("nextid"); i++) {
            if (Zombsio.buildings.contains("buildings." + i + ".name") && Zombsio.buildings.getString("buildings." + i + ".name").equals("GoldStash")) {
                currentStashLvl = Zombsio.buildings.getInt("buildings." + i + ".level");
            }
        }

        if (this instanceof GoldStash) {
            neededStashLvl = 0;
        }

        Integer morewoodamount = Integer.parseInt(nextWood) - Config.getInstance().WOOD.get(player.getName());
        Integer morestoneamount = Integer.parseInt(nextStone) - Config.getInstance().STONE.get(player.getName());
        Integer moregoldamount = Integer.parseInt(nextGold) - Config.getInstance().GOLD.get(player.getName());

        if (morewoodamount < 0) {
            morewoodamount = 0;
        }

        if (morestoneamount < 0) {
            morestoneamount = 0;
        }

        if (moregoldamount < 0) {
            moregoldamount = 0;
        }

        inventory = new GUICreator(9*3,name)
                .setCancelAllClicks(true)
                .fillPlaceHolder()
                .addExitButton()
                .addItemSwitch(11, new ItemCreator(Material.GREEN_STAINED_GLASS_PANE).setName("§7Upgrade")
                                .setLore("§7Cost for Tier " + (level + 1),
                                        "§7Wood: " + nextWood,
                                        "§7Stone: " + nextStone,
                                        "§7Gold: " + nextGold
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {
                                upgrade(player);
                                player.closeInventory();
                            }
                        }, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Can't be Upgraded (Not Enough Resources)")
                                .setLore("§4You can afford this upgrade",
                                        "§7" + morewoodamount + " More Wood needed" ,
                                        "§7" + morestoneamount + " More Stone needed" ,
                                        "§7" + moregoldamount + " More Gold needed"
                                ).getItem()
                        , new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("§4Can't be Upgraded (Higher Stash Level Needed)")
                                .setLore("§4Upgrade Your Stash"
                                        ,"§7Current Stash Level : " + currentStashLvl
                                        ,"§7Needed Stash Level: " + neededStashLvl
                                ).getItem()
                        , Integer.valueOf(nextWood)
                        , Integer.valueOf(nextStone)
                        , Integer.valueOf(nextGold)
                        , currentStashLvl
                        , neededStashLvl
                        , player)
                .addItemSwitch(13, new ItemCreator(Material.OAK_SIGN).setName("§7Stats")
                        .setLore("§7Tier " + level + " Building",
                                "§7Current > Next level",
                                "§7Health: " + health.get(level - 1) + " > " + nextHealth,
                                "§7Damage: " + damage.get(level - 1) + " > " + nextDamage,
                                "§7Range: " + range.get(level - 1) + " > " + nextRange).getItem()
                        , new ItemCreator(Material.OAK_SIGN).setName("§7Stats")
                        .setLore("§7Tier " + level + " Building",
                                "§7Health: " + health.get(level - 1),
                                "§7Damage: " + damage.get(level - 1),
                                "§7Range: " + range.get(level - 1)).getItem(), level, maxLevel)
                .setItem(15, new ItemCreator(Material.BARRIER).setName("Remove").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        remove();
                        player.closeInventory();
                    }
                })
                .getInventory();
        return inventory;
    }
}