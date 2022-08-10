package me.eliax00789.zombsio.buildings.towers;

import org.bukkit.Material;

public class CannonTower {

    public static Material[][][] mk1 = new Material[][][]{
            { // x = 0
                    {Material.OAK_LOG, Material.AIR, Material.OAK_LOG}, // y = 0
                    {Material.OAK_PLANKS, Material.OAK_PLANKS, Material.OAK_PLANKS}, // y =
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.OAK_PLANKS, Material.DIRT, Material.OAK_PLANKS}, // y = 1
                    {Material.OAK_SLAB, Material.OAK_SLAB, Material.OAK_SLAB},  // y = 2
                    {Material.DIRT, Material.DIRT, Material.DIRT}, // y = 3
                    {Material.OAK_SLAB, Material.OAK_SLAB, Material.OAK_SLAB} // y = 4
            },
            { // x = 2
                    {Material.OAK_LOG, Material.AIR, Material.OAK_LOG}, // y = 0
                    {Material.OAK_PLANKS, Material.OAK_PLANKS, Material.OAK_PLANKS}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk2 = new Material[][][]{
            { // x = 0
                    {Material.STONE_BRICK_WALL, Material.AIR, Material.STONE_BRICK_WALL}, // y = 0
                    {Material.STONE_BRICKS, Material.STONE_BRICKS, Material.STONE_BRICKS}, // y =
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.STONE_BRICKS, Material.STONE, Material.STONE_BRICKS}, // y = 1
                    {Material.STONE_SLAB, Material.STONE_SLAB, Material.STONE_SLAB},  // y = 2
                    {Material.STONE, Material.STONE, Material.STONE}, // y = 3
                    {Material.STONE_SLAB, Material.STONE_SLAB, Material.STONE_SLAB} // y = 4
            },
            { // x = 2
                    {Material.STONE_BRICK_WALL, Material.AIR, Material.STONE_BRICK_WALL}, // y = 0
                    {Material.STONE_BRICKS, Material.STONE_BRICKS, Material.STONE_BRICKS}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk3 = new Material[][][]{
            { // x = 0
                    {Material.CHAIN, Material.AIR, Material.CHAIN}, // y = 0
                    {Material.SMOOTH_STONE, Material.SMOOTH_STONE, Material.SMOOTH_STONE}, // y =
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.SMOOTH_STONE, Material.IRON_BLOCK, Material.SMOOTH_STONE}, // y = 1
                    {Material.SMOOTH_STONE_SLAB, Material.SMOOTH_STONE_SLAB, Material.SMOOTH_STONE_SLAB},  // y = 2
                    {Material.IRON_BLOCK, Material.IRON_BLOCK, Material.IRON_BLOCK}, // y = 3
                    {Material.SMOOTH_STONE_SLAB, Material.SMOOTH_STONE_SLAB, Material.SMOOTH_STONE_SLAB} // y = 4
            },
            { // x = 2
                    {Material.CHAIN, Material.AIR, Material.CHAIN}, // y = 0
                    {Material.SMOOTH_STONE, Material.SMOOTH_STONE, Material.SMOOTH_STONE}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk4 = new Material[][][]{
            { // x = 0
                    {Material.NETHER_BRICK_FENCE, Material.AIR, Material.NETHER_BRICK_FENCE}, // y = 0
                    {Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE}, // y =
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.GILDED_BLACKSTONE, Material.GOLD_BLOCK, Material.GILDED_BLACKSTONE}, // y = 1
                    {Material.NETHER_BRICK_SLAB, Material.NETHER_BRICK_SLAB, Material.NETHER_BRICK_SLAB},  // y = 2
                    {Material.GOLD_BLOCK, Material.GOLD_BLOCK, Material.GOLD_BLOCK}, // y = 3
                    {Material.NETHER_BRICK_SLAB, Material.NETHER_BRICK_SLAB, Material.NETHER_BRICK_SLAB} // y = 4
            },
            { // x = 2
                    {Material.NETHER_BRICK_FENCE, Material.AIR, Material.NETHER_BRICK_FENCE}, // y = 0
                    {Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk5 = new Material[][][]{
            { // x = 0
                    {Material.POLISHED_BLACKSTONE_WALL, Material.AIR, Material.POLISHED_BLACKSTONE_WALL}, // y = 0
                    {Material.SCULK, Material.SCULK, Material.SCULK}, // y =
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.SCULK, Material.OBSIDIAN, Material.SCULK}, // y = 1
                    {Material.POLISHED_BLACKSTONE_SLAB, Material.POLISHED_BLACKSTONE_SLAB, Material.POLISHED_BLACKSTONE_SLAB},  // y = 2
                    {Material.OBSIDIAN, Material.OBSIDIAN, Material.OBSIDIAN}, // y = 3
                    {Material.POLISHED_BLACKSTONE_SLAB, Material.POLISHED_BLACKSTONE_SLAB, Material.POLISHED_BLACKSTONE_SLAB} // y = 4
            },
            { // x = 2
                    {Material.POLISHED_BLACKSTONE_WALL, Material.AIR, Material.POLISHED_BLACKSTONE_WALL}, // y = 0
                    {Material.SCULK, Material.SCULK, Material.SCULK}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk6 = new Material[][][]{
            { // x = 0
                    {Material.WARPED_FENCE, Material.AIR, Material.WARPED_FENCE}, // y = 0
                    {Material.GREEN_CONCRETE, Material.GREEN_CONCRETE, Material.GREEN_CONCRETE}, // y =
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.GREEN_CONCRETE, Material.EMERALD_BLOCK, Material.GREEN_CONCRETE}, // y = 1
                    {Material.WARPED_SLAB, Material.WARPED_SLAB, Material.WARPED_SLAB},  // y = 2
                    {Material.EMERALD_BLOCK, Material.EMERALD_BLOCK, Material.EMERALD_BLOCK}, // y = 3
                    {Material.WARPED_SLAB, Material.WARPED_SLAB, Material.WARPED_SLAB} // y = 4
            },
            { // x = 2
                    {Material.WARPED_FENCE, Material.AIR, Material.WARPED_FENCE}, // y = 0
                    {Material.GREEN_CONCRETE, Material.GREEN_CONCRETE, Material.GREEN_CONCRETE}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk7 = new Material[][][]{
            { // x = 0
                    {Material.PRISMARINE_WALL, Material.AIR, Material.PRISMARINE_WALL}, // y = 0
                    {Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER}, // y =
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.WAXED_OXIDIZED_COPPER, Material.DIAMOND_BLOCK, Material.WAXED_OXIDIZED_COPPER}, // y = 1
                    {Material.PRISMARINE_SLAB, Material.PRISMARINE_SLAB, Material.PRISMARINE_SLAB},  // y = 2
                    {Material.DIAMOND_BLOCK, Material.DIAMOND_BLOCK, Material.DIAMOND_BLOCK}, // y = 3
                    {Material.PRISMARINE_SLAB, Material.PRISMARINE_SLAB, Material.PRISMARINE_SLAB} // y = 4
            },
            { // x = 2
                    {Material.PRISMARINE_WALL, Material.AIR, Material.PRISMARINE_WALL}, // y = 0
                    {Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk8 = new Material[][][]{
            { // x = 0
                    {Material.POLISHED_DEEPSLATE_WALL, Material.AIR, Material.POLISHED_DEEPSLATE_WALL}, // y = 0
                    {Material.DEEPSLATE, Material.DEEPSLATE, Material.DEEPSLATE}, // y =
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.DEEPSLATE, Material.DIAMOND_BLOCK, Material.DEEPSLATE}, // y = 1
                    {Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_SLAB},  // y = 2
                    {Material.DIAMOND_BLOCK, Material.DIAMOND_BLOCK, Material.DIAMOND_BLOCK}, // y = 3
                    {Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_SLAB, Material.POLISHED_DEEPSLATE_SLAB} // y = 4
            },
            { // x = 2
                    {Material.POLISHED_DEEPSLATE_WALL, Material.AIR, Material.POLISHED_DEEPSLATE_WALL}, // y = 0
                    {Material.DEEPSLATE, Material.DEEPSLATE, Material.DEEPSLATE}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR, Material.IRON_TRAPDOOR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };
}
