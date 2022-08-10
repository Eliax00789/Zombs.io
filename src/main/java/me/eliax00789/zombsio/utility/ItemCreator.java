package me.eliax00789.zombsio.utility;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {
    private ItemStack item;
    private ItemMeta meta;

    public ItemCreator(Material material) {
        item = new ItemStack(material);
        meta = item.getItemMeta();
    }

    public ItemCreator setAmount(Integer amount) {
        item.setAmount(amount);
        return this;
    }

    public ItemCreator setName(String name) {
        meta.setDisplayName(name);
        return this;
    }

    public ItemStack getItem() {
        item.setItemMeta(meta);
        return item;
    }
}
