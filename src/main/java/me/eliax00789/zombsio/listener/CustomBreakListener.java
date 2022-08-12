package me.eliax00789.zombsio.listener;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.utility.Config;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.protocol.game.PacketPlayOutBlockBreakAnimation;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageAbortEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class CustomBreakListener implements Listener {

    private BukkitRunnable mining;
    private Integer counter;

    public CustomBreakListener() {
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent e) {
        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 9999, 999));
        if ((e.getBlock().getType().equals(Material.OAK_LOG) || e.getBlock().getType().equals(Material.STONE)) && e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
            for (String name:Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name")) {
                if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(name)) {
                    Integer level = Integer.valueOf(name.toCharArray()[name.toCharArray().length - 1]);
                    counter = 0;
                    mining = new BukkitRunnable() {
                        @Override
                        public void run() {

                            if (counter == null) {
                                counter = 0;
                            }
                            PacketPlayOutBlockBreakAnimation packet;
                            if (counter >= 0 && counter < 10) {
                                packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 1);
                            }
                            else if (counter >= 10 && counter < 20) {
                                packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 2);
                            }
                            else if (counter >= 20 && counter < 30) {
                                packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 3);
                            }
                            else if (counter >= 30 && counter < 40) {
                                packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 4);
                            }
                            else if (counter >= 40 && counter < 50) {
                                packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 5);
                            }
                            else if (counter >= 50 && counter < 60) {
                                packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 6);
                            }
                            else if (counter >= 60 && counter < 70) {
                                packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 7);
                            }
                            else if (counter >= 70 && counter < 80) {
                                packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 8);
                            }
                            else if (counter >= 80 && counter < 90) {
                                packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 9);
                            }
                            else if (counter >= 90) {
                                counter = 0;
                                if (e.getBlock().getType().equals(Material.OAK_LOG)) {
                                    Config.getInstance().WOOD.put(e.getPlayer().getName(), Config.getInstance().WOOD.get(e.getPlayer().getName()) + level);
                                    e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§a + " + level +  " Wood"));
                                } else if (e.getBlock().getType().equals(Material.STONE)) {
                                    Config.getInstance().STONE.put(e.getPlayer().getName(), Config.getInstance().STONE.get(e.getPlayer().getName()) + level);
                                    e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§a + " + level +  " Stone"));

                                }
                                packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 0);
                            }
                            else {
                                packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 0);
                            }
                            ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
                            counter += level;
                        }
                    };
                    mining.runTaskTimer(Zombsio.plugin,0,1);
                }
            }
        }
    }

    @EventHandler
    public void onBlockDamageAbort(BlockDamageAbortEvent e) {
        e.getPlayer().removePotionEffect(PotionEffectType.SLOW_DIGGING);
        if (mining != null && !mining.isCancelled()) {
            mining.cancel();
        }
        PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 0);
        ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
    }
}
