package me.eliax00789.zombsio.listener;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.entity.PlayerStatsSystem;
import me.eliax00789.zombsio.utility.Config;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.protocol.game.PacketPlayOutBlockBreakAnimation;
import net.minecraft.network.protocol.game.PacketPlayOutBlockChange;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_19_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_19_R1.block.CraftBlock;
import org.bukkit.craftbukkit.v1_19_R1.block.data.CraftBlockData;
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

    private BukkitRunnable countercount;
    private BukkitRunnable mining;
    private Double counter;

    public CustomBreakListener() {
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent e) {
        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 9999, 999));
        if ((e.getBlock().getType().equals(Material.OAK_LOG) || e.getBlock().getType().equals(Material.STONE)) && e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
            for (String name:Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name")) {
                if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(name)) {
                    Integer harvest;
                    Double attackspeed;
                    if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(0))) {harvest = Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest").get(0); attackspeed = Zombsio.plugin.getConfig().getDoubleList("Items.Pickaxe.Attackspeed").get(0);}
                    else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(1))) {harvest = Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest").get(1); attackspeed = Zombsio.plugin.getConfig().getDoubleList("Items.Pickaxe.Attackspeed").get(1);}
                    else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(2))) {harvest = Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest").get(2); attackspeed = Zombsio.plugin.getConfig().getDoubleList("Items.Pickaxe.Attackspeed").get(2);}
                    else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(3))) {harvest = Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest").get(3); attackspeed = Zombsio.plugin.getConfig().getDoubleList("Items.Pickaxe.Attackspeed").get(3);}
                    else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(4))) {harvest = Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest").get(4); attackspeed = Zombsio.plugin.getConfig().getDoubleList("Items.Pickaxe.Attackspeed").get(4);}
                    else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(5))) {harvest = Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest").get(5); attackspeed = Zombsio.plugin.getConfig().getDoubleList("Items.Pickaxe.Attackspeed").get(5);}
                    else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(6))) {harvest = Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest").get(6); attackspeed = Zombsio.plugin.getConfig().getDoubleList("Items.Pickaxe.Attackspeed").get(6);}
                    else if (name.equalsIgnoreCase(Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(7))) {harvest = Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest").get(7); attackspeed = Zombsio.plugin.getConfig().getDoubleList("Items.Pickaxe.Attackspeed").get(7);}
                    else {harvest = 1; attackspeed = 1.0;}
                    counter = 0.0;
                    mining = new BukkitRunnable() {
                        @Override
                        public void run() {
                            PacketPlayOutBlockBreakAnimation packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 0);
                            if (counter >= 0 && counter < 10) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 1);}
                            else if (counter >= 10 && counter < 20) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 2);}
                            else if (counter >= 20 && counter < 30) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 3);}
                            else if (counter >= 30 && counter < 40) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 4);}
                            else if (counter >= 40 && counter < 50) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 5);}
                            else if (counter >= 50 && counter < 60) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 6);}
                            else if (counter >= 60 && counter < 70) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 7);}
                            else if (counter >= 70 && counter < 80) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 8);}
                            else if (counter >= 80 && counter < 90) {packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 9);}
                            else if (counter >= 90) {
                                counter = 0.0;

                                if (e.getBlock().getType().equals(Material.OAK_LOG)) {
                                    Config.getInstance().WOOD.put(e.getPlayer().getName(), Config.getInstance().WOOD.get(e.getPlayer().getName()) + harvest);
                                    e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§a + " + harvest +  " Wood"));
                                } else if (e.getBlock().getType().equals(Material.STONE)) {
                                    Config.getInstance().STONE.put(e.getPlayer().getName(), Config.getInstance().STONE.get(e.getPlayer().getName()) + harvest);
                                    e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§a + " + harvest +  " Stone"));
                                }
                                new BukkitRunnable() {

                                    @Override
                                    public void run() {

                                    }
                                }.runTaskLater(Zombsio.plugin,  20*6);
                            }
                            ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
                            counter += attackspeed;
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
            PacketPlayOutBlockChange packet = new PacketPlayOutBlockChange(((CraftWorld) e.getBlock().getWorld()).getHandle(), new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()));
            ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
            e.getBlock().setBlockData(e.getBlock().getBlockData());
        }
    }
}
