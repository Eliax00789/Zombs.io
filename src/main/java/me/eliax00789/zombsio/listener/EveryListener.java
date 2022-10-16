package me.eliax00789.zombsio.listener;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.entity.PlayerStats;
import me.eliax00789.zombsio.utility.Config;
import me.eliax00789.zombsio.utility.ItemCreator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.core.BlockPosition;
import net.minecraft.network.protocol.game.PacketPlayOutBlockBreakAnimation;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class EveryListener implements Listener {

     public EveryListener() {
          Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
     }

     @EventHandler
     public void onBlockBreak(BlockBreakEvent e) {
          if(!e.getPlayer().hasPermission("zombs.bypass.blockbreak") || e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
               e.setCancelled(true);
          }
     }

     @EventHandler
     public void onGamemodeChange(PlayerGameModeChangeEvent e) {
          if (e.getNewGameMode() == GameMode.SURVIVAL) {

               e.getPlayer().getInventory().clear();
               for (Integer i = 8; i <= 35; i++) {
                    e.getPlayer().getInventory().setItem(i,new ItemCreator(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setName(" ").getItem());
               }

               e.getPlayer().getInventory().setItem(0,new ItemCreator(Material.WOODEN_AXE)
                       .setName("§7" + Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(0))
                       .setLore("§7Damage: " + (Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Damage").get(0))
                               , "§7Resource Amount: " + (Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Harvest").get(0))
                               , "§7Attackspeed: " + (Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Attackspeed").get(0)))
                       .setUnbreakable(true)
                       .addFlag(ItemFlag.HIDE_UNBREAKABLE)
                       .getItem());
               e.getPlayer().getInventory().setItem(1,new ItemCreator(Material.WOODEN_SWORD)
                       .setName("§7" + Zombsio.plugin.getConfig().getStringList("Items.Spear.Name").get(0))
                       .setLore("§7Damage: " + (Zombsio.plugin.getConfig().getStringList("Items.Spear.Damage").get(0))
                               , "§7Range: " + (Zombsio.plugin.getConfig().getStringList("Items.Spear.Range").get(0))
                               , "§7Attackspeed: " + (Zombsio.plugin.getConfig().getStringList("Items.Spear.Attackspeed").get(0)))
                       .setUnbreakable(true)
                       .addFlag(ItemFlag.HIDE_UNBREAKABLE)
                       .getItem());
               e.getPlayer().getInventory().setItem(2, new ItemCreator(Material.BOW)
                       .setName("§7" + Zombsio.plugin.getConfig().getStringList("Items.Bow.Name").get(0))
                       .setLore("§7Damage: " + (Zombsio.plugin.getConfig().getStringList("Items.Bow.Damage").get(0))
                               , "§7Attackspeed: " + (Zombsio.plugin.getConfig().getStringList("Items.Bow.Attackspeed").get(0)))
                       .setUnbreakable(true)
                       .addFlag(ItemFlag.HIDE_UNBREAKABLE)
                       .getItem());
               e.getPlayer().getInventory().setItem(3, new ItemCreator(Material.FIRE_CHARGE)
                       .setName("§7" + Zombsio.plugin.getConfig().getStringList("Items.Bomb.Name").get(0))
                       .setLore("§7Damage: " + (Zombsio.plugin.getConfig().getStringList("Items.Bomb.Damage").get(0))
                               , "§7Range: " + (Zombsio.plugin.getConfig().getStringList("Items.Bomb.Range").get(0))
                               , "§7Attackspeed: " + (Zombsio.plugin.getConfig().getStringList("Items.Bomb.Attackspeed").get(0)))
                       .setUnbreakable(true)
                       .addFlag(ItemFlag.HIDE_UNBREAKABLE)
                       .getItem());

               e.getPlayer().getInventory().setItem(7, new ItemCreator(Material.CRAFTING_TABLE).setName("Build Menu").getItem());
               e.getPlayer().getInventory().setItem(8, new ItemCreator(Material.ENDER_CHEST).setName("Shop").getItem());
               e.getPlayer().getInventory().setItem(9, new ItemCreator(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setName(Zombsio.plugin.getConfig().getStringList("Items.Shield.Name").get(0)).getItem());

          } else if(e.getNewGameMode() == GameMode.ADVENTURE) {
               e.setCancelled(true);
          } else {
               //e.getPlayer().getInventory().clear();
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
          if(!e.getEntity().hasPermission("zombs.bypass.dropitem") || e.getEntity().getGameMode().equals(GameMode.SURVIVAL)) {
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
     public void onMove(PlayerMoveEvent e) {
          Double[] stats = PlayerStats.stats.get(e.getPlayer());
          for (int i = e.getPlayer().getWorld().getMinHeight(); i < e.getPlayer().getWorld().getMaxHeight(); i++) {
               if (e.getPlayer().getLocation().subtract( 0, i,0).getBlock().getType().equals(Material.WATER)) {
                    if (e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
                         if (PlayerStats.stats.get(e.getPlayer())[2] > 0) {
                              e.getPlayer().damage(stats[2]);
                         }
                         new BukkitRunnable() {
                              @Override
                              public void run() {
                                   if (PlayerStats.stats.get(e.getPlayer())[0] > 0) {
                                        e.getPlayer().damage(stats[1]/2);
                                   }

                                   new BukkitRunnable() {

                                        @Override
                                        public void run() {
                                             e.getPlayer().damage(stats[1]/2);
                                        }
                                   }.runTaskLater(Zombsio.plugin, 11);
                              }
                         }.runTaskLater(Zombsio.plugin, 11);
                    }
               }
          }

     }

     private HashMap<Player, Integer> bowcount, bombcount;

     @EventHandler
     public void onItemSpawn(ItemSpawnEvent e) {
          e.setCancelled(true);
     }


     @EventHandler
     public void onEntitySpawn(EntitySpawnEvent e) {
          e.setCancelled(true);
     }


     @EventHandler
     public void onRightClickAir(PlayerInteractEvent e) {
          if (e.getAction().equals(Action.RIGHT_CLICK_AIR) && e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BOW)) {
            new BukkitRunnable() {
                    @Override
                    public void run() {
                         if (bowcount == null) {
                              bowcount = new HashMap<>();
                         }

                         if (bowcount.get(e.getPlayer()) == null) {
                              bowcount.put(e.getPlayer(), 20/Zombsio.plugin.getConfig().getIntegerList("Items.Bow.Attackspeed").get(Integer.parseInt(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-71));
                         }
                         if (bowcount.get(e.getPlayer()) < 0) {
                              e.getPlayer().getWorld().spawnArrow(e.getPlayer().getEyeLocation().add(e.getPlayer().getLocation().getDirection().multiply(2)),e.getPlayer().getLocation().getDirection(),4, 0);
                              this.cancel();
                         }
                         bowcount.put(e.getPlayer(), bowcount.get(e.getPlayer()) - 1);
                    }
               }.runTaskTimer(Zombsio.plugin, 0 , 1);
               e.setCancelled(true);
         }

          if (e.getAction().equals(Action.RIGHT_CLICK_AIR) && e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.FIRE_CHARGE)) {
               new BukkitRunnable() {
                    @Override
                    public void run() {
                         if (bombcount == null) {
                              bombcount = new HashMap<>();
                         }

                         if (bombcount.get(e.getPlayer()) == null) {
                              bombcount.put(e.getPlayer(), 20/Zombsio.plugin.getConfig().getIntegerList("Items.Bomb.Attackspeed").get(Integer.parseInt(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().replaceAll("[^0-9]+", ""))-71));
                         }
                         if (bombcount.get(e.getPlayer()) < 0) {
                              e.getPlayer().getWorld().spawnEntity(e.getPlayer().getEyeLocation().add(e.getPlayer().getLocation().getDirection().multiply(2)), EntityType.FIREBALL);
                              this.cancel();
                         }
                         bombcount.put(e.getPlayer(), bombcount.get(e.getPlayer()) - 1);
                    }
               }.runTaskTimer(Zombsio.plugin, 0 , 1);
               e.setCancelled(true);


          }
     }
}
