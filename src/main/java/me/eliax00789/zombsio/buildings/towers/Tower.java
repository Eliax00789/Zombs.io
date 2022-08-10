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
    Integer[] health;
    Integer[] damage;
    Integer[] range;
    Integer[] wood;
    Integer[] stone;
    Integer[] gold;

    public Tower(String name, Integer level, Location location,
                 Material[][][] mk1, Material[][][] mk2, Material[][][] mk3, Material[][][] mk4, Material[][][] mk5, Material[][][] mk6, Material[][][] mk7, Material[][][] mk8,
                 Integer[] health,Integer[] damage,Integer[] range,
                 Integer[] wood,Integer[] stone,Integer[] gold) {
        this.name = name; this.level = level; this.location = location;
        this.mk1 = mk1; this.mk2 = mk2; this.mk3 = mk3; this.mk4 = mk4; this.mk5 = mk5; this.mk6 = mk6; this.mk7 = mk7; this.mk8 = mk8;
        this.health = health; this.damage = damage; this.range = range;
        this.wood = wood; this.stone = stone; this.gold = gold;
        build();
    }

    private void build() {
        if (level.equals(1)) {
            Location temploc = location.subtract(1 ,0 ,1).clone();

            temploc.add(0,0,0).getBlock().setType(mk1[0][0][0]);
            temploc = location.subtract(1 ,0 ,1).clone();
            temploc.add(0,0,1).getBlock().setType(mk1[0][0][1]);
            temploc = location.subtract(1 ,0 ,1).clone();
            temploc.add(0,0,2).getBlock().setType(mk1[0][0][2]);
        }
    }
}