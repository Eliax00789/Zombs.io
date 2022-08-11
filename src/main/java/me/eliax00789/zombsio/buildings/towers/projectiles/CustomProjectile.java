package me.eliax00789.zombsio.buildings.towers.projectiles;

import me.eliax00789.zombsio.Zombsio;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Monster;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class CustomProjectile {

    private World world;
    private Location startLocation;
    private Integer range;
    private Particle particle;
    private Double speed;
    private Double damage;
    public CustomProjectile(World world, Location startLocation, Integer range, Particle particle, Double damage, Double speed) {
        this.world = world;
        this.startLocation = startLocation;
        this.range = range;
        this.particle = particle;
        this.speed = speed;
        this.damage = damage;
    }

    public void shoot() {
        Entity nearest = null;
        for (Entity e:world.getEntities()) {
            if (e instanceof Monster) {
                if (nearest == null) {
                    nearest = e;
                }
                if (e.getLocation().distance(startLocation) < nearest.getLocation().distance(startLocation)) {
                    nearest = e;
                }
            }
        }
        Entity finalNearest = nearest;
        if (finalNearest.getLocation().distance(startLocation) <= range) {
            Vector direction = finalNearest.getLocation().toVector().subtract(startLocation.toVector()).normalize();
            world.spawnParticle(particle, startLocation.getX(), startLocation.getY(), startLocation.getZ(), 0, (float) direction.getX(), (float) direction.getY(), (float) direction.getZ(), speed, null);
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (finalNearest instanceof LivingEntity) {
                        ((LivingEntity) finalNearest).damage(damage);
                    }
                }
            }.runTaskLater(Zombsio.plugin, (long) (finalNearest.getLocation().distance(startLocation) / speed));
        }
    }
}