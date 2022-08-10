package me.eliax00789.zombsio.buildings.other;

import org.bukkit.Location;
import org.bukkit.Material;

public class Door {

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

    private Integer currenthealth;
    private Integer[] health = new Integer[]{150,200,300,500,700,1000,1500,2000};
    private Integer[] wood = new Integer[]{5,5,0,0,0,0,0,0};
    private Integer[] stone = new Integer[]{5,5,0,0,0,0,0,0};
    private Integer[] gold = new Integer[]{0,10,50,70,150,200,250,800};

    public Door(Location location) {
        currenthealth = health[0];
        build();
    }

    private void build() {

    }
}
