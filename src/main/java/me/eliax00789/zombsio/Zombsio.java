package me.eliax00789.zombsio;

import me.eliax00789.zombsio.buildings.BuildSave;
import me.eliax00789.zombsio.commands.Build;
import me.eliax00789.zombsio.commands.Stats;
import me.eliax00789.zombsio.commands.Resources;
import me.eliax00789.zombsio.commands.Test;
import me.eliax00789.zombsio.entity.PlayerStats;
import me.eliax00789.zombsio.entity.PlayerStatsSystem;
import me.eliax00789.zombsio.guis.ResourceScoreboard;
import me.eliax00789.zombsio.guis.buildmenu.BuildMenu;
import me.eliax00789.zombsio.guis.shop.Shop;
import me.eliax00789.zombsio.listener.CustomBreakListener;
import me.eliax00789.zombsio.listener.EveryListener;
import me.eliax00789.zombsio.listener.PlayerJoinListener;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public final class Zombsio extends JavaPlugin {
    public static JavaPlugin plugin;
    public static FileConfiguration buildings;
    private File filebuildings;
    public String prefix;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        prefix = "[" + getDescription().getPrefix() + "]" +  " ";

        Bukkit.getConsoleSender().sendMessage(prefix + "==================================");
        Bukkit.getConsoleSender().sendMessage(prefix + "Starting " + plugin.getDescription().getName() + " Plugin");
        Bukkit.getConsoleSender().sendMessage(prefix + " ");
        Bukkit.getConsoleSender().sendMessage(prefix + "Description :");
        Bukkit.getConsoleSender().sendMessage(prefix + plugin.getDescription().getDescription());
        Bukkit.getConsoleSender().sendMessage(prefix + "==================================");
        Bukkit.getConsoleSender().sendMessage(prefix + "Created By");
        Bukkit.getConsoleSender().sendMessage(prefix + String.valueOf(plugin.getDescription().getAuthors()));
        Bukkit.getConsoleSender().sendMessage(prefix + "==================================");
        Bukkit.getConsoleSender().sendMessage(prefix + "Idea by:");
        Bukkit.getConsoleSender().sendMessage(prefix + "Zombs.io");
        Bukkit.getConsoleSender().sendMessage(prefix + "==================================");
        Bukkit.getConsoleSender().sendMessage(prefix + "Version:");
        Bukkit.getConsoleSender().sendMessage(prefix + plugin.getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage(prefix + "==================================");
        enableConfig();
        init();
        Bukkit.getConsoleSender().sendMessage("Loading " + plugin.getDescription().getName() + " Plugin");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("Stopping " + plugin.getDescription().getName() + " Plugin");
        disableConfig();
        Bukkit.getConsoleSender().sendMessage("Disabled " + plugin.getDescription().getName() + " Plugin");
    }

    private void enableConfig() {
        Config.setup();
        filebuildings = new File(getDataFolder(), "buildings.yml");
        getConfig().options().copyDefaults(true);
        saveResource("config.yml", false);
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
        //INPORTANT:
        new BuildSave();
        //GUIS:
        new BuildMenu();
        new Shop();
        //LISTENERS:
        new PlayerJoinListener();
        new EveryListener();
        new CustomBreakListener();
        new PlayerStats();
        //COMMANDS:
        new Stats();
        new Resources();
        new Test();

        for (Player player:Bukkit.getOnlinePlayers()) {
            new ResourceScoreboard(player);
        }

    }
}