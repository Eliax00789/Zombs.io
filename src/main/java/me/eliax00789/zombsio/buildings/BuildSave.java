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
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

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
            buildings.set("nextid",0);
        }
        final Integer nextid = buildings.getInt("nextid");
        for (Integer i:buildings.getIntegerList("buildings")) {
            if (buildings.contains("buildings." + i + ".name")) {
                Bukkit.broadcastMessage(buildings.getString("buildings." + i + ".name") + buildings.getLocation("buildings." + i + ".location") + buildings.getInt("buildings." + i + ".level"));
                if (buildings.getString("buildings." + i + ".name").equals("Door")) {
                    new Door(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").contains("SlowTrap")) {
                    new SlowTrap(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").contains("Wall")) {
                    new Wall(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").contains("GoldMine")) {
                    new GoldMine(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").contains("GoldStash")) {
                    new GoldStash(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").contains("ResourceHarvester")) {
                    new ResourceHarvester(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").contains("ArrowTower")) {
                    new ArrowTower(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").contains("BombTower")) {
                    new BombTower(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").contains("CannonTower")) {
                    new CannonTower(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").contains("MageTower")) {
                    new MageTower(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").contains("MeleeTower")) {
                    new MeleeTower(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else {
                    new Wall(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
            }
        }
        saveToFile();
    }

    public static void save() {
        buildings.set("buildings",null);
        saveToFile();
        for (Integer i: buildingsMap.keySet()) {
            buildings.set("buildings." + i + ".name",buildingsMap.get(i).name);
            buildings.set("buildings." + i + ".level",buildingsMap.get(i).level);
            buildings.set("buildings." + i + ".location",buildingsMap.get(i).location);
        }
        saveToFile();
    }

    private static void saveToFile() {
        try {
            buildings.save(filebuildings);
            buildings.load(filebuildings);
        } catch (IOException | InvalidConfigurationException e) {
            Bukkit.getLogger().log(Level.WARNING,e.toString());
        }
    }
}
