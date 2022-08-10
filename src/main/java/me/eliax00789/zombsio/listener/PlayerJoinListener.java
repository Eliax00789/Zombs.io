package me.eliax00789.zombsio.listener;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.guis.ResourceScoreboard;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    public PlayerJoinListener() {
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (!Config.getInstance().WOOD.containsKey(e.getPlayer().getName())) {
            Config.getInstance().WOOD.put(e.getPlayer().getName(), 0);
            Config.getInstance().STONE.put(e.getPlayer().getName(), 0);
            Config.getInstance().GOLD.put(e.getPlayer().getName(), 0);
            Config.getInstance().LASTSHOPPAGE.put(e.getPlayer().getName(), "tools");
        }
        new ResourceScoreboard(e.getPlayer());
    }
}