package me.eliax00789.zombsio;

import me.eliax00789.zombsio.utility.Config;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Zombsio extends JavaPlugin {
    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        enableConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        disableConfig();
    }

    private void enableConfig() {
        Config.setup();
        new BukkitRunnable() {
            @Override
            public void run() {
                Config.getInstance().save();
            }
        }.runTaskTimer(this,5,120);
    }

    private void disableConfig() {
        Config.getInstance().save();
    }
}