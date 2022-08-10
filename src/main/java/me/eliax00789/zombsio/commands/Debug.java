package me.eliax00789.zombsio.commands;

import me.eliax00789.zombsio.Zombsio;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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

        // TODO: new Tower().build(player.getLocation(), ArrowTower.mk1);


        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }
}
