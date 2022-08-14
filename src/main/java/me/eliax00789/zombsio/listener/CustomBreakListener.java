package me.eliax00789.zombsio.listener;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.entity.PlayerStatsSystem;
import me.eliax00789.zombsio.utility.Config;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutBlockBreakAnimation;
import net.minecraft.network.protocol.game.PacketPlayOutBlockChange;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R1.block.CraftBlock;
import org.bukkit.craftbukkit.v1_19_R1.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageAbortEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class CustomBreakListener implements Listener {

    private HashMap<Player,BukkitRunnable> mining;
    private HashMap<Player,Double> counter;

    public CustomBreakListener() {
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
        mining = new HashMap<Player,BukkitRunnable>();
        counter = new HashMap<Player,Double>();
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent e) {
        if (!e.getInstaBreak()) {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 9999, 999));
        }
        if ((e.getBlock().getType().equals(Material.OAK_LOG) || e.getBlock().getType().equals(Material.STONE)) && e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
            for (String name:Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name")) {
                if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(name)) {
                    Integer namenumber = Integer.parseInt(name.replaceAll("[^0-9]+", ""))-71;
                    Integer harvest = Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest").get(namenumber);
                    Double attackspeed = Zombsio.plugin.getConfig().getDoubleList("Items.Pickaxe.Attackspeed").get(namenumber);
                    counter.put(e.getPlayer(),0.0);
                    mining.put(e.getPlayer(), new BukkitRunnable() {
                        @Override
                        public void run() {
                            PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 0);
                            if (counter.get(e.getPlayer()) >= 0 && counter.get(e.getPlayer()) < 10) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 1);}
                            else if (counter.get(e.getPlayer()) >= 10 && counter.get(e.getPlayer()) < 20) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 2);}
                            else if (counter.get(e.getPlayer()) >= 20 && counter.get(e.getPlayer()) < 30) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 3);}
                            else if (counter.get(e.getPlayer()) >= 30 && counter.get(e.getPlayer()) < 40) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 4);}
                            else if (counter.get(e.getPlayer()) >= 40 && counter.get(e.getPlayer()) < 50) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 5);}
                            else if (counter.get(e.getPlayer()) >= 50 && counter.get(e.getPlayer()) < 60) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 6);}
                            else if (counter.get(e.getPlayer()) >= 60 && counter.get(e.getPlayer()) < 70) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 7);}
                            else if (counter.get(e.getPlayer()) >= 70 && counter.get(e.getPlayer()) < 80) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 8);}
                            else if (counter.get(e.getPlayer()) >= 80 && counter.get(e.getPlayer()) < 90) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 9);}
                            else if (counter.get(e.getPlayer()) >= 90) {
                                counter.put(e.getPlayer(),0.0);
                                if (e.getBlock().getType().equals(Material.OAK_LOG)) {
                                    Config.getInstance().WOOD.put(e.getPlayer().getName(), Config.getInstance().WOOD.get(e.getPlayer().getName()) + harvest);
                                    e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§a + " + harvest +  " Wood"));
                                } else if (e.getBlock().getType().equals(Material.STONE)) {
                                    Config.getInstance().STONE.put(e.getPlayer().getName(), Config.getInstance().STONE.get(e.getPlayer().getName()) + harvest);
                                    e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§a + " + harvest +  " Stone"));
                                }
                                e.getPlayer().playSound(e.getBlock().getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 100,1.0F);
                                e.getBlock().getWorld().spawnParticle(Particle.BLOCK_CRACK, e.getBlock().getLocation().add(0.5,0.5, 0.5), 80, 0.25, 0, 0.25, 0.7,  e.getBlock().getType().createBlockData());
                            }
                            ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
                            counter.put(e.getPlayer(),counter.get(e.getPlayer()) + attackspeed);
                        }
                    });
                    mining.get(e.getPlayer()).runTaskTimer(Zombsio.plugin,0,1);
                }
            }
        }
    }

    @EventHandler
    public void onBlockDamageAbort(BlockDamageAbortEvent e) {
        e.getPlayer().removePotionEffect(PotionEffectType.SLOW_DIGGING);
        if (mining != null && mining.get(e.getPlayer()) != null && !mining.get(e.getPlayer()).isCancelled()) {
            mining.get(e.getPlayer()).cancel();
            PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), -1);
            ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
        }
    }
}
