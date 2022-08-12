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
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class HealthPlayer implements Listener {

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
    private Boolean aktiveshield, aktivedefece;

    public HealthPlayer() {
        createplayerhealth();
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }

    public void createplayerhealth() {
        playerstatsfile = new File(Zombsio.plugin.getDataFolder(), "playerhealth.yml");
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

            try {
                playerstats.save(playerstatsfile);
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(e.toString());
            }
        }

        for (OfflinePlayer player: Bukkit.getOfflinePlayers()) {

            playerstats.set(player.getName() + ".health", getdefaulthealth());
            playerstats.set(player.getName() + ".maxhealth", getdefaultmaxhealth());

            try {
                playerstats.save(playerstatsfile);
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(e.toString());
            }
        }

        updatehealth();
    }

    public Boolean hasshield() {

        return aktiveshield;
    }

    public Boolean hasdefece() {

        return aktivedefece;
    }


    public Integer gethealth(Player player) {
        health = playerstats.getInt(player.getName() + ".health");
        return health;
    }

    public Integer getmaxhealth(Player player) {
        maxhealth = playerstats.getInt(player.getName() + ".maxhealth");
        return maxhealth;
    }

    public Integer getshield(Player player) {
        shield = playerstats.getInt(player.getName() + ".shield");
        return shield;
    }

    public Integer getmaxshield(Player player) {
        maxshield = playerstats.getInt(player.getName() + ".maxshield");
        return maxshield;
    }

    public Integer getdefense(Player player) {
        defense = playerstats.getInt(player.getName() + ".defense");
        return defense;
    }

    public Integer getdefaulthealth() {
        health = playerstats.getInt("config.defaults.health");
        return health;
    }

    public Integer getdefaultmaxhealth() {
        maxhealth = playerstats.getInt("config.defaults.maxhealth");
        return maxhealth;
    }
    public Integer getdefaultshield() {
        defaultshield = playerstats.getInt("config.defaults.shield");
        return defaultshield;
    }

    public Integer getdefaultmaxshield() {
        defaultmaxshield = playerstats.getInt("config.defaults.maxshield");
        return defaultmaxshield;
    }

    public Integer getdefensehealth() {
        defaultdefense = playerstats.getInt("config.defaults.defense");
        return defaultdefense;
    }


    public HealthPlayer saveplayerhealth(Player player) {
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

    public HealthPlayer saveplayerhealth() {
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


    private HealthPlayer updatehealth() {
        statsupdate = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player: Bukkit.getOnlinePlayers()) {
                    if(player.getGameMode().equals(GameMode.SURVIVAL)) {
                        gethealth(player);
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                new TextComponent(
                                        "§c " + health + " / " + getmaxhealth(player)));
                        player.setHealth((double) health/10);
                        player.setMaxHealth((double) health/10);
                    }
                }

            }
        }.runTaskTimer(Zombsio.plugin, 0 , 5);


        return this;
    }

    public HealthPlayer changemaxhealth(Player player,Integer addmaxhealth) {
        Integer maxhealth = getmaxhealth(player) + addmaxhealth;

        saveplayerhealth(player);
        return this;
    }


    public HealthPlayer takedamage(Integer damage, Player player) {
        if (health - damage > 0) {
            health = health - damage/defense;
            saveplayerhealth(player);
        }

        return this;
    }

    public HealthPlayer regen(Integer regen, Player player) {
        if (health + regen <= maxhealth) {
            health = health + regen;
            saveplayerhealth(player);
        }

        return this;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        takedamage((int) e.getDamage()*10, (Player) e.getEntity());

    }

    @EventHandler
    public void onEntityRegain(EntityRegainHealthEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }

        regen((int) e.getAmount()*10, (Player) e.getEntity());
        e.setCancelled(true);
    }

}
