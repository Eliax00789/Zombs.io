package me.eliax00789.zombsio.guis.shop;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

class ShopPotionsInventory {
    public ShopPotionsInventory() {
        //TODO: THIS FUCKING SHIT
    }

    public Inventory getInventory() {
        return Bukkit.createInventory(null, 9 * 3, "Shop: Potions");
    }
}
