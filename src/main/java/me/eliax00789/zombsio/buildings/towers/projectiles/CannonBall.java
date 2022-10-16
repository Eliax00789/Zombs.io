package me.eliax00789.zombsio.buildings.towers.projectiles;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

public class CannonBall extends CustomProjectile {
    public CannonBall(Location startLocation, Double range, Double damage) {
        super(startLocation, range, 3.0, damage, 0.25, 1);
    }

    @Override
    public void particle(Location location, Vector vector) {
        //CREDIT: https://www.spigotmc.org/threads/particle-sphere.255813/
        for(double phi=0; phi<=Math.PI; phi+=Math.PI/15) {
            for(double theta=0; theta<=2*Math.PI; theta+=Math.PI/30) {
                double r = 1.5;
                double x = r*Math.cos(theta)*Math.sin(phi);
                double y = r*Math.cos(phi) + 1.5;
                double z = r*Math.sin(theta)*Math.sin(phi);
                location.add(x,y,z);
                location.getWorld().spawnParticle(Particle.ASH, location, 1, 0F, 0F, 0F, 0.001);
                location.subtract(x, y, z);
            }
        }
    }
}
