package me.eliax00789.zombsio.buildings.towers;

import org.bukkit.Material;

public class ArrowTower {

    private static Material[][][] mk1 = new Material[][][]{
            { // x = 0
                    {Material.OAK_LOG, null, Material.OAK_LOG}, // y = 0
                    {Material.OAK_LOG, null, Material.OAK_LOG}, // y = 1
                    {Material.OAK_PLANKS, Material.OAK_PLANKS, Material.OAK_PLANKS},  // y = 2
                    {Material.OAK_FENCE, Material.OAK_FENCE, Material.OAK_FENCE}, // y = 3
                    {null, null, null} // y = 4
            },
            { // x = 1
                    {null, null, null}, // y = 0
                    {null, null, null}, // y = 1
                    {Material.OAK_PLANKS, Material.DIRT, Material.OAK_PLANKS},  // y = 2
                    {Material.OAK_FENCE, null, Material.OAK_FENCE}, // y = 3
                    {null, Material.FLETCHING_TABLE, null} // y = 4
            },
            { // x = 2
                    {Material.OAK_LOG, null, Material.OAK_LOG}, // y = 0
                    {Material.OAK_LOG, null, Material.OAK_LOG}, // y = 1
                    {Material.OAK_PLANKS, Material.OAK_PLANKS, Material.OAK_PLANKS},  // y = 2
                    {Material.OAK_FENCE, Material.OAK_FENCE, Material.OAK_FENCE}, // y = 3
                    {null, null, null} // y = 4
            }
    };

    private static Material[][][] mk2 = new Material[][][]{
            { // x = 0
                    {Material.STONE_BRICK_WALL, null, Material.STONE_BRICK_WALL}, // y = 0
                    {Material.STONE_BRICK_WALL, null, Material.STONE_BRICK_WALL}, // y = 1
                    {Material.STONE_BRICKS, Material.STONE_BRICKS, Material.STONE_BRICKS},  // y = 2
                    {Material.COBBLESTONE_WALL, Material.COBBLESTONE_WALL, Material.COBBLESTONE_WALL}, // y = 3
                    {null, null, null} // y = 4
            },
            { // x = 1
                    {null, null, null}, // y = 0
                    {null, null, null}, // y = 1
                    {Material.STONE_BRICKS, Material.STONE, Material.STONE_BRICKS},  // y = 2
                    {Material.COBBLESTONE_WALL, Material.COBBLESTONE_WALL, Material.COBBLESTONE_WALL}, // y = 3
                    {null, Material.FLETCHING_TABLE, null} // y = 4
            },
            { // x = 2
                    {Material.STONE_BRICK_WALL, null, Material.STONE_BRICK_WALL}, // y = 0
                    {Material.STONE_BRICK_WALL, null, Material.STONE_BRICK_WALL}, // y = 1
                    {Material.STONE_BRICKS, Material.STONE_BRICKS, Material.STONE_BRICKS},  // y = 2
                    {Material.COBBLESTONE_WALL, Material.COBBLESTONE_WALL, Material.COBBLESTONE_WALL}, // y = 3
                    {null, null, null} // y = 4
            }
    };

    private static Material[][][] mk3 = new Material[][][]{
            { // x = 0
                    {Material.CHAIN, null, Material.CHAIN}, // y = 0
                    {Material.CHAIN, null, Material.CHAIN}, // y = 1
                    {Material.SMOOTH_STONE, Material.SMOOTH_STONE, Material.SMOOTH_STONE},  // y = 2
                    {Material.IRON_BARS, Material.IRON_BARS, Material.IRON_BARS}, // y = 3
                    {null, null, null} // y = 4
            },
            { // x = 1
                    {null, null, null}, // y = 0
                    {null, null, null}, // y = 1
                    {Material.SMOOTH_STONE, Material.IRON_BLOCK, Material.SMOOTH_STONE},  // y = 2
                    {Material.IRON_BARS, Material.IRON_BARS, Material.IRON_BARS}, // y = 3
                    {null, Material.FLETCHING_TABLE, null} // y = 4
            },
            { // x = 2
                    {Material.CHAIN, null, Material.CHAIN}, // y = 0
                    {Material.CHAIN, null, Material.CHAIN}, // y = 1
                    {Material.SMOOTH_STONE, Material.SMOOTH_STONE, Material.SMOOTH_STONE},  // y = 2
                    {Material.IRON_BARS, Material.IRON_BARS, Material.IRON_BARS}, // y = 3z
                    {null, null, null} // y = 4
            }
    };

    private static Material[][][] mk4 = new Material[][][]{
            { // x = 0
                    {Material.NETHER_BRICK_FENCE, null, Material.NETHER_BRICK_FENCE}, // y = 0
                    {Material.NETHER_BRICK_FENCE, null, Material.NETHER_BRICK_FENCE}, // y =
                    {Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE},  // y = 2
                    {Material.NETHER_BRICK_FENCE, Material.NETHER_BRICK_FENCE, Material.NETHER_BRICK_FENCE}, // y = 3
                    {null, null, null} // y = 4
            },
            { // x = 1
                    {null, null, null}, // y = 0
                    {null, null, null}, // y = 1
                    {Material.GILDED_BLACKSTONE, Material.GOLD_BLOCK, Material.GILDED_BLACKSTONE},  // y = 2
                    {Material.NETHER_BRICK_FENCE, Material.NETHER_BRICK_FENCE, Material.NETHER_BRICK_FENCE}, // y = 3
                    {null, Material.FLETCHING_TABLE, null} // y = 4
            },
            { // x = 2
                    {Material.NETHER_BRICK_FENCE, null, Material.NETHER_BRICK_FENCE}, // y = 0
                    {Material.NETHER_BRICK_FENCE, null, Material.NETHER_BRICK_FENCE}, // y = 1
                    {Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE},  // y = 2
                    {Material.NETHER_BRICK_FENCE, Material.NETHER_BRICK_FENCE, Material.NETHER_BRICK_FENCE}, // y = 3
                    {null, null, null} // y = 4
            }
    };
}
