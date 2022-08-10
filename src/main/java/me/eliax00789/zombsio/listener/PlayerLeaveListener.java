package me.eliax00789.zombsio.listener;

import me.eliax00789.zombsio.Zombsio;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;

public class PlayerLeaveListener implements Listener {

    public PlayerLeaveListener() {
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }

    public void onPlayerLeave(PlayerQuitEvent e) {
        e.getPlayer().getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
    }
}
