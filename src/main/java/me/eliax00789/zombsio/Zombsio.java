package me.eliax00789.zombsio;

import me.eliax00789.zombsio.commands.Debug;
import me.eliax00789.zombsio.commands.Resources;
import me.eliax00789.zombsio.guis.buildmenu.BuildMenu;
import me.eliax00789.zombsio.guis.shop.Shop;
import me.eliax00789.zombsio.listener.EveryListener;
import me.eliax00789.zombsio.listener.PlayerJoinListener;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
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
        Bukkit.getConsoleSender().sendMessage("========================");
        Bukkit.getConsoleSender().sendMessage("Starting " + plugin.getDescription().getName() + " Plugin");
        Bukkit.getConsoleSender().sendMessage("========================");
        Bukkit.getConsoleSender().sendMessage("Created By");
        Bukkit.getConsoleSender().sendMessage(String.valueOf(plugin.getDescription().getAuthors()));
        Bukkit.getConsoleSender().sendMessage("========================");
        Bukkit.getConsoleSender().sendMessage("Idea by:");
        Bukkit.getConsoleSender().sendMessage("Zombs.io");
        Bukkit.getConsoleSender().sendMessage("========================");
        Bukkit.getConsoleSender().sendMessage("Version:");
        Bukkit.getConsoleSender().sendMessage(plugin.getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage("========================");
        Bukkit.getConsoleSender().sendMessage("Commands:");
        Bukkit.getConsoleSender().sendMessage(String.valueOf(plugin.getDescription().getCommands()));
        plugin = this;
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
        //GUIS:
        new BuildMenu();
        new Shop();
        //LISTENERS:
        new PlayerJoinListener();
        new EveryListener();
        //COMMANDS:
        new Debug();
        new Resources();

        //GAMERULE:

        this.getServer().getWorld("GUIWorld").setGameRule(GameRule.DO_MOB_SPAWNING, false);
        this.getServer().getWorld("GUIWorld").setGameRule(GameRule.DO_MOB_LOOT, false);
        this.getServer().getWorld("GUIWorld").setGameRule(GameRule.MOB_GRIEFING, false);
    }
}