package me.eliax00789.zombsio.entity;

import me.eliax00789.zombsio.Zombsio;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.io.IOException;

public class PlayerStatsSystem implements Listener {

    private Player damagetaker;
    private Integer health;
    private Integer shield;
    private Integer defense;
    private Integer maxhealth;
    private Integer maxshield;

    private Integer defaulthealth;
    private Integer defaultdefense;
    private Integer defaultshield;
    private Integer defaultmaxhealth;
    private Integer defaultmaxshield;


    private File playerstatsfile;
    private YamlConfiguration playerstats;

    private BukkitTask statsupdate;

    public PlayerStatsSystem() {
        createplayerhealth();
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }

    public void createplayerhealth() {
        playerstatsfile = new File(Zombsio.plugin.getDataFolder(), "playerstats.yml");
        if (!playerstatsfile.exists()){
            try {
                playerstatsfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        playerstats = YamlConfiguration.loadConfiguration(playerstatsfile);

        if (!playerstats.contains("config.default.health")) {
            playerstats.set("config.default.health", 200);
        }

        if (!playerstats.contains("config.default.maxhealth")) {
            playerstats.set("config.default.maxhealth", 200);
        }

        if (!playerstats.contains("config.default.shield")) {
            playerstats.set("config.default.shield", 0);
        }

        if (!playerstats.contains("config.default.maxshield")) {
            playerstats.set("config.default.maxshield", 0);
        }

        if (!playerstats.contains("config.default.defense")) {
            playerstats.set("config.default.defense", 0);
        }
        try {
            playerstats.save(playerstatsfile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(e.toString());
        }


        for (Player player: Bukkit.getOnlinePlayers()) {
            if (playerstats.contains(player.getName() + ".health")) {
                gethealth(player);
            } else {
                playerstats.set(player.getName() + ".health", getdefaulthealth());
            }
            if (playerstats.contains(player.getName() + ".maxhealth")) {
                getmaxhealth(player);
            } else {
                playerstats.set(player.getName() + ".maxhealth", getdefaultmaxhealth());
            }
            if (playerstats.contains(player.getName() + ".shield")) {
                gethealth(player);
            } else {
                playerstats.set(player.getName() + ".shield", getdefaultshield());
            }
            if (playerstats.contains(player.getName() + ".maxshield")) {
                getmaxhealth(player);
            } else {
                playerstats.set(player.getName() + ".maxshield", getdefaultmaxshield());
            }
            if (playerstats.contains(player.getName() + ".defense")) {
                gethealth(player);
            } else {
                playerstats.set(player.getName() + ".defense", getdefaultdefense());
            }
            try {
                playerstats.save(playerstatsfile);
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(e.toString());
            }
        }

        for (OfflinePlayer player: Bukkit.getOfflinePlayers()) {

            playerstats.set(player.getName() + ".health", getdefaulthealth());
            playerstats.set(player.getName() + ".maxhealth", getdefaultmaxhealth());
            playerstats.set(player.getName() + ".shield", getdefaultshield());
            playerstats.set(player.getName() + ".maxshield", getdefaultmaxshield());
            playerstats.set(player.getName() + ".defense", getdefaultdefense());
            try {
                playerstats.save(playerstatsfile);
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(e.toString());
            }
        }

        updatehealth();
    }

    public Boolean hasshield(Player player) {
        if (getshield(player) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean hasdefece(Player player) {
        if (getdefense(player) > 0) {
            return true;
        } else {
            return false;
        }
    }


    public Integer gethealth(Player player) {
        return playerstats.getInt(player.getName() + ".health");
    }

    public Integer getmaxhealth(Player player) {
        return playerstats.getInt(player.getName() + ".maxhealth");
    }

    public Integer getshield(Player player) {
        return playerstats.getInt(player.getName() + ".shield");
    }

    public Integer getmaxshield(Player player) {
        return playerstats.getInt(player.getName() + ".maxshield");
    }

    public Integer getdefense(Player player) {
        return playerstats.getInt(player.getName() + ".defense");
    }

    public Integer getdefaulthealth() {
        return playerstats.getInt("config.defaults.health");
    }

    public Integer getdefaultmaxhealth() {
        return playerstats.getInt("config.defaults.maxhealth");
    }
    public Integer getdefaultshield() {
        return playerstats.getInt("config.defaults.shield");
    }

    public Integer getdefaultmaxshield() {
        return playerstats.getInt("config.defaults.maxshield");
    }

    public Integer getdefaultdefense() {
        return playerstats.getInt("config.defaults.defense");
    }


    public PlayerStatsSystem saveplayer(Player player) {
        playerstats.set(player.getName() + ".health", health);
        playerstats.set(player.getName() + ".maxhealth", maxhealth);
        playerstats.set(player.getName() + ".shield", shield);
        playerstats.set(player.getName() + ".maxshield", maxshield);
        playerstats.set(player.getName() + ".defense", defense);

        try {
            playerstats.save(playerstatsfile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(e.toString());
        }
        return this;
    }

    public PlayerStatsSystem saveplayer() {
        for (Player player: Bukkit.getOnlinePlayers()) {
            if(player.getGameMode().equals(GameMode.SURVIVAL)) {
                playerstats.set(player.getName() + ".health", health);
                playerstats.set(player.getName() + ".maxhealth", maxhealth);
                playerstats.set(player.getName() + ".shield", shield);
                playerstats.set(player.getName() + ".maxshield", maxshield);
                playerstats.set(player.getName() + ".defense", defense);
                try {
                    playerstats.save(playerstatsfile);
                } catch (IOException e) {
                    Bukkit.getConsoleSender().sendMessage(e.toString());
                }
            }
        }
        return this;
    }


    private PlayerStatsSystem updatehealth() {
        statsupdate = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player: Bukkit.getOnlinePlayers()) {
                    if(player.getGameMode().equals(GameMode.SURVIVAL)) {
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                new TextComponent(
                                        "§c " + gethealth(player) + " / " + getmaxhealth(player))
                        );
                        player.setHealth((double) gethealth(player)/10);
                        player.setMaxHealth((double) gethealth(player)/10);
                    }
                }

            }
        }.runTaskTimer(Zombsio.plugin, 0 , 5);

        return this;
    }

    public PlayerStatsSystem addmaxhealth(Player player, Integer addmaxhealth) {
        maxhealth = getmaxhealth(player) + addmaxhealth;

        saveplayer(player);
        return this;
    }

    public PlayerStatsSystem setmaxhealth(Player player, Integer setmaxhealth) {
        maxhealth = setmaxhealth;

        saveplayer(player);
        return this;
    }

    public PlayerStatsSystem addmaxshield(Player player, Integer addmaxshield) {
        maxshield = getmaxshield(player) + addmaxshield;

        saveplayer(player);
        return this;
    }

    public PlayerStatsSystem setmaxshield(Player player, Integer setmaxshield) {
        maxshield = setmaxshield;

        saveplayer(player);
        return this;
    }

    public PlayerStatsSystem adddefence(Player player, Integer adddefence) {
        maxshield = getmaxshield(player) + adddefence;

        saveplayer(player);
        return this;
    }

    public PlayerStatsSystem setdefence(Player player, Integer setdefence) {
        maxshield = setdefence;

        saveplayer(player);
        return this;
    }


    public PlayerStatsSystem takedamage(Integer damage, Player player) {
        if ((gethealth(player) - damage) > 0) {
            if (hasshield(player)) {
                if ((getshield(player) - damage) >= 0) {
                    shield = getshield(player) - damage;
                }
            }
            health = gethealth(player) - damage * (1-(getdefense(player)/25));
            saveplayer(player);
        }

        return this;
    }

    public PlayerStatsSystem regenhealth(Integer regen, Player player) {
        if (gethealth(player) + regen <= getmaxhealth(player)) {
            health = gethealth(player) + regen;
            saveplayer(player);
        }
        return this;
    }

    public PlayerStatsSystem regenshield(Integer regen, Player player) {
        if (getshield(player) + regen <= getmaxshield(player)) {
            health = getshield(player) + regen;
            saveplayer(player);
        }
        return this;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }

        ((Player) e.getEntity()).setHealth(0);

        takedamage((int) e.getDamage()*10, (Player) e.getEntity());

    }

    @EventHandler
    public void onEntityRegain(EntityRegainHealthEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }

        regenhealth((int) e.getAmount()*10, (Player) e.getEntity());
        e.setCancelled(true);
    }

}
