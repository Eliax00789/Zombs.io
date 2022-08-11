package me.eliax00789.zombsio.buildings.other;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.Building;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Door extends Building {

    private static Material[][][] mk1 = new Material[][][]{
            { // x = 0
                    {Material.AIR}, // y = 0
                    {Material.AIR}, // y = 1
                    {Material.AIR},  // y = 2
                    {Material.GLASS}, // y = 3
                    {Material.DIRT} // y = 4
            },

    };
    private static Material[][][] mk2 = new Material[][][]{
            { // x = 0
                    {Material.AIR}, // y = 0
                    {Material.AIR}, // y = 1
                    {Material.AIR},  // y = 2
                    {Material.GLASS}, // y = 3
                    {Material.STONE} // y = 4
            },


    };
    private static Material[][][] mk3 = new Material[][][]{
            { // x = 0
                    {Material.AIR}, // y = 0
                    {Material.AIR}, // y = 1
                    {Material.AIR},  // y = 2
                    {Material.GLASS}, // y = 3
                    {Material.IRON_BLOCK} // y = 4
            },


    };
    private static Material[][][] mk4 = new Material[][][]{
            { // x = 0
                    {Material.AIR}, // y = 0
                    {Material.AIR}, // y = 1
                    {Material.AIR},  // y = 2
                    {Material.GLASS}, // y = 3
                    {Material.GOLD_BLOCK} // y = 4
            },


    };
    private static Material[][][] mk5 = new Material[][][]{
            { // x = 0
                    {Material.AIR}, // y = 0
                    {Material.AIR}, // y = 1
                    {Material.AIR},  // y = 2
                    {Material.GLASS}, // y = 3
                    {Material.OBSIDIAN} // y = 4
            },


    };
    private static Material[][][] mk6 = new Material[][][]{
            { // x = 0
                    {Material.AIR}, // y = 0
                    {Material.AIR}, // y = 1
                    {Material.AIR},  // y = 2
                    {Material.GLASS}, // y = 3
                    {Material.DIAMOND_BLOCK} // y = 4
            },


    };
    private static Material[][][] mk7 = new Material[][][]{
            { // x = 0
                    {Material.AIR}, // y = 0
                    {Material.AIR}, // y = 1
                    {Material.AIR},  // y = 2
                    {Material.GLASS}, // y = 3
                    {Material.NETHERITE_BLOCK} // y = 4
            },


    };
    private static Material[][][] mk8 = new Material[][][]{
            { // x = 0
                    {Material.AIR}, // y = 0
                    {Material.AIR}, // y = 1
                    {Material.AIR},  // y = 2
                    {Material.GLASS}, // y = 3
                    {Material.EMERALD_BLOCK} // y = 4
            },


    };

    public Door(Player player, Location location) {
        super(player,"Door",1,8,location,
                null,null,null,
                new Material[][][][]{mk1,mk2,mk3,mk4,mk5,mk6,mk7,mk8},
                Zombsio.plugin.getConfig().getIntegerList("Buildings.Door.Health"),
                null,
                null,
                Zombsio.plugin.getConfig().getIntegerList("Buildings.Door.Wood"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.Door.Stone"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.Door.Gold"));
    }
}
