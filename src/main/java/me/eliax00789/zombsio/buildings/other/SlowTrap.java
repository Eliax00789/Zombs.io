package me.eliax00789.zombsio.buildings.other;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.Building;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SlowTrap extends Building {

    //TODO: NIFFLER SLOW TRAP INTO MK THINGS

    public static Material[][][] mk1 = new Material[][][] {
            { // x = 0
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.DIRT, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk2 = new Material[][][] {
            { // x = 0
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.STONE, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk3 = new Material[][][] {
            { // x = 0
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.IRON_BLOCK, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk4 = new Material[][][] {
            { // x = 0
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.GOLD_BLOCK, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk5 = new Material[][][] {
            { // x = 0
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.OBSIDIAN, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk6 = new Material[][][] {
            { // x = 0
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.EMERALD_BLOCK, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk7 = new Material[][][] {
            { // x = 0
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.DIAMOND_BLOCK, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };

    public static Material[][][] mk8 = new Material[][][] {
            { // x = 0
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            },
            { // x = 1
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.NETHERITE_BLOCK, Material.AIR} // y = 4
            },
            { // x = 2
                    {Material.HONEY_BLOCK, Material.HONEY_BLOCK, Material.HONEY_BLOCK}, // y = 0
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 1
                    {Material.AIR, Material.AIR, Material.AIR},  // y = 2
                    {Material.AIR, Material.AIR, Material.AIR}, // y = 3
                    {Material.AIR, Material.AIR, Material.AIR} // y = 4
            }
    };


    public SlowTrap(Player player, Location location) {
        super(player,"SlowTrap",1,8,location,
                null,null,null,
                new Material[][][][]{mk1,mk2,mk3,mk4,mk5,mk6,mk7,mk8},
                Zombsio.plugin.getConfig().getIntegerList("Buildings.SlowTrap.Health"),
                null,
                null,
                Zombsio.plugin.getConfig().getIntegerList("Buildings.SlowTrap.Wood"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.SlowTrap.Stone"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.SlowTrap.Gold"));
    }

}
