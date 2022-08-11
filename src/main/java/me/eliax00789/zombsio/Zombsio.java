package me.eliax00789.zombsio;

import me.eliax00789.zombsio.commands.Debug;
import me.eliax00789.zombsio.commands.Resources;
import me.eliax00789.zombsio.guis.buildmenu.BuildMenu;
import me.eliax00789.zombsio.guis.shop.Shop;
import me.eliax00789.zombsio.listener.EveryListener;
import me.eliax00789.zombsio.listener.PlayerJoinListener;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public final class Zombsio extends JavaPlugin {
    public static JavaPlugin plugin;
    public static FileConfiguration buildings;
    private File filebuildings;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().log(Level.ALL,"Starting Zombsio Plugin");
        plugin = this;
        enableConfig();
        init();
        Bukkit.getLogger().log(Level.ALL,"Loading Zombsio Plugin");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().log(Level.ALL,"Stopping Zombsio Plugin");
        disableConfig();
        Bukkit.getLogger().log(Level.ALL,"Disabled Zombsio Plugin");
    }

    private void enableConfig() {
        Config.setup();
        filebuildings = new File(getDataFolder(), "buildings.yml");
        saveConfig();
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
        new BukkitRunnable() {
            @Override
            public void run() {
                Config.getInstance().save();
                try {
                    buildings.save(filebuildings);
                } catch (IOException e) {
                    Bukkit.getLogger().log(Level.WARNING,e.toString());
                }
            }
        }.runTaskTimer(this,5,30);
    }

    private void disableConfig() {
        Config.getInstance().save();
        try {
            buildings.save(filebuildings);
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.WARNING,e.toString());
        }
    }

    private void init() {
        //GUIS:
        new BuildMenu();
        new Shop();
        //LISTENERS:
        new PlayerJoinListener();
        new EveryListener();
        //COMMANDS:
        new Debug();
        new Resources();
    }
}