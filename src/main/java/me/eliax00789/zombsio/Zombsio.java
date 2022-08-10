package me.eliax00789.zombsio;

import me.eliax00789.zombsio.guis.buildmenu.BuildMenu;
import me.eliax00789.zombsio.guis.shop.Shop;
import me.eliax00789.zombsio.listener.PlayerJoinListener;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.logging.Level;

public final class Zombsio extends JavaPlugin {
    public static JavaPlugin plugin;

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
        new BukkitRunnable() {
            @Override
            public void run() {
                Config.getInstance().save();
            }
        }.runTaskTimer(this,5,60);
    }

    private void disableConfig() {
        Config.getInstance().save();
    }

    private void init() {
        //GUIS:
        new BuildMenu();
        new Shop();
        //LISTENERS:
        new PlayerJoinListener();
    }
}