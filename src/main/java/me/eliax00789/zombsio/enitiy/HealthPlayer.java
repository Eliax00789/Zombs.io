package me.eliax00789.zombsio.enitiy;

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
    private Integer maxhealth;
    private Integer maxshield;

    private Integer defaulthealth;
    private Integer defaultmaxhealth;

    private File playerhealth;
    private YamlConfiguration healthsave;

    private BukkitTask statsupdate;


    public HealthPlayer() {
        createplayerhealth();
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }

    public void createplayerhealth() {
        playerhealth = new File(Zombsio.plugin.getDataFolder(), "playerhealth.yml");
        if (!playerhealth.exists()){
            try {
                playerhealth.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        healthsave = YamlConfiguration.loadConfiguration(playerhealth);

        if (!healthsave.contains("config.default.health")) {
            healthsave.set("config.default.health", 200);
        }

        if (!healthsave.contains("config.default.maxhealth")) {
            healthsave.set("config.default.maxhealth", 200);
        }
        try {
            healthsave.save(playerhealth);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(e.toString());
        }


        for (Player player: Bukkit.getOnlinePlayers()) {
            if (healthsave.contains(player.getName() + ".health")) {
                gethealth(player);
            } else {
                healthsave.set(player.getName() + ".health", getdefaulthealth());
            }

            if (healthsave.contains(player.getName() + ".maxhealth")) {
                getmaxhealth(player);
            } else {
                healthsave.set(player.getName() + ".maxhealth", getdefaultmaxhealth());
            }

            try {
                healthsave.save(playerhealth);
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(e.toString());
            }
        }

        for (OfflinePlayer player: Bukkit.getOfflinePlayers()) {

            healthsave.set(player.getName() + ".health", getdefaulthealth());
            healthsave.set(player.getName() + ".maxhealth", getdefaultmaxhealth());

            try {
                healthsave.save(playerhealth);
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(e.toString());
            }
        }

        updatehealth();
    }

    public Integer gethealth(Player player) {
        health = healthsave.getInt(player.getName() + ".health");
        return health;
    }

    public Integer getmaxhealth(Player player) {
        maxhealth = healthsave.getInt(player.getName() + ".maxhealth");
        return maxhealth;
    }

    public Integer getdefaulthealth() {
        health = healthsave.getInt("config.default.health");
        return health;
    }

    public Integer getdefaultmaxhealth() {
        maxhealth = healthsave.getInt("config.default.maxhealth");
        return maxhealth;
    }

    public HealthPlayer saveplayerhealth(Player player) {
        healthsave.set(player.getName() + ".health", health);
        healthsave.set(player.getName() + ".maxhealth", maxhealth);

        try {
            healthsave.save(playerhealth);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(e.toString());
        }
        return this;
    }

    public HealthPlayer saveplayerhealth() {
        for (Player player: Bukkit.getOnlinePlayers()) {
            if(player.getGameMode().equals(GameMode.SURVIVAL)) {
                healthsave.set(player.getName() + ".health", health);
                healthsave.set(player.getName() + ".maxhealth", maxhealth);
                try {
                    healthsave.save(playerhealth);
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
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§c " + health + " / " + getmaxhealth(player)));
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
            health = health - damage;
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
