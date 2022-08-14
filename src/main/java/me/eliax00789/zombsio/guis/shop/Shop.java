package me.eliax00789.zombsio.guis.shop;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.utility.Config;
import me.eliax00789.zombsio.utility.ItemCreator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

public class Shop implements Listener {

    public Shop() {
        Zombsio.plugin.getServer().getPluginManager().registerEvents(this,Zombsio.plugin);
    }
    @EventHandler
    public void onEnderChestPlace(PlayerInteractEvent e) {
        if (e.getMaterial().equals(Material.ENDER_CHEST)) {
            if (Config.getInstance().LASTSHOPPAGE.get(e.getPlayer().getName()).equalsIgnoreCase("tools")) {
                e.getPlayer().openInventory(new ShopToolsInventory(e.getPlayer()).getInventory());
            }
            else if (Config.getInstance().LASTSHOPPAGE.get(e.getPlayer().getName()).equalsIgnoreCase("armor")) {
                e.getPlayer().openInventory(new ShopArmorInventory(e.getPlayer()).getInventory());
            }
            else if (Config.getInstance().LASTSHOPPAGE.get(e.getPlayer().getName()).equalsIgnoreCase("pets")) {
                e.getPlayer().openInventory(new ShopPetsInventory(e.getPlayer()).getInventory());
            }
            else if (Config.getInstance().LASTSHOPPAGE.get(e.getPlayer().getName()).equalsIgnoreCase("potions")) {
                e.getPlayer().openInventory(new ShopPotionsInventory(e.getPlayer()).getInventory());
            }
            else {
                e.getPlayer().sendMessage("something just went very wrong whilst trying to open the shop");
            }
            e.setCancelled(true);
        }
    }

    public void setItemPlayer(ItemStack itemStack, Integer slot, Inventory inventory, Integer gold, Player player) {
        if (Config.getInstance().GOLD.get(player.getName()) > gold) {
            Config.getInstance().GOLD.put(player.getName(), Config.getInstance().GOLD.get(player.getName()) - gold);
            player.getInventory().setItem(slot, itemStack);
            player.closeInventory();
            new Config().save();
        }

    }
}

