package me.eliax00789.zombsio.buildings.other;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.Building;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SlowTrap extends Building {

    //TODO: NIFFLER SLOW TRAP INTO MK THINGS

    public SlowTrap(Player player, Location location) {
        super(player,"Wall",1,8,location,
                null,null,null,
                new Material[][][][]{null,null,null,null,null,null,null,null},
                Zombsio.plugin.getConfig().getIntegerList("Buildings.Wall.Health"),
                null,
                null,
                Zombsio.plugin.getConfig().getIntegerList("Buildings.Wall.Wood"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.Wall.Stone"),
                Zombsio.plugin.getConfig().getIntegerList("Buildings.Wall.Gold"));
    }

}
