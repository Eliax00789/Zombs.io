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

    private Integer level;
    private Location location;
    private Integer currenthealth;
    private Integer[] health = new Integer[]{150,200,300,500,700,1000,1500,2000};
    private Integer[] wood = new Integer[]{5,5,0,0,0,0,0,0};
    private Integer[] stone = new Integer[]{5,5,0,0,0,0,0,0};
    private Integer[] gold = new Integer[]{0,10,50,70,150,200,250,800};

    public Door(Location location) {
        level = 1;
        this.location = location;
        currenthealth = health[0];
        build();
    }

    private void build() {
        if (level.equals(1)) {
            Location structOrigin = location.add(0,0,0);
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
            Location structOrigin = location.add(0,0,0);
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
            Location structOrigin = location.add(0,0,0);
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
            Location structOrigin = location.add(0,0,0);
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
            Location structOrigin = location.add(0,0,0);
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
            Location structOrigin = location.add(0,0,0);
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
            Location structOrigin = location.add(0,0,0);
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
            Location structOrigin = location.add(0,0,0);
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
