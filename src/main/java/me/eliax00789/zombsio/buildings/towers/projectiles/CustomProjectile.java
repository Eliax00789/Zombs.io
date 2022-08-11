package me.eliax00789.zombsio.buildings.towers.projectiles;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.util.Vector;

public class CustomProjectile {

    private World world;
    private Location startLocation;
    private Integer range;
    private Particle particle;
    private Double speed;
    public CustomProjectile(World world, Location startLocation, Integer range, Particle particle, Double speed) {
        this.world = world;
        this.startLocation = startLocation;
        this.range = range;
        this.particle = particle;
        this.speed = speed;
    }

    public void shoot() {
        Entity nearest = null;
        for (Entity e:world.getEntities()) {
            if (e instanceof Mob) {
                if (nearest == null) {
                    nearest = e;
                }
                if (e.getLocation().distance(startLocation) < nearest.getLocation().distance(startLocation)) {
                    nearest = e;
                }
            }
        }
        if (nearest.getLocation().distance(startLocation) <= range) {
            Vector direction = nearest.getLocation().toVector().subtract(startLocation.toVector()).normalize();
            world.spawnParticle(particle, startLocation.getX(), startLocation.getY(), startLocation.getZ(), 0, (float) direction.getX(), (float) direction.getY(), (float) direction.getZ(), speed, null);
        }
    }
}