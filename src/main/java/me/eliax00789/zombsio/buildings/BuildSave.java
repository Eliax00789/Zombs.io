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

import java.util.HashMap;

public class BuildSave {

    public static HashMap<Integer,Building> buildingsMap;

    public BuildSave() {
        buildingsMap = new HashMap<Integer,Building>();
        loadFromConfig();
    }

    private void loadFromConfig() {
        Integer counter = 0;
        for (Integer i = 0; i < Zombsio.buildings.getInt("nextid"); i++) {
            if (Zombsio.buildings.contains("buildings." + i + ".name")) {
                counter++;
                if (Zombsio.buildings.getString("buildings." + i + ".name").equals("Door")) {
                    new Door(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("SlowTrap")) {
                    new SlowTrap(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("Wall")) {
                    new Wall(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("GoldMine")) {
                    new GoldMine(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("GoldStash")) {
                    new GoldStash(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("ResourceHarvester")) {
                    new ResourceHarvester(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("ArrowTower")) {
                    new ArrowTower(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("BombTower")) {
                    new BombTower(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("CannonTower")) {
                    new CannonTower(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("MageTower")) {
                    new MageTower(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("MeleeTower")) {
                    new MeleeTower(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else {
                    new Wall(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
            }
        }
        Zombsio.buildings.set("nextid",counter + 1);
    }

    public static void save() {
        Zombsio.buildings.set("buildings",null);
        Integer counter = 0;
        for (Integer i: buildingsMap.keySet()) {
            Bukkit.broadcastMessage(counter + ". " + buildingsMap.get(i).name);
            counter++;
            Zombsio.buildings.set("buildings." + counter + ".name",buildingsMap.get(i).name);
            Zombsio.buildings.set("buildings." + counter + ".level",buildingsMap.get(i).level);
            Zombsio.buildings.set("buildings." + counter + ".location",buildingsMap.get(i).location);
        }
        Zombsio.buildings.set("nextid",counter + 1);
    }
}
