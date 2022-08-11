package me.eliax00789.zombsio.buildings.resources;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.Building;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GoldMine extends Building {

    public static Material[][][] mk1 = new Material[][][] {
            { // x = 0
                    {Material.OAK_LOG, Material.AIR, Material.OAK_LOG}, // y = 0
                    {Material.OAK_LOG, Material.END_ROD, Material.OAK_LOG}, // y = 1
                    {Material.OAK_LOG, Material.HOPPER, Material.OAK_LOG},  // y = 2
                    {Material.OAK_PLANKS, Material.OAK_PLANKS, Material.OAK_PLANKS}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.END_ROD, Material.AIR}, // y = 0
                    {Material.END_ROD, Material.HOPPER, Material.END_ROD}, // y = 1
                    {Material.HOPPER, Material.DIRT, Material.HOPPER},  // y = 2
                    {Material.OAK_PLANKS, Material.OAK_PLANKS, Material.OAK_PLANKS}, // y = 3
                    {Material.AIR, Material.COBBLESTONE_WALL, Material.AIR}, // y = 4
                    {Material.AIR, Material.IRON_BARS, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.OAK_LOG, Material.AIR, Material.OAK_LOG}, // y = 0
                    {Material.OAK_LOG, Material.END_ROD, Material.OAK_LOG}, // y = 1
                    {Material.OAK_LOG, Material.HOPPER, Material.OAK_LOG},  // y = 2
                    {Material.OAK_PLANKS, Material.OAK_PLANKS, Material.OAK_PLANKS}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk2 = new Material[][][]{
            { // x = 0
                    {Material.STONE_BRICK_WALL, Material.AIR, Material.STONE_BRICK_WALL}, // y = 0
                    {Material.STONE_BRICK_WALL, Material.END_ROD, Material.STONE_BRICK_WALL}, // y = 1
                    {Material.STONE_BRICK_WALL, Material.HOPPER, Material.STONE_BRICK_WALL},  // y = 2
                    {Material.STONE_BRICKS, Material.STONE_BRICKS, Material.STONE_BRICKS}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.END_ROD, Material.AIR}, // y = 0
                    {Material.END_ROD, Material.HOPPER, Material.END_ROD}, // y = 1
                    {Material.HOPPER, Material.STONE, Material.HOPPER},  // y = 2
                    {Material.STONE_BRICKS, Material.STONE_BRICKS, Material.STONE_BRICKS}, // y = 3
                    {Material.AIR, Material.COBBLESTONE_WALL, Material.AIR}, // y = 4
                    {Material.AIR, Material.IRON_BARS, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.STONE_BRICK_WALL, Material.AIR, Material.STONE_BRICK_WALL}, // y = 0
                    {Material.STONE_BRICK_WALL, Material.END_ROD, Material.STONE_BRICK_WALL}, // y = 1
                    {Material.STONE_BRICK_WALL, Material.HOPPER, Material.STONE_BRICK_WALL},  // y = 2
                    {Material.STONE_BRICKS, Material.STONE_BRICKS, Material.STONE_BRICKS}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk3 = new Material[][][]{
            { // x = 0
                    {Material.CHAIN, Material.AIR, Material.CHAIN}, // y = 0
                    {Material.CHAIN, Material.END_ROD, Material.CHAIN}, // y = 1
                    {Material.CHAIN, Material.HOPPER, Material.CHAIN},  // y = 2
                    {Material.SMOOTH_STONE, Material.SMOOTH_STONE, Material.SMOOTH_STONE}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.END_ROD, Material.AIR}, // y = 0
                    {Material.END_ROD, Material.HOPPER, Material.END_ROD}, // y = 1
                    {Material.HOPPER, Material.IRON_BLOCK, Material.HOPPER},  // y = 2
                    {Material.SMOOTH_STONE, Material.SMOOTH_STONE, Material.SMOOTH_STONE}, // y = 3
                    {Material.AIR, Material.COBBLESTONE_WALL, Material.AIR}, // y = 4
                    {Material.AIR, Material.IRON_BARS, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.CHAIN, Material.AIR, Material.CHAIN}, // y = 0
                    {Material.CHAIN, Material.END_ROD, Material.CHAIN}, // y = 1
                    {Material.CHAIN, Material.HOPPER, Material.CHAIN},  // y = 2
                    {Material.SMOOTH_STONE, Material.SMOOTH_STONE, Material.SMOOTH_STONE}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk4 = new Material[][][]{
            { // x = 0
                    {Material.NETHER_BRICK_FENCE, Material.AIR, Material.NETHER_BRICK_FENCE}, // y = 0
                    {Material.NETHER_BRICK_FENCE, Material.END_ROD, Material.NETHER_BRICK_FENCE}, // y = 1
                    {Material.NETHER_BRICK_FENCE, Material.HOPPER, Material.NETHER_BRICK_FENCE},  // y = 2
                    {Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.END_ROD, Material.AIR}, // y = 0
                    {Material.END_ROD, Material.HOPPER, Material.END_ROD}, // y = 1
                    {Material.HOPPER, Material.GOLD_BLOCK, Material.HOPPER},  // y = 2
                    {Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE}, // y = 3
                    {Material.AIR, Material.COBBLESTONE_WALL, Material.AIR}, // y = 4
                    {Material.AIR, Material.IRON_BARS, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.NETHER_BRICK_FENCE, Material.AIR, Material.NETHER_BRICK_FENCE}, // y = 0
                    {Material.NETHER_BRICK_FENCE, Material.END_ROD, Material.NETHER_BRICK_FENCE}, // y = 1
                    {Material.NETHER_BRICK_FENCE, Material.HOPPER, Material.NETHER_BRICK_FENCE},  // y = 2
                    {Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE, Material.GILDED_BLACKSTONE}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk5 = new Material[][][]{
            { // x = 0
                    {Material.POLISHED_BLACKSTONE_WALL, Material.AIR, Material.POLISHED_BLACKSTONE_WALL}, // y = 0
                    {Material.POLISHED_BLACKSTONE_WALL, Material.END_ROD, Material.POLISHED_BLACKSTONE_WALL}, // y = 1
                    {Material.POLISHED_BLACKSTONE_WALL, Material.HOPPER, Material.POLISHED_BLACKSTONE_WALL},  // y = 2
                    {Material.SCULK, Material.SCULK, Material.SCULK}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.END_ROD, Material.AIR}, // y = 0
                    {Material.END_ROD, Material.HOPPER, Material.END_ROD}, // y = 1
                    {Material.HOPPER, Material.OBSIDIAN, Material.HOPPER},  // y = 2
                    {Material.SCULK, Material.SCULK, Material.SCULK}, // y = 3
                    {Material.AIR, Material.COBBLESTONE_WALL, Material.AIR}, // y = 4
                    {Material.AIR, Material.IRON_BARS, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.POLISHED_BLACKSTONE_WALL, Material.AIR, Material.POLISHED_BLACKSTONE_WALL}, // y = 0
                    {Material.POLISHED_BLACKSTONE_WALL, Material.END_ROD, Material.POLISHED_BLACKSTONE_WALL}, // y = 1
                    {Material.POLISHED_BLACKSTONE_WALL, Material.HOPPER, Material.POLISHED_BLACKSTONE_WALL},  // y = 2
                    {Material.SCULK, Material.SCULK, Material.SCULK}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk6 = new Material[][][]{
            { // x = 0
                    {Material.WARPED_FENCE, Material.AIR, Material.WARPED_FENCE}, // y = 0
                    {Material.WARPED_FENCE, Material.END_ROD, Material.WARPED_FENCE}, // y = 1
                    {Material.WARPED_FENCE, Material.HOPPER, Material.WARPED_FENCE},  // y = 2
                    {Material.GREEN_CONCRETE, Material.GREEN_CONCRETE, Material.GREEN_CONCRETE}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.END_ROD, Material.AIR}, // y = 0
                    {Material.END_ROD, Material.HOPPER, Material.END_ROD}, // y = 1
                    {Material.HOPPER, Material.EMERALD_BLOCK, Material.HOPPER},  // y = 2
                    {Material.GREEN_CONCRETE, Material.GREEN_CONCRETE, Material.GREEN_CONCRETE}, // y = 3
                    {Material.AIR, Material.COBBLESTONE_WALL, Material.AIR}, // y = 4
                    {Material.AIR, Material.IRON_BARS, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.WARPED_FENCE, Material.AIR, Material.WARPED_FENCE}, // y = 0
                    {Material.WARPED_FENCE, Material.END_ROD, Material.WARPED_FENCE}, // y = 1
                    {Material.WARPED_FENCE, Material.HOPPER, Material.WARPED_FENCE},  // y = 2
                    {Material.GREEN_CONCRETE, Material.GREEN_CONCRETE, Material.GREEN_CONCRETE}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk7 = new Material[][][]{
            { // x = 0
                    {Material.PRISMARINE_WALL, Material.AIR, Material.PRISMARINE_WALL}, // y = 0
                    {Material.PRISMARINE_WALL, Material.END_ROD, Material.PRISMARINE_WALL}, // y = 1
                    {Material.PRISMARINE_WALL, Material.HOPPER, Material.PRISMARINE_WALL},  // y = 2
                    {Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.END_ROD, Material.AIR}, // y = 0
                    {Material.END_ROD, Material.HOPPER, Material.END_ROD}, // y = 1
                    {Material.HOPPER, Material.DIAMOND_BLOCK, Material.HOPPER},  // y = 2
                    {Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER}, // y = 3
                    {Material.AIR, Material.COBBLESTONE_WALL, Material.AIR}, // y = 4
                    {Material.AIR, Material.IRON_BARS, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.PRISMARINE_WALL, Material.AIR, Material.PRISMARINE_WALL}, // y = 0
                    {Material.PRISMARINE_WALL, Material.END_ROD, Material.PRISMARINE_WALL}, // y = 1
                    {Material.PRISMARINE_WALL, Material.HOPPER, Material.PRISMARINE_WALL},  // y = 2
                    {Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER, Material.WAXED_OXIDIZED_COPPER}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk8 = new Material[][][]{
            { // x = 0
                    {Material.POLISHED_DEEPSLATE_WALL, Material.AIR, Material.POLISHED_DEEPSLATE_WALL}, // y = 0
                    {Material.POLISHED_DEEPSLATE_WALL, Material.END_ROD, Material.POLISHED_DEEPSLATE_WALL}, // y = 1
                    {Material.POLISHED_DEEPSLATE_WALL, Material.HOPPER, Material.POLISHED_DEEPSLATE_WALL},  // y = 2
                    {Material.DEEPSLATE, Material.DEEPSLATE, Material.DEEPSLATE}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.AIR, Material.END_ROD, Material.AIR}, // y = 0
                    {Material.END_ROD, Material.HOPPER, Material.END_ROD}, // y = 1
                    {Material.HOPPER, Material.NETHERITE_BLOCK, Material.HOPPER},  // y = 2
                    {Material.DEEPSLATE, Material.DEEPSLATE, Material.DEEPSLATE}, // y = 3
                    {Material.AIR, Material.COBBLESTONE_WALL, Material.AIR}, // y = 4
                    {Material.AIR, Material.IRON_BARS, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.POLISHED_DEEPSLATE_WALL, Material.AIR, Material.POLISHED_DEEPSLATE_WALL}, // y = 0
                    {Material.POLISHED_DEEPSLATE_WALL, Material.END_ROD, Material.POLISHED_DEEPSLATE_WALL}, // y = 1
                    {Material.POLISHED_DEEPSLATE_WALL, Material.HOPPER, Material.POLISHED_DEEPSLATE_WALL},  // y = 2
                    {Material.DEEPSLATE, Material.DEEPSLATE, Material.DEEPSLATE}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 4
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public GoldMine(Player player, Location location) {
        super(player,"GoldMine",1,8,location,
                null,null,null,
                new Material[][][][]{mk1,mk2,mk3,mk4,mk5,mk6,mk7,mk8},
                Zombsio.plugin.getConfig().getIntegerList("Buildings.GoldMine.Health"),
                null,
                null,
                Zombsio.plugin.getConfig().getIntegerList("Buildings.GoldMine.Wood"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.GoldMine.Stone"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.GoldMine.Gold"));
    }
}
