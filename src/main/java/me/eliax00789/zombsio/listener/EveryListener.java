package me.eliax00789.zombsio.listener;

import me.eliax00789.zombsio.Zombsio;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class EveryListener implements Listener {

     public EveryListener() {
          Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
     }

     @EventHandler
     public void onBlockBreak(BlockBreakEvent e) {
          if(!e.getPlayer().hasPermission("zombs.bypass.blockbreak")) {
               e.setCancelled(true);
          }
     }

     @EventHandler
     public void onBlockPlace(BlockPlaceEvent e) {
          if(!e.getPlayer().hasPermission("zombs.bypass.blockplace")) {
               e.setCancelled(true);
          }
     }

     @EventHandler
     public void onHungerTick(FoodLevelChangeEvent e) {
          if(!e.getEntity().hasPermission("zombs.bypass.foodlvlchange")) {
               e.setCancelled(true);
          }
     }

     @EventHandler
     public void onDamage(EntityDamageEvent e) {
          if(!e.getEntity().hasPermission("zombs.bypass.damage")) {
               e.setCancelled(true);
          }
     }

     @EventHandler
     public void onDrop(PlayerDropItemEvent e) {
          if(!e.getPlayer().hasPermission("zombs.bypass.dropitem")) {
               e.setCancelled(true);
          }
     }

     @EventHandler
     public void onPickup(InventoryPickupItemEvent e) {
          for (HumanEntity i: e.getInventory().getViewers()) {
               if(!i.hasPermission("zombs.bypass.pickup")) {
                    e.setCancelled(true);
               }
          }
     }

     @EventHandler
     public void onInventory(InventoryMoveItemEvent e) {
          for (HumanEntity i: e.getSource().getViewers()) {
               if(!i.hasPermission("zombs.bypass.inventorymoveitem")) {
                    e.setCancelled(true);
               }
          }
     }

     @EventHandler
     public void onInventory(InventoryDragEvent e) {
          for (HumanEntity i: e.getViewers()) {
               if(!i.hasPermission("zombs.bypass.inventorymoveitem")) {
                    e.setCancelled(true);
               }
          }
     }



}
