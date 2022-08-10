package me.eliax00789.zombsio.guis;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class ResourceScoreboard {

    private Scoreboard scoreboard;
    private Objective objective;

    public ResourceScoreboard(Player player) {
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        objective = scoreboard.registerNewObjective("scoreboard", Criteria.DUMMY, "Test");
        objective.setDisplayName("Test Scoreboard");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        new BukkitRunnable() {
            @Override
            public void run() {
                player.setScoreboard(getScoreboard(player));
            }
        }.runTaskTimer(Zombsio.plugin,5,5);
    }

    public Scoreboard getScoreboard(Player player) {
        objective.getScore("Wood: " + Config.getInstance().WOOD.get(player.getName())).setScore(2);
        objective.getScore("Stone: " + Config.getInstance().STONE.get(player.getName())).setScore(1);
        objective.getScore("Gold: " + Config.getInstance().STONE.get(player.getName())).setScore(0);
        return scoreboard;
    }
}