package me.eliax00789.zombsio.entity;

import me.eliax00789.zombsio.Zombsio;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

public class PlayerStats implements Listener {

    private File playerStatsFile;
    private YamlConfiguration playerstats;
    public static HashMap<Player,Double[]> stats;

    public PlayerStats() {
        stats = new HashMap<Player,Double[]>();
        playerStatsFile = new File(Zombsio.plugin.getDataFolder(), "playerstats.yml");
        if (!playerStatsFile.exists()){
            try {playerStatsFile.createNewFile();}
            catch (IOException e) {Bukkit.getLogger().log(Level.WARNING,e.toString());}
        }
        playerstats = YamlConfiguration.loadConfiguration(playerStatsFile);

        if (!playerstats.contains("config.defaults.health")) {playerstats.set("config.defaults.health", 200.0);}
        if (!playerstats.contains("config.defaults.maxhealth")) {playerstats.set("config.defaults.maxhealth", 200.0);}
        if (!playerstats.contains("config.defaults.shield")) {playerstats.set("config.defaults.shield", 0.0);}
        if (!playerstats.contains("config.defaults.maxshield")) {playerstats.set("config.defaults.maxshield", 0.0);}
        if (!playerstats.contains("config.defaults.defense")) {playerstats.set("config.defaults.defense", 0.0);}
        save();

        for (Player player: Bukkit.getOnlinePlayers()) {
            if (!playerstats.contains("stats." + player.getName() + ".health")) {playerstats.set("stats." + player.getName() + ".health", playerstats.getDouble("config.defaults.health"));}
            if (!playerstats.contains("stats." + player.getName() + ".maxhealth")) {playerstats.set("stats." + player.getName() + ".maxhealth", playerstats.getDouble("config.defaults.maxhealth"));}
            if (!playerstats.contains("stats." + player.getName() + ".shield")) {playerstats.set("stats." + player.getName() + ".shield", playerstats.getDouble("config.defaults.shield"));}
            if (!playerstats.contains("stats." + player.getName() + ".maxshield")) {playerstats.set("stats." + player.getName() + ".maxshield", playerstats.getDouble("config.defaults.maxshield"));}
            if (!playerstats.contains("stats." + player.getName() + ".defense")) {playerstats.set("stats." + player.getName() + ".defense", playerstats.getDouble("config.defaults.defense"));}
        }
        save();

        for (Player player: Bukkit.getOnlinePlayers()) {
            stats.put(player,new Double[]{
                    playerstats.getDouble("stats." + player.getName() + ".health"),
                    playerstats.getDouble("stats." + player.getName() + ".maxhealth"),
                    playerstats.getDouble("stats." + player.getName() + ".shield"),
                    playerstats.getDouble("stats." + player.getName() + ".maxshield"),
                    playerstats.getDouble("stats." + player.getName() + ".defense"),
                    0.0});
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player: Bukkit.getOnlinePlayers()) {
                    if (player.getGameMode().equals(GameMode.SURVIVAL)) {
                        player.setMaxHealth(stats.get(player)[1] / 10);
                        player.setHealth(stats.get(player)[0] / 10);
                        player.setAbsorptionAmount(stats.get(player)[3] / 10);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                new TextComponent(
                                        "§c❤ " + stats.get(player)[0] + " / " + stats.get(player)[1]
                                                + "  §a❈ " + stats.get(player)[4]
                                                + "  §b❤ " + stats.get(player)[2] + " / " + stats.get(player)[3]
                                )
                        );
                        Double[] newstats = stats.get(player);
                        if (stats.get(player)[5] <= 0) {
                            newstats[5] = 30.0;
                            if (stats.get(player)[0] < stats.get(player)[1]) {
                                newstats[0] = stats.get(player)[0] + 1;
                            }
                            else {
                                if (stats.get(player)[2] < stats.get(player)[3]) {
                                    newstats[2] = stats.get(player)[0] + 1;
                                }
                            }
                        }
                        else {
                            newstats[5] = stats.get(player)[5] - 1.0;
                        }
                        stats.put(player,newstats);
                        save();
                    }
                }
            }
        }.runTaskTimer(Zombsio.plugin,0,1);

        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }

    public void save() {
        for (Player player: stats.keySet()) {
            playerstats.set("stats." + player.getName() + ".health", stats.get(player)[0]);
            playerstats.set("stats." + player.getName() + ".maxhealth", stats.get(player)[1]);
            playerstats.set("stats." + player.getName() + ".shield", stats.get(player)[2]);
            playerstats.set("stats." + player.getName() + ".maxshield", stats.get(player)[3]);
            playerstats.set("stats." + player.getName() + ".defense", stats.get(player)[4]);
        }
        try {
            playerstats.save(playerStatsFile);
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.WARNING,e.toString());
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (!playerstats.contains("stats." + e.getPlayer().getName() + ".health")) {playerstats.set("stats." + e.getPlayer().getName() + ".health", playerstats.getDouble("config.defaults.health"));}
        if (!playerstats.contains("stats." + e.getPlayer().getName() + ".maxhealth")) {playerstats.set("stats." + e.getPlayer().getName() + ".maxhealth", playerstats.getDouble("config.defaults.maxhealth"));}
        if (!playerstats.contains("stats." + e.getPlayer().getName() + ".shield")) {playerstats.set("stats." + e.getPlayer().getName() + ".shield", playerstats.getDouble("config.defaults.shield"));}
        if (!playerstats.contains("stats." + e.getPlayer().getName() + ".maxshield")) {playerstats.set("stats." + e.getPlayer().getName() + ".maxshield", playerstats.getDouble("config.defaults.maxshield"));}
        if (!playerstats.contains("stats." + e.getPlayer().getName() + ".defense")) {playerstats.set("stats." + e.getPlayer().getName() + ".defense", playerstats.getDouble("config.defaults.defense"));}
        save();
        stats.put(e.getPlayer(),new Double[]{
                playerstats.getDouble("stats." + e.getPlayer().getName() + ".health"),
                playerstats.getDouble("stats." + e.getPlayer().getName() + ".maxhealth"),
                playerstats.getDouble("stats." + e.getPlayer().getName() + ".shield"),
                playerstats.getDouble("stats." + e.getPlayer().getName() + ".maxshield"),
                playerstats.getDouble("stats." + e.getPlayer().getName() + ".defense"),
                0.0});
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            e.setCancelled(true);
            Player player = (Player) e.getEntity();
            Double damage = e.getDamage() * 10;
            Double[] oldstats = stats.get(player);
            Double[] newstats = stats.get(player);
            newstats[5] = 60.0;
            if (oldstats[2] > 0) {
                if (oldstats[2] >= damage) {
                    newstats[2] = oldstats[2] - damage;
                }
                else {
                    newstats[2] = 0.0;
                    newstats[0] = oldstats[0] - (((damage / 100) * 4) * oldstats[4]);
                }
            }
            else {
                newstats[0] = oldstats[0] - (damage - (((damage / 100) * 4) * oldstats[4]));
            }
            if (newstats[0] <= 0) {
                newstats[0] = stats.get(player)[1];
                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_DEATH, 100, 1.0F);
                player.teleport(player.getWorld().getSpawnLocation());
                Bukkit.broadcastMessage(player.getName() + " fricking died");
            }
            else {
                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 100, 1.0F);
            }
            stats.put(player,newstats);
            save();
        }
    }

    @EventHandler
    public void onPlayerRegainHealth(EntityRegainHealthEvent e) {
        if (e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }
}