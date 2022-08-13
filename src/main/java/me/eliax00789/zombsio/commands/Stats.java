package me.eliax00789.zombsio.commands;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.towers.ArrowTower;
import me.eliax00789.zombsio.entity.PlayerStats;
import me.eliax00789.zombsio.entity.PlayerStatsSystem;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Stats implements TabExecutor {

    public Stats() {
        Zombsio.plugin.getCommand("zstats").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("zombs.commands.zstats")) {
            if (args.length != 4) {
                return false;
            }
            if (!Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
                sender.sendMessage("Player is not online");
                return true;
            }
            Player player = Bukkit.getPlayer(args[0]);
            Double[] stats = PlayerStats.stats.get(player);
            if (args[1].equalsIgnoreCase("health")) {
                if (args[2].equalsIgnoreCase("add")) {
                    stats[0] = stats[0] + Double.valueOf(args[3]);
                    sender.sendMessage( Integer.valueOf(args[3]) + " Health has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    stats[0] = stats[0] - Double.valueOf(args[3]);
                    sender.sendMessage( Integer.valueOf(args[3]) + " Health has been removed");

                }
                else if (args[2].equalsIgnoreCase("set")) {
                    stats[0] = stats[0] + Double.valueOf(args[3]);
                    sender.sendMessage("Health has been set to " + Integer.valueOf(args[3]));
                }
                else
                {
                    sender.sendMessage("Couldn't recognize operation");
                }
            }
            else if (args[1].equalsIgnoreCase("maxhealth")) {
                if (args[2].equalsIgnoreCase("add")) {
                    stats[1] = stats[1] + Double.valueOf(args[3]);
                    sender.sendMessage( Integer.valueOf(args[3]) + " Maxhealth has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    stats[1] = stats[1] - Double.valueOf(args[3]);
                    sender.sendMessage( Integer.valueOf(args[3]) + " Maxhealth has been removed");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    stats[1] = Double.valueOf(args[3]);
                    sender.sendMessage( "MaxHealth has been set to " + Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("Couldn't recognize operation");
                }
            }
            else if (args[1].equalsIgnoreCase("shield")) {
                if (args[2].equalsIgnoreCase("add")) {
                    stats[2] = stats[2] + Double.valueOf(args[3]);
                    sender.sendMessage( Integer.valueOf(args[3]) + " Shield has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    stats[2] = stats[2] - Double.valueOf(args[3]);
                    sender.sendMessage( Integer.valueOf(args[3]) + " Shield has been removed");

                }
                else if (args[2].equalsIgnoreCase("set")) {
                    stats[2] = Double.valueOf(args[3]);
                    sender.sendMessage("Shield has been set to " + Integer.valueOf(args[3]));
                }
                else
                {
                    sender.sendMessage("Couldn't recognize operation");
                }
            }
            else if (args[1].equalsIgnoreCase("maxshield")) {
                if (args[2].equalsIgnoreCase("add")) {
                    stats[3] = stats[3] + Double.valueOf(args[3]);
                    sender.sendMessage( Integer.valueOf(args[3]) + " Maxshield has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    stats[3] = stats[3] - Double.valueOf(args[3]);
                    sender.sendMessage( Integer.valueOf(args[3]) + " Maxshield has been removed");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    stats[3] = Double.valueOf(args[3]);
                    sender.sendMessage( "Maxshield has been set to " + Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("Couldn't recognize operation");
                }
            }
            else if (args[1].equalsIgnoreCase("defense")) {
                if (args[2].equalsIgnoreCase("add")) {
                    stats[4] = stats[4] + Double.valueOf(args[3]);
                    sender.sendMessage( Integer.valueOf(args[3]) + " Defense has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    stats[4] = stats[4] - Double.valueOf(args[3]);
                    sender.sendMessage( Integer.valueOf(args[3]) + " Defense has been removed");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    stats[4] = Double.valueOf(args[3]);
                    sender.sendMessage( "Defense has been set to " + Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("Couldn't recognize operation");
                }
            }
            else {
                sender.sendMessage("Couldn't recognize resource type");
            }
            PlayerStats.stats.put(player,stats);
            PlayerStats.save();
            return true;
        }
        else {
            sender.sendMessage("You do not have permission to execute this command");
            return true;
        }

    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        List<String> toCompleteTo = new ArrayList<String>();
        Collection<Player> playerlist = (Collection<Player>) Bukkit.getOnlinePlayers();
        ArrayList<String> stattypes = new ArrayList<String>();
        stattypes.add("health");
        stattypes.add("maxhealth");
        stattypes.add("shield");
        stattypes.add("maxshield");
        stattypes.add("defense");
        ArrayList<String> optionlist = new ArrayList<String>();
        optionlist.add("add");
        optionlist.add("remove");
        optionlist.add("set");
        ArrayList<String> numberlist = new ArrayList<String>();
        for (Integer i = 0; i < 1000; i++) {
            numberlist.add(String.valueOf(i));
        }
        if (args.length == 1) {
            for (Player p:Bukkit.getOnlinePlayers()) {
                if (p.getName().contains(args[0].toLowerCase())) {
                    toCompleteTo.add(p.getName());
                }
            }
        }
        if (args.length == 2) {
            for (String s: stattypes) {
                if (s.contains(args[1].toLowerCase())) {
                    toCompleteTo.add(s);
                }
            }
        }
        if (args.length == 3) {
            for (String s: optionlist) {
                if (s.contains(args[2].toLowerCase())) {
                    toCompleteTo.add(s);
                }
            }
        }
        if (args.length == 4) {
            for (String s: numberlist) {
                if (s.contains(args[3].toLowerCase())) {
                    toCompleteTo.add(s);
                }
            }
        }
        return toCompleteTo;
    }

}

