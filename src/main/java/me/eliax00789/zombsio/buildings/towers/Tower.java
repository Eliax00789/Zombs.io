package me.eliax00789.zombsio.buildings.towers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class Tower {

    public void build(Location location, Material[][][] material) {

        location.getBlock().setType(material[0][0][0]);
    }
}
