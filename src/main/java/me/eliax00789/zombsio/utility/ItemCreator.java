package me.eliax00789.zombsio.utility;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public ItemCreator setPotion(PotionEffect potionEffect, Boolean overwrite) {
        ((PotionMeta) meta).addCustomEffect(potionEffect, overwrite);
        return this;
    }

    public ItemCreator setUnbreakable(Boolean unbreakable) {
        meta.setUnbreakable(unbreakable);
        return this;
    }

    public ItemCreator setLore(String... lore) {
        meta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemCreator addEnchant(Enchantment enchantment, Integer lvl, Boolean ignoreLvlRestriction) {
        meta.addEnchant(enchantment,lvl, ignoreLvlRestriction);

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
