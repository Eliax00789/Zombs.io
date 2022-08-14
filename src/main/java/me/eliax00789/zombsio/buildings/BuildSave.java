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
                Building toAdd;
                if (Zombsio.buildings.getString("buildings." + i + ".name").equals("Door")) {
                    toAdd = new Door(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("SlowTrap")) {
                    toAdd = new SlowTrap(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("Wall")) {
                    toAdd = new Wall(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("GoldMine")) {
                    toAdd = new GoldMine(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("GoldStash")) {
                    toAdd = new GoldStash(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("ResourceHarvester")) {
                    toAdd = new ResourceHarvester(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("ArrowTower")) {
                    toAdd = new ArrowTower(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("BombTower")) {
                    toAdd = new BombTower(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("CannonTower")) {
                    toAdd = new CannonTower(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("MageTower")) {
                    toAdd = new MageTower(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else if (Zombsio.buildings.getString("buildings." + i + ".name").equals("MeleeTower")) {
                    toAdd = new MeleeTower(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                else {
                    toAdd = new Wall(null,Zombsio.buildings.getLocation("buildings." + i + ".location"),Zombsio.buildings.getInt("buildings." + i + ".level"));
                }
                Bukkit.broadcastMessage(counter + ". " + toAdd.name);
                buildingsMap.put(counter,toAdd);
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
