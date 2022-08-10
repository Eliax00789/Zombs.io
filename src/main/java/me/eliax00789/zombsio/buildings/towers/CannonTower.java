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
                    {Material.OAK_LOG, Material.OAK_LOG, Material.OAK_LOG}, // y = 3
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
}
