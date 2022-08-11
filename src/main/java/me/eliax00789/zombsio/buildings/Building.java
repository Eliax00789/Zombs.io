package me.eliax00789.zombsio.buildings;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.towers.MeleeTower;
import me.eliax00789.zombsio.buildings.towers.projectiles.CustomProjectile;
import me.eliax00789.zombsio.utility.Config;
import me.eliax00789.zombsio.utility.GUICreator;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
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
    private String name;
    private Integer level;
    private Integer maxLevel;
    private Location location;
    private Material [][][][] structure;
    private Integer currentHealth;
    private List<Integer>  health;
    private List<Integer>  damage;
    private List<Integer>  range;
    private List<Integer>  wood;
    private List<Integer>  stone;
    private List<Integer>  gold;

    private Inventory inventory;

    public Building(Player builder,String name, Integer level, Integer maxLevel, Location location,
                    @Nullable CustomProjectile projectile, @Nullable Location projectileShootOffset, @Nullable Integer shootCoolDown,
                    Material[][][][] structure,
                    @Nullable List<Integer> health,@Nullable List<Integer> damage,@Nullable List<Integer> range,
                    @Nullable List<Integer> wood,@Nullable List<Integer> stone,@Nullable List<Integer> gold) {
        this.id = (Integer) Zombsio.buildings.get("nextid");
        Zombsio.buildings.set("nextid",id + 1);
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

        if (hasResources(builder)) {
            removeResources(builder);
            build();
            Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
        }

        if (projectile != null) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    projectile.shoot();
                }
            }.runTaskTimer(Zombsio.plugin,0,shootCoolDown);
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
        Location structOrigin = location.clone().add(-1,0,-1);
        for ( int x = 0; x < temp.length; x ++) {
            for (int y = 0; y < temp[x].length; y++) {
                for (int z = 0; z < temp[x][y].length; z++) {
                    Location tmp = structOrigin.clone();
                    tmp.add(x,y,z).getBlock().setType(temp[x][y][z]);
                }
            }
        }
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
        if (Config.getInstance().WOOD.get(player.getName()) >= wood.get(level)
                && Config.getInstance().STONE.get(player.getName()) >= stone.get(level)
                && Config.getInstance().GOLD.get(player.getName()) >= gold.get(level)) {return true;}
        else {return false;}
    }

    private void removeResources(Player player) {
        Config.getInstance().WOOD.put(player.getName(),Config.getInstance().WOOD.get(player.getName()) - wood.get(level));
        Config.getInstance().STONE.put(player.getName(),Config.getInstance().STONE.get(player.getName()) - stone.get(level));
        Config.getInstance().GOLD.put(player.getName(),Config.getInstance().GOLD.get(player.getName()) - gold.get(level));
    }

    private void remove() {
        Location structOrigin = location.clone().add(-1,0,-1);
        for ( int x = 0; x < structure[0].length; x ++) {
            for (int y = 0; y < structure[0][x].length; y++) {
                for (int z = 0; z < structure[0][x][y].length; z++) {
                    Location tmp = structOrigin.clone();
                    tmp.add(x,y,z).getBlock().setType(Material.AIR);
                }
            }
        }
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Location structOrigin = location.clone().add(-1,0,-1);
            for ( int x = 0; x < structure[level - 1].length; x ++) {
                for (int y = 0; y < structure[level - 1][x].length; y++) {
                    for (int z = 0; z < structure[level - 1][x][y].length; z++) {
                        Location tmp = structOrigin.clone();
                        if (e.getClickedBlock().equals(tmp.add(x,y,z).getBlock())) {
                            e.getPlayer().openInventory(getInventory(e.getPlayer()));
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
        if (level == maxLevel) {
            nextHealth = "";
            nextDamage = "";
            nextRange = "" ;
        }
        else {
            nextHealth = String.valueOf(health.get(level));
            nextDamage = String.valueOf(damage.get(level));
            nextRange = String.valueOf(range.get(level));
        }
        inventory = new GUICreator(9*3,name)
                .setCancelAllClicks(true)
                .fillPlaceHolder()
                .addExitButton()
                .addItemSwitch(24, new ItemCreator(Material.GREEN_STAINED_GLASS_PANE).setName("Upgrade")
                                .setLore("&7Cost for Tier " + (level + 1),
                                        "&7Wood: " + wood.get(level - 1),
                                        "&7Stone: " + stone.get(level - 1),
                                        "&7Gold: " + gold.get(level - 1)
                                ).getItem()
                        , new BukkitRunnable() {
                            @Override
                            public void run() {
                                upgrade(player);
                                player.closeInventory();
                            }
                        }, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("&4Can't be Upgraded")
                                .setLore("&7Cost for Tier " + (level + 1),
                                        "&7Wood: " + wood.get(level - 1),
                                        "&7Stone: " + stone.get(level - 1),
                                        "&7Gold: " + gold.get(level - 1),
                                        "&4You can afford this upgrade"
                                ).getItem()
                        , wood.get(level - 1)
                        , stone.get(level - 1)
                        , gold.get(level - 1)
                        , 0
                        , 0
                        , player)
                .setItem(13,new ItemCreator(Material.OAK_SIGN).setName("Stats")
                        .setLore("&7Tier " + level + " Building",
                                "&7Current > Next level",
                                "&7Health: " + health.get(level - 1) + " > " + nextHealth,
                                "&7Damage: " + damage.get(level - 1) + " > " + nextDamage,
                                "&7Range: " + range.get(level - 1) + " > " + nextRange).getItem())
                .setItem(15, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("Remove").getItem(), new BukkitRunnable() {
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