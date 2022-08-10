package me.eliax00789.zombsio.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.eliax00789.zombsio.Zombsio;
import org.bukkit.Bukkit;

import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;

public class Config {
    private static File configfile;

    public HashMap<String,String> LASTSHOPPAGE;
    public HashMap<String,Integer> WOOD;
    public HashMap<String,Integer> STONE;
    public HashMap<String,Integer> GOLD;

    public Config() {
        configfile = new File(Zombsio.plugin.getDataFolder() + File.separator + "configandotherstuff.json");
        this.LASTSHOPPAGE = new HashMap<String,String>();
        this.WOOD = new HashMap<String,Integer>();
        this.STONE = new HashMap<String,Integer>();
        this.GOLD = new HashMap<String,Integer>();
    }

    private static Config instance;

    public static Config getInstance() {
        if (instance == null) {
            instance = fromDefaults();
        }
        return instance;
    }

    public static void setup() {
        String path = configfile.getParent();
        if (!(new File(path).exists())) {
            new File(path).mkdirs();
        }
        if (!(configfile.exists())) {
            try {
                configfile.createNewFile();
            } catch (IOException e) {
                Bukkit.getLogger().log(Level.WARNING,e.toString());
            }
        }
        Config.load();
    }

    public static void load() {
        instance = fromFile();
        if (instance == null) {
            instance = fromDefaults();
        }
    }

    private static Config fromDefaults() {
        Config config = new Config();
        return config;
    }

    public void save() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonConfig = gson.toJson(this);
        FileWriter writer;
        try {
            writer = new FileWriter(configfile);
            writer.write(jsonConfig);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Config fromFile() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(configfile)));
            return gson.fromJson(reader, Config.class);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}