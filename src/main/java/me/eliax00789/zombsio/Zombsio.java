package me.eliax00789.zombsio;

import me.eliax00789.zombsio.commands.Debug;
import me.eliax00789.zombsio.commands.Resources;
import me.eliax00789.zombsio.guis.buildmenu.BuildMenu;
import me.eliax00789.zombsio.guis.shop.Shop;
import me.eliax00789.zombsio.listener.EveryListener;
import me.eliax00789.zombsio.listener.PlayerJoinListener;
import me.eliax00789.zombsio.listener.PlayerLeaveListener;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
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
    private File file;

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
        file = new File(getDataFolder(), "buildings.yml");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        buildings = YamlConfiguration.loadConfiguration(file);
        if (!buildings.contains("nextid")) {
            buildings.set("nextid",0);
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                Config.getInstance().save();
                try {
                    buildings.save(file);
                } catch (IOException e) {
                    Bukkit.getLogger().log(Level.WARNING,e.toString());
                }
            }
        }.runTaskTimer(this,5,30);
    }

    private void disableConfig() {
        Config.getInstance().save();
        File file = new File(getDataFolder() + File.separator + "buildings.yml");
        try {
            buildings.save(file);
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
        new PlayerLeaveListener();
        //new EveryListener();
        //COMMANDS:
        new Debug();
        new Resources();
    }
}