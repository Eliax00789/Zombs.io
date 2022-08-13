package me.eliax00789.zombsio.guis;


import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.logging.Level;

public class ResourceScoreboard {

    private Scoreboard scoreboard;
    private Objective objective;

    public ResourceScoreboard(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                player.setScoreboard(getScoreboard(player));
            }
        }.runTaskTimer(Zombsio.plugin,5,10);
    }

    private Scoreboard getScoreboard(Player player) {
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        objective = scoreboard.registerNewObjective("scoreboard", "Test Scoreboard");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("Resources");

        scoreboard.resetScores("Wood: " + Config.getInstance().WOOD.get(player.getName()));
        objective.getScore("Wood: " + Config.getInstance().WOOD.get(player.getName())).setScore(4);

        scoreboard.resetScores("§c ");
        objective.getScore("§c ").setScore(3);

        scoreboard.resetScores("Stone: " + Config.getInstance().STONE.get(player.getName()));
        objective.getScore("Stone: " + Config.getInstance().STONE.get(player.getName())).setScore(2);
        objective.getScore("§a ").setScore(1);

        scoreboard.resetScores("Gold: " + Config.getInstance().GOLD.get(player.getName()));
        objective.getScore("Gold: " + Config.getInstance().GOLD.get(player.getName())).setScore(0);
        return scoreboard;
    }

}