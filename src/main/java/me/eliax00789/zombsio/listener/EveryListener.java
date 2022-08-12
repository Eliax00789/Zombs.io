package me.eliax00789.zombsio.listener;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.utility.Config;
import me.eliax00789.zombsio.utility.ItemCreator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.protocol.game.PacketPlayOutBlockBreakAnimation;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class EveryListener implements Listener {

     public EveryListener() {
          Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
     }

     @EventHandler
     public void onBlockBreak(BlockBreakEvent e) {
          e.getBlock().getWorld().spawnParticle(Particle.BLOCK_CRACK, e.getBlock().getLocation().add(0.5,0.5, 0.5), 80, 0.25, 0, 0.25, 0.7,  e.getBlock().getType().createBlockData());

          if (e.getBlock().getType() == (Material.OAK_LOG) || e.getBlock().getType() == (Material.STONE)) {

               e.getBlock().getWorld().playSound(e.getPlayer(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 50 , 1.0F);

          }

          if(!e.getPlayer().hasPermission("zombs.bypass.blockbreak") || e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
               e.setCancelled(true);
          }
     }

     private Integer duration, resourceamount;
     private BukkitTask mining;

     @EventHandler
     public void onBlockDamage(BlockDamageEvent e) {
          duration = 90;
          resourceamount = 1;

          if (e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
               if (e.getBlock().getType().equals(Material.STONE) || e.getBlock().getType().equals(Material.OAK_LOG)) {
                    for (String name : Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name")) {
                         if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(name)) {

                              mining = new BukkitRunnable() {
                                   @Override
                                   public void run() {
                                        PacketPlayOutBlockBreakAnimation packet;
                                        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 2, 999));
                                        switch (duration) {
                                             case 0:
                                                  if (e.getBlock().getType().equals(Material.OAK_LOG)) {
                                                       Config.getInstance().WOOD.put(e.getPlayer().getName(), Config.getInstance().WOOD.get(e.getPlayer().getName()) + resourceamount);
                                                       e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§a + " + resourceamount +  " Wood"));
                                                  } else if (e.getBlock().getType().equals(Material.STONE)) {
                                                       Config.getInstance().STONE.put(e.getPlayer().getName(), Config.getInstance().STONE.get(e.getPlayer().getName()) + resourceamount);
                                                       e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§a + " + resourceamount +  " Stone"));

                                                  }
                                                  e.getPlayer().breakBlock(e.getBlock());
                                                  this.cancel();
                                             case 10:
                                                  packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 9);
                                                  ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
                                                  break;
                                             case 20:
                                                  packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 8);
                                                  ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
                                                  break;
                                             case 30:
                                                  packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 7);
                                                  ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);

                                             case 40:
                                                  packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 6);
                                                  ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
                                                  break;
                                             case 50:
                                                  packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 5);
                                                  ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);

                                             case 60:
                                                  packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 4);
                                                  ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
                                                  break;
                                             case 70:
                                                  packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 3);
                                                  ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
                                                  break;
                                             case 80:
                                                  packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 2);
                                                  ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
                                                  break;
                                             case 90:
                                                  packet = new PacketPlayOutBlockBreakAnimation(0, new BlockPosition(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ()), 1);
                                                  ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
                                                  break;
                                        }


                                        if (duration > 0) {
                                             duration--;
                                        } else {
                                             return;
                                        }

                                   }
                              }.runTaskTimer(Zombsio.plugin, 0, 1);


                         }
                    }
               } else {
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20*99, 999));
                    e.setCancelled(true);
               }
          } else {
               e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20*99, 999));
          }
          return;


     }

     @EventHandler
     public void onBlockDamageCancel(BlockDamageAbortEvent e) {
          PacketPlayOutBlockBreakAnimation packet = null;
          ((CraftPlayer) e.getPlayer()).getHandle().b.a(packet);
          e.getPlayer().removePotionEffect(PotionEffectType.SLOW_DIGGING);
          if (mining != null) {
               mining.cancel();
          }
     }

     @EventHandler
     public void onGamemodeChange(PlayerGameModeChangeEvent e) {
          if (e.getNewGameMode() == GameMode.SURVIVAL) {

               e.getPlayer().getInventory().clear();
               for (Integer i = 8; i <= 35; i++) {
                    e.getPlayer().getInventory().setItem(i,new ItemCreator(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setName(" ").getItem());
               }

               e.getPlayer().getInventory().setItem(0, new ItemCreator(Material.PRISMARINE_SHARD)
                       .setName(Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(0))
                       .setUnbreakable(true)
                       .addFlag(ItemFlag.HIDE_UNBREAKABLE)
                       .getItem());

               e.getPlayer().getInventory().setItem(7, new ItemCreator(Material.CRAFTING_TABLE).setName("Build Menu").getItem());
               e.getPlayer().getInventory().setItem(8, new ItemCreator(Material.ENDER_CHEST).setName("Shop").getItem());

          } else {
               e.getPlayer().getInventory().clear();
          }

     }

     @EventHandler
     public void onBlockPlace(BlockPlaceEvent e) {
          if(!e.getPlayer().hasPermission("zombs.bypass.blockplace") || e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
               e.setCancelled(true);
          }
     }

     @EventHandler
     public void onHungerTick(FoodLevelChangeEvent e) {
          if(!e.getEntity().hasPermission("zombs.bypass.foodlvlchange") || e.getEntity().getGameMode().equals(GameMode.SURVIVAL)) {
               e.setCancelled(true);
          }
     }

     @EventHandler
     public void onDrop(PlayerDropItemEvent e) {
          if(!e.getPlayer().hasPermission("zombs.bypass.dropitem") || e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
               e.setCancelled(true);
          }
     }

     @EventHandler
     public void onPickup(PlayerPickupItemEvent e) {
          if(!e.getPlayer().hasPermission("zombs.bypass.pickupitem") || e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
               e.setCancelled(true);
          }
     }

     @EventHandler
     public void onInventoryClick(InventoryClickEvent e) {
          if(!e.getView().getPlayer().hasPermission("zombs.bypass.inventoryclick") || e.getView().getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
               e.setCancelled(true);
          }
     }

     @EventHandler
     public void onDeath(PlayerDeathEvent e) {
          e.setKeepInventory(true);
     }
}
