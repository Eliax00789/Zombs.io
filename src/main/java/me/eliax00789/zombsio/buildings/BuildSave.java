package me.eliax00789.zombsio.buildings;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.other.Door;
import me.eliax00789.zombsio.buildings.other.SlowTrap;
import me.eliax00789.zombsio.buildings.other.Wall;
import me.eliax00789.zombsio.buildings.resources.GoldMine;
import me.eliax00789.zombsio.buildings.resources.GoldStash;
import me.eliax00789.zombsio.buildings.resources.ResourceHarvester;
import me.eliax00789.zombsio.buildings.towers.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_19_R1.util.CraftMagicNumbers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

public class BuildSave {

    private static File filebuildings;
    public static YamlConfiguration buildings;
    public static HashMap<Integer,Building> buildingsMap;

    public BuildSave() {
        buildingsMap = new HashMap<Integer,Building>();
        loadFromConfig();
    }

    private void loadFromConfig() {
        filebuildings = new File(Zombsio.plugin.getDataFolder(), "buildings.yml");
        if (!filebuildings.exists()){
            try {
                filebuildings.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        buildings = YamlConfiguration.loadConfiguration(filebuildings);
        if (!buildings.contains("nextid")) {
            buildings.set("nextid",1);
        }
        try {
            buildings.load(filebuildings);
        } catch (IOException | InvalidConfigurationException e) {
            Bukkit.getLogger().log(Level.WARNING,e.toString());
        }
        final Integer nextid = buildings.getInt("nextid");
        for (Integer i = 0; i <= nextid; i++) {
            Bukkit.broadcastMessage("Id:" + i);
            if (buildings.contains("buildings." + i + ".name")) {
                String name = buildings.getString("buildings." + i + ".name");
                Location location = buildings.getLocation("buildings." + i + ".location");
                Integer level = buildings.getInt("buildings." + i + ".level");
                if (name.contains("Door")) {
                    new Door(null,location,level);
                }
                else if (name.contains("SlowTrap")) {
                    new SlowTrap(null,location,level);
                }
                else if (name.contains("Wall")) {
                    new Wall(null,location,level);
                }
                else if (name.contains("GoldMine")) {
                    new GoldMine(null,location,level);
                }
                else if (name.contains("GoldStash")) {
                    new GoldStash(null,location,level);
                }
                else if (name.contains("ResourceHarvester")) {
                    new ResourceHarvester(null,location,level);
                }
                else if (name.contains("ArrowTower")) {
                    new ArrowTower(null,location,level);
                }
                else if (name.contains("BombTower")) {
                    new BombTower(null,location,level);
                }
                else if (name.contains("CannonTower")) {
                    new CannonTower(null,location,level);
                }
                else if (name.contains("MageTower")) {
                    new MageTower(null,location,level);
                }
                else if (name.contains("MeleeTower")) {
                    new MeleeTower(null,location,level);
                }
                else {
                    new Wall(null,location,level);
                }
                remove(i);
            }
        }
        save();
    }

    public static void save() {
        for (Integer i: buildingsMap.keySet()) {
            buildings.set("buildings." + i + ".name",buildingsMap.get(i).name);
            buildings.set("buildings." + i + ".level",buildingsMap.get(i).level);
            buildings.set("buildings." + i + ".location",buildingsMap.get(i).location);
        }
        saveToFile();
    }

    public static void remove(Integer id) {
        BuildSave.buildingsMap.remove(id);
        buildings.set("buildings." + id,null);
        saveToFile();
    }

    private static void saveToFile() {
        try {
            buildings.save(filebuildings);
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.WARNING,e.toString());
        }
    }
}
