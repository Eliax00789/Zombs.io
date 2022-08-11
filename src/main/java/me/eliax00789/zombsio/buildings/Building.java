package me.eliax00789.zombsio.buildings;

import me.eliax00789.zombsio.Zombsio;
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
import java.util.List;

public class Building implements Listener {

    Integer id;
    private String name;
    private Integer level;
    private Integer maxLevel;
    private Location location;
    private Material [][][][] structure;
    private Integer currentHealth;
    private Integer[] health;
    private Integer[] damage;
    private Integer[] range;
    private Integer[] wood;
    private Integer[] stone;
    private Integer[] gold;

    private Inventory inventory;

    public Building(String name, Integer level, Integer maxLevel, Location location,
                    @Nullable CustomProjectile projectile, @Nullable Location projectileShootOffset, @Nullable Integer shootCoolDown,
                    Material[][][][] structure,
                    Integer[] health, Integer[] damage, Integer[] range,
                    Integer[] wood, Integer[] stone, Integer[] gold) {
        this.name = name;
        this.level = level;
        this.maxLevel = maxLevel;
        this.location = location;
        this.structure = structure;
        this.currentHealth = health[0];
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.wood = wood;
        this.stone = stone;
        this.gold = gold;

        this.id = (Integer) Zombsio.buildings.get("nextid");
        Zombsio.buildings.set("nextid",id + 1);

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
        Location structOrigin = location.add(-1,0,-1);
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
                level++;
                build();
            }
        }
    }

    private boolean hasResources(Player player) {
        if (Config.getInstance().WOOD.get(player.getName()) >= wood[level + 1]
                && Config.getInstance().STONE.get(player.getName()) >= stone[level + 1]
                && Config.getInstance().GOLD.get(player.getName()) >= gold[level + 1]) {return true;}
        else {return false;}
    }

    private void remove() {
        Location structOrigin = location.add(-1,0,-1);
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
            Location structOrigin = location.add(-1,0,-1);
            for ( int x = 0; x < structure[0].length; x ++) {
                for (int y = 0; y < structure[0][x].length; y++) {
                    for (int z = 0; z < structure[0][x][y].length; z++) {
                        Location tmp = structOrigin.clone();
                        if (e.getClickedBlock().equals(tmp.add(x,y,z).getBlock())) {
                            e.getPlayer().openInventory(getInventory());
                        }
                    }
                }
            }
        }
    }

    private Inventory getInventory() {
        String nextHealth;
        String nextDamage;
        String nextRange;
        if (level == maxLevel) {
            nextHealth = "";
            nextDamage = "";
            nextRange = "" ;
        }
        else {
            nextHealth = String.valueOf(health[level]);
            nextDamage = String.valueOf(damage[level]);
            nextRange = String.valueOf(range[level]);
        }
        inventory = new GUICreator(9*3,name)
                .setCancelAllClicks(true)
                .fillPlaceHolder()
                .addExitButton()
                .setItem(11, new ItemCreator(Material.GREEN_STAINED_GLASS_PANE).setName("Upgrade").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        upgrade((Player) inventory.getViewers().get(0));
                    }
                })
                .setItem(13,new ItemCreator(Material.OAK_SIGN).setName("Stats")
                        .setLore("Tier " + level + "Building",
                                "Current > Next level",
                                "Health: " + health[level - 1] + " > " + nextHealth,
                                "Damage: " + damage[level - 1] + " > " + nextDamage,
                                "Range: " + range[level - 1] + " > " + nextRange).getItem())
                .setItem(15, new ItemCreator(Material.RED_STAINED_GLASS_PANE).setName("Remove").getItem(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        remove();
                    }
                })
                .getInventory();
        return inventory;
    }
}