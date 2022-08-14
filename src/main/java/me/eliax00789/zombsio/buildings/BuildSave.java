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
        Integer nextid = buildings.getInt("nextid");
        buildings.set("nextid",0);
        for (Integer i = 0; i < nextid; i++) {
            if (buildings.contains("buildings." + i + ".name")) {
                if (buildings.getString("buildings." + i + ".name").equals("Door")) {
                    new Door(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").equals("SlowTrap")) {
                    new SlowTrap(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").equals("Wall")) {
                    new Wall(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").equals("GoldMine")) {
                    new GoldMine(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").equals("GoldStash")) {
                    new GoldStash(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").equals("ResourceHarvester")) {
                    new ResourceHarvester(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").equals("ArrowTower")) {
                    new ArrowTower(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").equals("BombTower")) {
                    new BombTower(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").equals("CannonTower")) {
                    new CannonTower(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").equals("MageTower")) {
                    new MageTower(null,buildings.getLocation("buildings." + i + ".location"),buildings.getInt("buildings." + i + ".level"));
                }
                else if (buildings.getString("buildings." + i + ".name").equals("MeleeTower")) {
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
        Integer counter = 0;
        for (Integer i: buildingsMap.keySet()) {
            Bukkit.broadcastMessage(counter + ". " + buildingsMap.get(i).name);
            counter++;
            buildings.set("buildings." + counter + ".name",buildingsMap.get(i).name);
            buildings.set("buildings." + counter + ".level",buildingsMap.get(i).level);
            buildings.set("buildings." + counter + ".location",buildingsMap.get(i).location);
        }
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
