package me.eliax00789.zombsio.buildings.other;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.Building;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Wall extends Building {

    private static Material[][][] mk1 = new Material[][][]{
            { // x = 0
                    {Material.DIRT}, // y = 0
                    {Material.DIRT}, // y = 1
                    {Material.DIRT},  // y = 2
                    {Material.DIRT}, // y = 3
                    {Material.DIRT} // y = 4
            },

    };
    private static Material[][][] mk2 = new Material[][][]{
            { // x = 0
                    {Material.STONE}, // y = 0
                    {Material.STONE}, // y = 1
                    {Material.STONE},  // y = 2
                    {Material.STONE}, // y = 3
                    {Material.STONE} // y = 4
            },

    };
    private static Material[][][] mk3 = new Material[][][]{
            { // x = 0
                    {Material.IRON_BLOCK}, // y = 0
                    {Material.IRON_BLOCK}, // y = 1
                    {Material.IRON_BLOCK},  // y = 2
                    {Material.IRON_BLOCK}, // y = 3
                    {Material.IRON_BLOCK} // y = 4
            },

    };
    private static Material[][][] mk4 = new Material[][][]{
            { // x = 0
                    {Material.GOLD_BLOCK}, // y = 0
                    {Material.GOLD_BLOCK}, // y = 1
                    {Material.GOLD_BLOCK},  // y = 2
                    {Material.GOLD_BLOCK}, // y = 3
                    {Material.GOLD_BLOCK} // y = 4
            },

    };
    private static Material[][][] mk5 = new Material[][][]{
            { // x = 0
                    {Material.OBSIDIAN}, // y = 0
                    {Material.OBSIDIAN}, // y = 1
                    {Material.OBSIDIAN},  // y = 2
                    {Material.OBSIDIAN}, // y = 3
                    {Material.OBSIDIAN} // y = 4
            },

    };

    private static Material[][][] mk6 = new Material[][][]{
            { // x = 0
                    {Material.EMERALD_BLOCK}, // y = 0
                    {Material.EMERALD_BLOCK}, // y = 1
                    {Material.EMERALD_BLOCK},  // y = 2
                    {Material.EMERALD_BLOCK}, // y = 3
                    {Material.EMERALD_BLOCK} // y = 4
            },

    };


    private static Material[][][] mk7 = new Material[][][]{
            { // x = 0
                    {Material.DIAMOND_BLOCK}, // y = 0
                    {Material.DIAMOND_BLOCK}, // y = 1
                    {Material.DIAMOND_BLOCK},  // y = 2
                    {Material.DIAMOND_BLOCK}, // y = 3
                    {Material.DIAMOND_BLOCK} // y = 4
            },

    };
    private static Material[][][] mk8 = new Material[][][]{
            { // x = 0
                    {Material.NETHERITE_BLOCK}, // y = 0
                    {Material.NETHERITE_BLOCK}, // y = 1
                    {Material.NETHERITE_BLOCK},  // y = 2
                    {Material.NETHERITE_BLOCK}, // y = 3
                    {Material.NETHERITE_BLOCK} // y = 4
            },

    };

    public Wall(Player player, Location location) {
        super(player,"Wall",1,8,location,
                null,null,null,
                new Material[][][][]{mk1,mk2,mk3,mk4,mk5,mk6,mk7,mk8},
                Zombsio.plugin.getConfig().getIntegerList("Buildings.Wall.Health"),
                null,
                null,
                Zombsio.plugin.getConfig().getIntegerList("Buildings.Wall.Wood"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.Wall.Stone"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.Wall.Gold"));
    }
}
