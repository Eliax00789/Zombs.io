package me.eliax00789.zombsio.commands;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.towers.ArrowTower;
import me.eliax00789.zombsio.entity.PlayerStatsSystem;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.List;

public class Stats implements TabExecutor {

    public Stats() {
        Zombsio.plugin.getCommand("zdebug").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("zombs.commands.zresources")) {
            if (args.length != 4) {
                return false;
            }
            if (!Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
                sender.sendMessage("Player is not online");
                return true;
            }
            if (args[1].equalsIgnoreCase("health")) {
                if (args[2].equalsIgnoreCase("add")) {
                    new PlayerStatsSystem().addhealth(Integer.valueOf(args[3])
                    sender.sendMessage( Integer.valueOf(args[3]) + " Wood has been added");
                }
                else if (args[2].equalsIgnoreCase("set")) {

                    sender.sendMessage( Integer.valueOf(args[3]) + " Wood has been removed");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    sender.sendMessage( "Wood has been set to " + Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("Couldn't recognize operation");
                }
                return true;
            }
            else if (args[1].equalsIgnoreCase("stone")) {
                if (args[2].equalsIgnoreCase("add")) {
                    Config.getInstance().STONE.put(args[0], Config.getInstance().STONE.get(args[0]) + Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Stone has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    Config.getInstance().STONE.put(args[0], Config.getInstance().STONE.get(args[0]) - Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Stone has been removed");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    Config.getInstance().STONE.put(args[0], Integer.valueOf(args[3]));
                    sender.sendMessage( "Stone has been set to " + Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("Couldn't recognize operation");
                }
                return true;
            }
            else if (args[1].equalsIgnoreCase("gold")) {
                if (args[2].equalsIgnoreCase("add")) {
                    Config.getInstance().GOLD.put(args[0], Config.getInstance().GOLD.get(args[0]) + Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Gold has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    Config.getInstance().GOLD.put(args[0], Config.getInstance().GOLD.get(args[0]) - Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Gold has been removed");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    Config.getInstance().GOLD.put(args[0], Integer.valueOf(args[3]));
                    sender.sendMessage( "Gold has been set to " + Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("Couldn't recognize operation");
                }
                return true;
            }
            else {
                sender.sendMessage("Couldn't recognize resource type");
            }
            return true;
        }
        else {
            sender.sendMessage("You do not have permission to execute this command");
            return true;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }
}
