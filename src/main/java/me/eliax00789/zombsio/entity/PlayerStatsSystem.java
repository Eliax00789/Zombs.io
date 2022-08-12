package me.eliax00789.zombsio.entity;

import me.eliax00789.zombsio.Zombsio;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
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

    public BukkitTask statsupdate;

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

        if (!playerstats.contains("config.defaults.health")) {
            playerstats.set("config.defaults.health", 200);
        }

        if (!playerstats.contains("config.defaults.maxhealth")) {
            playerstats.set("config.defaults.maxhealth", 200);
        }

        if (!playerstats.contains("config.defaults.shield")) {
            playerstats.set("config.defaults.shield", 0);
        }

        if (!playerstats.contains("config.defaults.maxshield")) {
            playerstats.set("config.defaults.maxshield", 0);
        }

        if (!playerstats.contains("config.defaults.defense")) {
            playerstats.set("config.defaults.defense", 0);
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
                getshield(player);
            } else {
                playerstats.set(player.getName() + ".shield", getdefaultshield());
            }
            if (playerstats.contains(player.getName() + ".maxshield")) {
                getmaxshield(player);
            } else {
                playerstats.set(player.getName() + ".maxshield", getdefaultmaxshield());
            }
            if (playerstats.contains(player.getName() + ".defense")) {
                getdefense(player);
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

        updatestats();
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


    public PlayerStatsSystem saveplayerhealth(Player player) {
        playerstats.set(player.getName() + ".health", health);
        try {
            playerstats.save(playerstatsfile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(e.toString());
        }
        return this;
    }

    public PlayerStatsSystem saveplayermaxhealth(Player player) {
        playerstats.set(player.getName() + ".maxhealth", maxhealth);

        try {
            playerstats.save(playerstatsfile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(e.toString());
        }
        return this;
    }

    public PlayerStatsSystem saveplayershield(Player player) {
        playerstats.set(player.getName() + ".shield", shield);
        try {
            playerstats.save(playerstatsfile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(e.toString());
        }
        return this;
    }

    public PlayerStatsSystem saveplayermaxshield(Player player) {
        playerstats.set(player.getName() + ".maxshield", maxshield);

        try {
            playerstats.save(playerstatsfile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(e.toString());
        }
        return this;
    }

    public PlayerStatsSystem saveplayerdefense(Player player) {
        playerstats.set(player.getName() + ".defense", defense);

        try {
            playerstats.save(playerstatsfile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(e.toString());
        }
        return this;
    }

    public PlayerStatsSystem updatestats() {
        statsupdate = new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player: Bukkit.getOnlinePlayers()) {
                    if(player.getGameMode().equals(GameMode.SURVIVAL)) {
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                new TextComponent(
                                        "§c❤ " + gethealth(player) + " / " + getmaxhealth(player)
                                        + "  §a❈ " + getdefense(player)
                                        + "  §b❤ " + getshield(player) + " / " + getmaxshield(player)
                                )

                        );
                        player.setHealth((double) gethealth(player)/10);
                        player.setMaxHealth((double) getmaxhealth(player)/10);
                    }
                }

            }
        }.runTaskTimer(Zombsio.plugin, 0 , 5);

        return this;
    }

    public PlayerStatsSystem addmaxhealth(Player player, Integer addmaxhealth) {
        maxhealth = getmaxhealth(player) + addmaxhealth;
        saveplayermaxhealth(player);
        return this;
    }

    public PlayerStatsSystem removemaxhealth(Player player, Integer removemaxhealth) {
        maxhealth = getmaxhealth(player) - removemaxhealth;
        saveplayermaxhealth(player);
        return this;
    }

    public PlayerStatsSystem setmaxhealth(Player player, Integer setmaxhealth) {
        maxhealth = setmaxhealth;
        saveplayermaxhealth(player);
        return this;
    }

    public PlayerStatsSystem addhealth(Player player, Integer addhealth) {
        health = gethealth(player) + addhealth;
        saveplayerhealth(player);
        return this;
    }

    public PlayerStatsSystem removehealth(Player player, Integer removehealth) {
        health = gethealth(player) - removehealth;
        saveplayerhealth(player);
        return this;
    }

    public PlayerStatsSystem sethealth(Player player, Integer sethealth) {
        health = sethealth;
        saveplayerhealth(player);
        return this;
    }

    public PlayerStatsSystem addmaxshield(Player player, Integer addmaxshield) {
        maxshield = getmaxshield(player) + addmaxshield;
        saveplayermaxshield(player);
        return this;
    }

    public PlayerStatsSystem removemaxshield(Player player, Integer removemaxshield) {
        maxshield = getmaxshield(player) - removemaxshield;
        saveplayermaxshield(player);
        return this;
    }

    public PlayerStatsSystem setmaxshield(Player player, Integer setmaxshield) {
        maxshield = setmaxshield;
        saveplayermaxshield(player);
        return this;
    }

    public PlayerStatsSystem addshield(Player player, Integer addshield) {
        shield = getshield(player) + addshield;
        saveplayershield(player);
        return this;
    }

    public PlayerStatsSystem removeshield(Player player, Integer removeshield) {
        shield = getshield(player) - removeshield;
        saveplayershield(player);
        return this;
    }

    public PlayerStatsSystem setshield(Player player, Integer setshield) {
        shield = setshield;
        saveplayershield(player);
        return this;
    }

    public PlayerStatsSystem adddefense(Player player, Integer adddefence) {
        defense = getdefense(player) + adddefence;
        saveplayerdefense(player);
        return this;
    }

    public PlayerStatsSystem removedefense(Player player, Integer removedefence) {
        defense = getdefense(player) - removedefence;
        saveplayerdefense(player);
        return this;
    }

    public PlayerStatsSystem setdefense(Player player, Integer setdefence) {
        defense = setdefence;
        saveplayerdefense(player);
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
            playerstats.set(player.getName() + ".health", health);
            saveplayerhealth(player);
        }

        return this;
    }

    public PlayerStatsSystem regenhealth(Integer regen, Player player) {
        if (gethealth(player) + regen <= getmaxhealth(player)) {
            health = gethealth(player) + regen;
            playerstats.set(player.getName() + ".health", health);
            saveplayerhealth(player);
        }
        return this;
    }

    public PlayerStatsSystem regenshield(Player player) {
        for (int i = getshield(player); i < getmaxshield(player); i++) {
            shield = getshield(player) + 1;
        }
        saveplayershield(player);
        return this;
    }

    private Integer delay;

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        takedamage((int) e.getDamage()*10, (Player) e.getEntity());

        if (((Player) e.getEntity()).getInventory().getItem(9).getType().equals(Material.LIGHT_BLUE_STAINED_GLASS_PANE)) {
            for (String name:Zombsio.plugin.getConfig().getStringList("Items.Shield.Name")) {
                if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Shield.Name").get(0))) {delay = Zombsio.plugin.getConfig().getIntegerList("Items.Shield.RechargeDelay").get(0);}
                else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Shield.Name").get(1))) {delay = Zombsio.plugin.getConfig().getIntegerList("Items.Shield.RechargeDelay").get(1);}
                else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Shield.Name").get(2))) {delay = Zombsio.plugin.getConfig().getIntegerList("Items.Shield.RechargeDelay").get(2);}
                else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Shield.Name").get(3))) {delay = Zombsio.plugin.getConfig().getIntegerList("Items.Shield.RechargeDelay").get(3);}
                else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Shield.Name").get(4))) {delay = Zombsio.plugin.getConfig().getIntegerList("Items.Shield.RechargeDelay").get(4);}
                else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Shield.Name").get(5))) {delay = Zombsio.plugin.getConfig().getIntegerList("Items.Shield.RechargeDelay").get(5);}
                else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Shield.Name").get(6))) {delay = Zombsio.plugin.getConfig().getIntegerList("Items.Shield.RechargeDelay").get(6);}
                else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Shield.Name").get(7))) {delay = Zombsio.plugin.getConfig().getIntegerList("Items.Shield.RechargeDelay").get(7);}
                else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Shield.Name").get(8))) {delay = Zombsio.plugin.getConfig().getIntegerList("Items.Shield.RechargeDelay").get(8);}
                else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Shield.Name").get(9))) {delay = Zombsio.plugin.getConfig().getIntegerList("Items.Shield.RechargeDelay").get(9);}
                else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Shield.Name").get(10))) {delay = Zombsio.plugin.getConfig().getIntegerList("Items.Shield.RechargeDelay").get(10);}
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        regenshield((Player) e.getEntity());
                    }
                }.runTaskLater(Zombsio.plugin, 20L*delay);
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.getDrops().removeAll(e.getDrops());
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
