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
    private Location startLocation;
    private Double range;
    private Double aoeRange;
    private Double damage;
    private Double aoeDamage;
    private Double speed;
    private Double knockBack;

    private Entity nearest;
    private Integer counter;

    public CustomProjectile(Location startLocation, Location locationOffset, Double range, Double aoeRange, Double damage, Double aoeDamage, Double speed, Double knockBack) {
        this.startLocation = startLocation.add(locationOffset);
        this.range = range;
        this.aoeRange = aoeRange;
        this.damage = damage;
        this.aoeDamage = aoeDamage;
        this.speed = speed;
        this.knockBack = knockBack;
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
        new BukkitRunnable() {
            @Override
            public void run() {
                if (nearest != null) {
                    projectile(startLocation);
                    if (nearest.getLocation().distance(startLocation) < 1.5) {
                        if (nearest instanceof LivingEntity) {
                            if (knockBack != 0.0) {
                                nearest.setVelocity(nearest.getLocation().toVector().subtract(startLocation.toVector()).multiply(knockBack));
                            }
                            ((LivingEntity) nearest).damage(damage);
                        }
                        for (Entity e : nearest.getNearbyEntities(aoeRange, aoeRange, aoeRange)) {
                            if (e instanceof LivingEntity) {
                                if (knockBack != 0.0) {
                                    e.setVelocity(e.getLocation().toVector().subtract(startLocation.toVector()).multiply(knockBack));
                                }
                                ((LivingEntity) e).damage(aoeDamage);
                            }
                        }
                        this.cancel();
                    }
                    counter++;
                    startLocation.clone().add(nearest.getLocation().toVector().subtract(startLocation.toVector()).multiply(0.005).multiply(speed * counter));
                }
                else {
                    this.cancel();
                }
            }
        }.runTaskTimer(Zombsio.plugin,0,1);
    }

    private void projectile(Location location) {
        location.getWorld().spawnParticle(Particle.CRIT,location,1);
    }
}