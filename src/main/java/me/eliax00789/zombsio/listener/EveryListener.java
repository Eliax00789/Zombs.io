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
import org.bukkit.event.player.PlayerInteractEvent;
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

               e.getPlayer().getInventory().setItem(0, new ItemCreator(Material.WOODEN_AXE)
                       .setName(Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name").get(0))
                       .setUnbreakable(true)
                       .addFlag(ItemFlag.HIDE_UNBREAKABLE)
                       .getItem());
               e.getPlayer().getInventory().setItem(1, new ItemCreator(Material.WOODEN_SWORD)
                       .setName(Zombsio.plugin.getConfig().getStringList("Items.Spear.Name").get(0))
                       .setUnbreakable(true)
                       .addFlag(ItemFlag.HIDE_UNBREAKABLE)
                       .getItem());
               e.getPlayer().getInventory().setItem(2, new ItemCreator(Material.BOW)
                       .setName(Zombsio.plugin.getConfig().getStringList("Items.Bow.Name").get(0))
                       .setUnbreakable(true)
                       .addFlag(ItemFlag.HIDE_UNBREAKABLE)
                       .getItem());
               e.getPlayer().getInventory().setItem(3, new ItemCreator(Material.FIRE_CHARGE)
                       .setName(Zombsio.plugin.getConfig().getStringList("Items.Bomb.Name").get(0))
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
     public void onRightClickAir(PlayerInteractEvent e) {
          if (e.getAction().equals(Action.RIGHT_CLICK_AIR) && e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BOW)) {
               e.getPlayer().getWorld().spawnArrow(e.getPlayer().getEyeLocation().add(e.getPlayer().getLocation().getDirection().multiply(2)),e.getPlayer().getLocation().getDirection(),4, 0);

          }
     }

}
