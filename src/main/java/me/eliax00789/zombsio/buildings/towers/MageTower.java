package me.eliax00789.zombsio.buildings.towers;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.Building;
import org.bukkit.Location;
import org.bukkit.Material;

public class MageTower extends Building {

    public static Material[][][] mk1 = new Material[][][]{
            { // x = 0
                    {Material.OAK_LOG, Material.AIR, Material.OAK_LOG}, // y = 0
                    {Material.OAK_LOG, Material.AIR, Material.OAK_LOG}, // y = 1
                    {Material.OAK_PLANKS, Material.OAK_PLANKS, Material.OAK_PLANKS},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.OAK_PLANKS, Material.DIRT, Material.OAK_PLANKS},  // y = 2
                    {Material.AIR, Material.END_PORTAL_FRAME, Material.AIR}, // y = 3
                    {Material.AIR, Material.AMETHYST_BLOCK, Material.AIR}, // y = 4
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE} // y = 5
            },
            { // x = 2
                    {Material.OAK_LOG, Material.AIR, Material.OAK_LOG}, // y = 0
                    {Material.OAK_LOG, Material.AIR, Material.OAK_LOG}, // y = 1
                    {Material.OAK_PLANKS, Material.OAK_PLANKS, Material.OAK_PLANKS},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            }
    };

    public static Material[][][] mk2 = new Material[][][]{
            { // x = 0
                    {Material.STONE_BRICK_WALL, Material.AIR, Material.STONE_BRICK_WALL}, // y = 0
                    {Material.STONE_BRICK_WALL, Material.AIR, Material.STONE_BRICK_WALL}, // y = 1
                    {Material.STONE_BRICKS, Material.STONE_BRICKS, Material.STONE_BRICKS},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.STONE_BRICKS, Material.STONE, Material.STONE_BRICKS},  // y = 2
                    {Material.AIR, Material.END_PORTAL_FRAME, Material.AIR}, // y = 3
                    {Material.AIR, Material.AMETHYST_BLOCK, Material.AIR}, // y = 4
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE} // y = 5
            },
            { // x = 2
                    {Material.STONE_BRICK_WALL, Material.AIR, Material.STONE_BRICK_WALL}, // y = 0
                    {Material.STONE_BRICK_WALL, Material.AIR, Material.STONE_BRICK_WALL}, // y = 1
                    {Material.STONE_BRICKS, Material.STONE_BRICKS, Material.STONE_BRICKS},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            }
    };

    public static Material[][][] mk3 = new Material[][][]{
            { // x = 0
                    {Material.CHAIN, Material.AIR, Material.CHAIN}, // y = 0
                    {Material.CHAIN, Material.AIR, Material.CHAIN}, // y = 1
                    {Material.SMOOTH_STONE, Material.SMOOTH_STONE, Material.SMOOTH_STONE},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.SMOOTH_STONE, Material.IRON_BLOCK, Material.SMOOTH_STONE},  // y = 2
                    {Material.AIR, Material.END_PORTAL_FRAME, Material.AIR}, // y = 3
                    {Material.AIR, Material.AMETHYST_BLOCK, Material.AIR}, // y = 4
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE} // y = 5
            },
            { // x = 2
                    {Material.CHAIN, Material.AIR, Material.CHAIN}, // y = 0
                    {Material.CHAIN, Material.AIR, Material.CHAIN}, // y = 1
                    {Material.SMOOTH_STONE, Material.SMOOTH_STONE, Material.SMOOTH_STONE},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            }
    };

    public static Material[][][] mk4 = new Material[][][]{
            { // x = 0
                    {Material.NETHER_BRICK_FENCE, Material.AIR, Material.NETHER_BRICK_FENCE}, // y = 0
                    {Material.NETHER_BRICK_FENCE, Material.AIR, Material.NETHER_BRICK_FENCE}, // y =
                    {Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.GILDED_BLACKSTONE, Material.GOLD_BLOCK, Material.GILDED_BLACKSTONE},  // y = 2
                    {Material.AIR, Material.END_PORTAL_FRAME, Material.AIR}, // y = 3
                    {Material.AIR, Material.AMETHYST_BLOCK, Material.AIR}, // y = 4
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE} // y = 5
            },
            { // x = 2
                    {Material.NETHER_BRICK_FENCE, Material.AIR, Material.NETHER_BRICK_FENCE}, // y = 0
                    {Material.NETHER_BRICK_FENCE, Material.AIR, Material.NETHER_BRICK_FENCE}, // y = 1
                    {Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            }
    };

    public static Material[][][] mk5 = new Material[][][]{
            { // x = 0
                    {Material.POLISHED_BLACKSTONE_WALL, Material.AIR, Material.POLISHED_BLACKSTONE_WALL}, // y = 0
                    {Material.POLISHED_BLACKSTONE_WALL, Material.AIR, Material.POLISHED_BLACKSTONE_WALL}, // y =
                    {Material.SCULK, Material.SCULK, Material.SCULK},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.SCULK, Material.OBSIDIAN, Material.SCULK},  // y = 2
                    {Material.AIR, Material.END_PORTAL_FRAME, Material.AIR}, // y = 3
                    {Material.AIR, Material.AMETHYST_BLOCK, Material.AIR}, // y = 4
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE} // y = 5
            },
            { // x = 2
                    {Material.POLISHED_BLACKSTONE_WALL, Material.AIR, Material.POLISHED_BLACKSTONE_WALL}, // y = 0
                    {Material.POLISHED_BLACKSTONE_WALL, Material.AIR, Material.POLISHED_BLACKSTONE_WALL}, // y = 1
                    {Material.SCULK, Material.SCULK, Material.SCULK},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            }
    };

    public static Material[][][] mk6 = new Material[][][]{
            { // x = 0
                    {Material.WARPED_FENCE, Material.AIR, Material.WARPED_FENCE}, // y = 0
                    {Material.WARPED_FENCE, Material.AIR, Material.WARPED_FENCE}, // y =
                    {Material.GREEN_CONCRETE, Material.GREEN_CONCRETE, Material.GREEN_CONCRETE},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.GREEN_CONCRETE, Material.EMERALD_BLOCK, Material.GREEN_CONCRETE},  // y = 2
                    {Material.AIR, Material.END_PORTAL_FRAME, Material.AIR}, // y = 3
                    {Material.AIR, Material.AMETHYST_BLOCK, Material.AIR}, // y = 4
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE} // y = 5
            },
            { // x = 2
                    {Material.WARPED_FENCE, Material.AIR, Material.WARPED_FENCE}, // y = 0
                    {Material.WARPED_FENCE, Material.AIR, Material.WARPED_FENCE}, // y = 1
                    {Material.GREEN_CONCRETE, Material.GREEN_CONCRETE, Material.GREEN_CONCRETE},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            }
    };

    public static Material[][][] mk7 = new Material[][][]{
            { // x =
                    {Material.PRISMARINE_WALL, Material.AIR, Material.PRISMARINE_WALL}, // y = 0
                    {Material.PRISMARINE_WALL, Material.AIR, Material.PRISMARINE_WALL}, // y =
                    {Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.WAXED_OXIDIZED_COPPER, Material.DIAMOND_BLOCK, Material.WAXED_OXIDIZED_COPPER},  // y = 2
                    {Material.AIR, Material.END_PORTAL_FRAME, Material.AIR}, // y = 3
                    {Material.AIR, Material.AMETHYST_BLOCK, Material.AIR}, // y = 4
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE} // y = 5
            },
            { // x = 2
                    {Material.PRISMARINE_WALL, Material.AIR, Material.PRISMARINE_WALL}, // y = 0
                    {Material.PRISMARINE_WALL, Material.AIR, Material.PRISMARINE_WALL}, // y = 1
                    {Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            }
    };

    public static Material[][][] mk8 = new Material[][][]{
            { // x = 0
                    {Material.POLISHED_DEEPSLATE_WALL, Material.AIR, Material.POLISHED_DEEPSLATE_WALL}, // y = 0
                    {Material.POLISHED_DEEPSLATE_WALL, Material.AIR, Material.POLISHED_DEEPSLATE_WALL}, // y =
                    {Material.DEEPSLATE, Material.DEEPSLATE, Material.DEEPSLATE},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            },
            { // x = 1
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.DEEPSLATE, Material.NETHERITE_BLOCK, Material.DEEPSLATE},  // y = 2
                    {Material.AIR, Material.END_PORTAL_FRAME, Material.AIR}, // y = 3
                    {Material.AIR, Material.AMETHYST_BLOCK, Material.AIR}, // y = 4
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.PURPLE_STAINED_GLASS_PANE} // y = 5
            },
            { // x = 2
                    {Material.POLISHED_DEEPSLATE_WALL, Material.AIR, Material.POLISHED_DEEPSLATE_WALL}, // y = 0
                    {Material.POLISHED_DEEPSLATE_WALL, Material.AIR, Material.POLISHED_DEEPSLATE_WALL}, // y = 1
                    {Material.DEEPSLATE, Material.DEEPSLATE, Material.DEEPSLATE},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.PURPLE_STAINED_GLASS_PANE, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 5
            }
    };

    public MageTower(Location location) {
        super("MageTower",1,8,location,
                null, null, null,
                new Material[][][][]{mk1,mk2,mk3,mk4,mk5,mk6,mk7,mk8},
                Zombsio.plugin.getConfig().getIntegerList("Buildings.MageTower.Health"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.MageTower.Damage"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.MageTower.Range"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.MageTower.Wood"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.MageTower.Stone"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.MageTower.Gold"));
    }
}
