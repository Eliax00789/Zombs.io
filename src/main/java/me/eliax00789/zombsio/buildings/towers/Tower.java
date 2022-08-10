package me.eliax00789.zombsio.buildings.towers;

import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class Tower {

    String name;
    Integer level;
    Location location;
    Material[][][] mk1;
    Material[][][] mk2;
    Material[][][] mk3;
    Material[][][] mk4;
    Material[][][] mk5;
    Material[][][] mk6;
    Material[][][] mk7;
    Material[][][] mk8;

    Integer currenthealth;
    Integer[] health;
    Integer[] damage;
    Integer[] range;
    Integer[] wood;
    Integer[] stone;
    Integer[] gold;

    public Tower(String name, Location location,
                 Material[][][] mk1, Material[][][] mk2, Material[][][] mk3, Material[][][] mk4, Material[][][] mk5, Material[][][] mk6, Material[][][] mk7, Material[][][] mk8,
                 Integer[] health,Integer[] damage,Integer[] range,
                 Integer[] wood,Integer[] stone,Integer[] gold) {
        this.name = name; this.level = 1; this.location = location;
        this.mk1 = mk1; this.mk2 = mk2; this.mk3 = mk3; this.mk4 = mk4; this.mk5 = mk5; this.mk6 = mk6; this.mk7 = mk7; this.mk8 = mk8;
        this.currenthealth = health[0]; this.health = health; this.damage = damage; this.range = range;
        this.wood = wood; this.stone = stone; this.gold = gold;
        build();
    }

    private void build() {
        if (level.equals(1)) {
            Location structOrigin = location.add(-1,0,-1);
            for ( int x = 0; x < mk1.length; x ++) {
                for (int y = 0; y < mk1[x].length; y++) {
                    for (int z = 0; z < mk1[x][y].length; z++) {
                        Location tmp = structOrigin.clone();
                        tmp.add(x,y,z).getBlock().setType(mk1[x][y][z]);
                    }
                }
            }
        }
        else if (level.equals(2)) {
            Location structOrigin = location.add(-1,0,-1);
            for ( int x = 0; x < mk2.length; x ++) {
                for (int y = 0; y < mk2[x].length; y++) {
                    for (int z = 0; z < mk2[x][y].length; z++) {
                        Location tmp = structOrigin.clone();
                        tmp.add(x,y,z).getBlock().setType(mk2[x][y][z]);
                    }
                }
            }
        }
        else if (level.equals(3)) {
            Location structOrigin = location.add(-1,0,-1);
            for ( int x = 0; x < mk3.length; x ++) {
                for (int y = 0; y < mk3[x].length; y++) {
                    for (int z = 0; z < mk3[x][y].length; z++) {
                        Location tmp = structOrigin.clone();
                        tmp.add(x,y,z).getBlock().setType(mk3[x][y][z]);
                    }
                }
            }
        }
        else if (level.equals(4)) {
            Location structOrigin = location.add(-1,0,-1);
            for ( int x = 0; x < mk4.length; x ++) {
                for (int y = 0; y < mk4[x].length; y++) {
                    for (int z = 0; z < mk4[x][y].length; z++) {
                        Location tmp = structOrigin.clone();
                        tmp.add(x,y,z).getBlock().setType(mk4[x][y][z]);
                    }
                }
            }
        }
        else if (level.equals(5)) {
            Location structOrigin = location.add(-1,0,-1);
            for ( int x = 0; x < mk5.length; x ++) {
                for (int y = 0; y < mk5[x].length; y++) {
                    for (int z = 0; z < mk5[x][y].length; z++) {
                        Location tmp = structOrigin.clone();
                        tmp.add(x,y,z).getBlock().setType(mk5[x][y][z]);
                    }
                }
            }
        }
        else if (level.equals(6)) {
            Location structOrigin = location.add(-1,0,-1);
            for ( int x = 0; x < mk6.length; x ++) {
                for (int y = 0; y < mk6[x].length; y++) {
                    for (int z = 0; z < mk6[x][y].length; z++) {
                        Location tmp = structOrigin.clone();
                        tmp.add(x,y,z).getBlock().setType(mk6[x][y][z]);
                    }
                }
            }
        }
        else if (level.equals(7)) {
            Location structOrigin = location.add(-1,0,-1);
            for ( int x = 0; x < mk7.length; x ++) {
                for (int y = 0; y < mk7[x].length; y++) {
                    for (int z = 0; z < mk7[x][y].length; z++) {
                        Location tmp = structOrigin.clone();
                        tmp.add(x,y,z).getBlock().setType(mk7[x][y][z]);
                    }
                }
            }
        }
        else if (level.equals(8)) {
            Location structOrigin = location.add(-1,0,-1);
            for ( int x = 0; x < mk8.length; x ++) {
                for (int y = 0; y < mk8[x].length; y++) {
                    for (int z = 0; z < mk8[x][y].length; z++) {
                        Location tmp = structOrigin.clone();
                        tmp.add(x,y,z).getBlock().setType(mk8[x][y][z]);
                    }
                }
            }
        }
    }
}