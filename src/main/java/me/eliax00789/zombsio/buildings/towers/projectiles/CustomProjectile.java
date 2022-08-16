package me.eliax00789.zombsio.buildings.towers.projectiles;

import me.eliax00789.zombsio.Zombsio;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.checkerframework.checker.units.qual.Luminance;

import java.util.ArrayList;

public class CustomProjectile {
    public ArrayList<BukkitRunnable> shootRuns;
    private Location startLocation;
    private Location currLocation;
    private Entity nearest;
    private Vector nearestEntityDirection;
    private Double range;
    private Double aoeRange;
    private Double damage;
    private Double aoeDamage;
    private Double speed;
    private Integer particleLifetime;
    private Integer counter;
    public CustomProjectile(Location startLocation, Double range, Double aoeRange, Double damage, Double aoeDamage, Double speed, Integer particleLifetime) {
        this.shootRuns = new ArrayList<BukkitRunnable>();
        this.startLocation = startLocation.add(0.5,0,0.5);
        this.range = range;
        this.aoeRange = aoeRange;
        this.damage = damage;
        this.aoeDamage = aoeDamage;
        this.particleLifetime = particleLifetime;
        this.speed = speed;
    }

    public void shoot() {
        nearest = null;
        for (Entity e:startLocation.getWorld().getEntities()) {
            if (e instanceof Monster) {
                if (nearest == null) {
                    nearest = e;
                }
                if (e.getLocation().distance(startLocation) < nearest.getLocation().distance(startLocation)) {
                    nearest = e;
                }
            }
        }
        currLocation = startLocation.clone();
        counter = 0;
        if (nearest != null && nearest instanceof LivingEntity && currLocation.distance(((LivingEntity) nearest).getEyeLocation()) <= range) {
            nearestEntityDirection = ((LivingEntity) nearest).getEyeLocation().toVector().subtract(currLocation.toVector()).multiply(speed / particleLifetime).normalize();
            new BukkitRunnable() {
                @Override
                public void run() {
                    shootRuns.add(this);
                    particle(currLocation,nearestEntityDirection);
                    currLocation.add(nearestEntityDirection);
                    counter++;
                    if (startLocation.distance(currLocation) > range) {
                        shootRuns.remove(this);
                        this.cancel();
                    }
                    for (Entity e:currLocation.getWorld().getNearbyEntities(currLocation,1,1,1)) {
                        if (e instanceof Monster && e instanceof LivingEntity) {
                            ((LivingEntity) e).damage(damage);
                            shootRuns.remove(this);
                            this.cancel();
                        }
                    }
                }
            }.runTaskTimer(Zombsio.plugin,0,particleLifetime);
        }
    }

    public void cancelAllShots() {
        for (BukkitRunnable r:shootRuns) {
            r.cancel();
        }
        shootRuns = new ArrayList<BukkitRunnable>();
    }

    private void particle(Location location,Vector vector) {
        location.getWorld().spawnParticle(Particle.FLAME,location,0,vector.getX(),vector.getY(),vector.getZ(),speed/particleLifetime,null);
    }
}