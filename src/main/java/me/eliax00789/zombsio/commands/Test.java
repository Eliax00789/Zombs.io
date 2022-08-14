package me.eliax00789.zombsio.commands;

import me.eliax00789.zombsio.Zombsio;
import net.minecraft.world.level.GeneratorAccess;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Openable;
import org.bukkit.block.data.type.TrapDoor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.craftbukkit.v1_19_R1.block.CraftBlock;
import org.bukkit.entity.Player;

import java.util.List;

public class Test implements TabExecutor {

    public Test() {
        Zombsio.plugin.getCommand("ztest").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;



            Block block = player.getLocation().subtract(0,1,0).getBlock();

            if (block.getType().equals(Material.IRON_TRAPDOOR)) {
                Openable openable = (Openable) block.getBlockData();
                openable.setOpen(true);
                block.setBlockData(openable);
            }


        }



        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
