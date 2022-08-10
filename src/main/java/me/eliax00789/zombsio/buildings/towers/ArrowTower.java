package me.eliax00789.zombsio.buildings.towers;

import org.bukkit.Material;

public class ArrowTower {

    public static Material[][][] mk1 = new Material[][][]{
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

    public static Material[][][] mk2 = new Material[][][]{
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
                    {Material.COBBLESTONE_WALL, null, Material.COBBLESTONE_WALL}, // y = 3
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

    public static Material[][][] mk3 = new Material[][][]{
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
                    {Material.IRON_BARS, null, Material.IRON_BARS}, // y = 3
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

    public static Material[][][] mk4 = new Material[][][]{
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
                    {Material.NETHER_BRICK_FENCE, null, Material.NETHER_BRICK_FENCE}, // y = 3
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

    public static Material[][][] mk5 = new Material[][][]{
            { // x = 0
                    {Material.POLISHED_BLACKSTONE_WALL, null, Material.POLISHED_BLACKSTONE_WALL}, // y = 0
                    {Material.POLISHED_BLACKSTONE_WALL, null, Material.POLISHED_BLACKSTONE_WALL}, // y =
                    {Material.SCULK, Material.SCULK, Material.SCULK},  // y = 2
                    {Material.POLISHED_BLACKSTONE_WALL, Material.POLISHED_BLACKSTONE_WALL, Material.POLISHED_BLACKSTONE_WALL}, // y = 3
                    {null, null, null} // y = 4
            },
            { // x = 1
                    {null, null, null}, // y = 0
                    {null, null, null}, // y = 1
                    {Material.SCULK, Material.OBSIDIAN, Material.SCULK},  // y = 2
                    {Material.POLISHED_BLACKSTONE_WALL, null, Material.POLISHED_BLACKSTONE_WALL}, // y = 3
                    {null, Material.FLETCHING_TABLE, null} // y = 4
            },
            { // x = 2
                    {Material.POLISHED_BLACKSTONE_WALL, null, Material.POLISHED_BLACKSTONE_WALL}, // y = 0
                    {Material.POLISHED_BLACKSTONE_WALL, null, Material.POLISHED_BLACKSTONE_WALL}, // y = 1
                    {Material.SCULK, Material.SCULK, Material.SCULK},  // y = 2
                    {Material.POLISHED_BLACKSTONE_WALL, Material.POLISHED_BLACKSTONE_WALL, Material.POLISHED_BLACKSTONE_WALL}, // y = 3
                    {null, null, null} // y = 4
            }
    };

    public static Material[][][] mk6 = new Material[][][]{
            { // x = 0
                    {Material.WARPED_FENCE, null, Material.WARPED_FENCE}, // y = 0
                    {Material.WARPED_FENCE, null, Material.WARPED_FENCE}, // y =
                    {Material.GREEN_CONCRETE, Material.GREEN_CONCRETE, Material.GREEN_CONCRETE},  // y = 2
                    {Material.WARPED_FENCE, Material.WARPED_FENCE, Material.WARPED_FENCE}, // y = 3
                    {null, null, null} // y = 4
            },
            { // x = 1
                    {null, null, null}, // y = 0
                    {null, null, null}, // y = 1
                    {Material.GREEN_CONCRETE, Material.EMERALD_BLOCK, Material.GREEN_CONCRETE},  // y = 2
                    {Material.WARPED_FENCE, null, Material.WARPED_FENCE}, // y = 3
                    {null, Material.FLETCHING_TABLE, null} // y = 4
            },
            { // x = 2
                    {Material.WARPED_FENCE, null, Material.WARPED_FENCE}, // y = 0
                    {Material.WARPED_FENCE, null, Material.WARPED_FENCE}, // y = 1
                    {Material.GREEN_CONCRETE, Material.GREEN_CONCRETE, Material.GREEN_CONCRETE},  // y = 2
                    {Material.WARPED_FENCE, Material.WARPED_FENCE, Material.WARPED_FENCE}, // y = 3
                    {null, null, null} // y = 4
            }
    };

    public static Material[][][] mk7 = new Material[][][]{
            { // x =
                    {Material.PRISMARINE_WALL, null, Material.PRISMARINE_WALL}, // y = 0
                    {Material.PRISMARINE_WALL, null, Material.PRISMARINE_WALL}, // y =
                    {Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER},  // y = 2
                    {Material.PRISMARINE_WALL, Material.PRISMARINE_WALL, Material.PRISMARINE_WALL}, // y = 3
                    {null, null, null} // y = 4
            },
            { // x = 1
                    {null, null, null}, // y = 0
                    {null, null, null}, // y = 1
                    {Material.WAXED_OXIDIZED_COPPER, Material.DIAMOND_BLOCK, Material.WAXED_OXIDIZED_COPPER},  // y = 2
                    {Material.PRISMARINE_WALL, null, Material.PRISMARINE_WALL}, // y = 3
                    {null, Material.FLETCHING_TABLE, null} // y = 4
            },
            { // x = 2
                    {Material.PRISMARINE_WALL, null, Material.PRISMARINE_WALL}, // y = 0
                    {Material.PRISMARINE_WALL, null, Material.PRISMARINE_WALL}, // y = 1
                    {Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER},  // y = 2
                    {Material.PRISMARINE_WALL, Material.PRISMARINE_WALL, Material.PRISMARINE_WALL}, // y = 3
                    {null, null, null} // y = 4
            }
    };

    public static Material[][][] mk8 = new Material[][][]{
            { // x = 0
                    {Material.POLISHED_DEEPSLATE_WALL, null, Material.POLISHED_DEEPSLATE_WALL}, // y = 0
                    {Material.POLISHED_DEEPSLATE_WALL, null, Material.POLISHED_DEEPSLATE_WALL}, // y =
                    {Material.DEEPSLATE, Material.DEEPSLATE, Material.DEEPSLATE},  // y = 2
                    {Material.POLISHED_DEEPSLATE_WALL, Material.POLISHED_DEEPSLATE_WALL, Material.POLISHED_DEEPSLATE_WALL}, // y = 3
                    {null, null, null} // y = 4
            },
            { // x = 1
                    {null, null, null}, // y = 0
                    {null, null, null}, // y = 1
                    {Material.DEEPSLATE, Material.NETHERITE_BLOCK, Material.DEEPSLATE},  // y = 2
                    {Material.POLISHED_DEEPSLATE_WALL, null, Material.POLISHED_DEEPSLATE_WALL}, // y = 3
                    {null, Material.FLETCHING_TABLE, null} // y = 4
            },
            { // x = 2
                    {Material.POLISHED_DEEPSLATE_WALL, null, Material.POLISHED_DEEPSLATE_WALL}, // y = 0
                    {Material.POLISHED_DEEPSLATE_WALL, null, Material.POLISHED_DEEPSLATE_WALL}, // y = 1
                    {Material.DEEPSLATE, Material.DEEPSLATE, Material.DEEPSLATE},  // y = 2
                    {Material.POLISHED_DEEPSLATE_WALL, Material.POLISHED_DEEPSLATE_WALL, Material.POLISHED_DEEPSLATE_WALL}, // y = 3
                    {null, null, null} // y = 4
            }
    };


}
