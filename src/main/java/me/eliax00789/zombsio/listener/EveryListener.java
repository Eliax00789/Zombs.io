package me.eliax00789.zombsio.listener;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.utility.Config;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.BlockChangeDelegate;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EveryListener implements Listener {

     public EveryListener() {
          Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
     }

     @EventHandler
     public void onBlockBreak(BlockBreakEvent e) {
          if (e.getPlayer().getInventory().getItemInMainHand().equals(null)) {
               e.setCancelled(true);
               return;
          }

          if (e.getBlock().getType().equals(Material.OAK_LOG)
                  && e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {

               for (String name: Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name") ) {
                    if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(name)) {

                         Config.getInstance().WOOD.put(e.getPlayer().getName(), Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest").get( name.charAt(name.length() - 1)));
                         e.setCancelled(true);
                    }
               }
          }

          if (e.getBlock().getType().equals(Material.STONE)
                  && e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {

               for (String name: Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name") ) {
                    if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(name)) {
                         Config.getInstance().STONE.put(e.getPlayer().getName(), Zombsio.plugin.getConfig().getIntegerList("Items.Pickaxe.Harvest").get( name.charAt(name.length() - 1)));
                         e.setCancelled(true);
                    }
               }
          }


          if(!e.getPlayer().hasPermission("zombs.bypass.blockbreak") || e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
               e.setCancelled(true);
          }

     }

     @EventHandler
     public void onBlockDamage(BlockDamageEvent e) {
          e.setCancelled(true);

          if (e.getPlayer().getInventory().getItemInMainHand().equals(null)){
               e.setCancelled(true);
               return;
          }

          if (e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
               if (e.getBlock().getType().equals(Material.STONE)) {

                    for (String name: Zombsio.plugin.getConfig().getStringList("Items.Pickaxe.Name") ) {
                         if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(name)) {
                              e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 4, 10));
                         }
                    }

               }
          }


     }

     @EventHandler
     public void onBlockDamageCancel(BlockDamageAbortEvent e) {
          e.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);

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

               e.getPlayer().getInventory().setItem(7, new ItemCreator(Material.CRAFTING_TABLE).setName("Build Menu").getItem());
               e.getPlayer().getInventory().setItem(8, new ItemCreator(Material.ENDER_CHEST).setName("Shop").getItem());

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
     public void onDamage(EntityDamageEvent e) {
          if (!(e.getEntity() instanceof Player)) {
               return;
          }

          if(!e.getEntity().hasPermission("zombs.bypass.damage")){
               e.setCancelled(true);
          }

          if(e.getEntity() instanceof Player) {
               Player player = (Player) e.getEntity();

               if(player.getGameMode().equals(GameMode.SURVIVAL)) {
                    e.setCancelled(true);
               }
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
