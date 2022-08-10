package me.eliax00789.zombsio.commands;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.towers.ArrowTower;
import me.eliax00789.zombsio.buildings.towers.Tower;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.List;

public class Debug implements TabExecutor {

    public Debug() {
        Zombsio.plugin.getCommand("zdebug").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;

        new Tower().build(player.getLocation(), ArrowTower.mk1);


        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }
}
