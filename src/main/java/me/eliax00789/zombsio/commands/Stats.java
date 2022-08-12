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
                    sender.sendMessage( Integer.valueOf(args[3]) + " Health has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    new PlayerStatsSystem().removehealth(Bukkit.getPlayer(args[0]),Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Health has been removed");

                }
                else if (args[2].equalsIgnoreCase("set")) {
                    new PlayerStatsSystem().sethealth(Bukkit.getPlayer(args[0]), Integer.valueOf(args[3]));
                    sender.sendMessage("Health has been set to " + Integer.valueOf(args[3]));
                }
                else
                {
                    sender.sendMessage("Couldn't recognize operation");
                }
                return true;
            }
            else if (args[1].equalsIgnoreCase("maxhealth")) {
                if (args[2].equalsIgnoreCase("add")) {
                    new PlayerStatsSystem().addmaxhealth(Bukkit.getPlayer(args[0]),Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Maxhealth has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    new PlayerStatsSystem().removemaxhealth(Bukkit.getPlayer(args[0]),Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Maxhealth has been removed");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    new PlayerStatsSystem().setmaxhealth(Bukkit.getPlayer(args[0]),Integer.valueOf(args[3]));
                    sender.sendMessage( "MaxHealth has been set to " + Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("Couldn't recognize operation");
                }
                return true;
            }
            else if (args[1].equalsIgnoreCase("shield")) {
                if (args[2].equalsIgnoreCase("add")) {
                    new PlayerStatsSystem().addshield(Bukkit.getPlayer(args[0]),Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Shield has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    new PlayerStatsSystem().removeshield(Bukkit.getPlayer(args[0]),Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Shield has been removed");

                }
                else if (args[2].equalsIgnoreCase("set")) {
                    new PlayerStatsSystem().setshield(Bukkit.getPlayer(args[0]), Integer.valueOf(args[3]));
                    sender.sendMessage("Shield has been set to " + Integer.valueOf(args[3]));
                }
                else
                {
                    sender.sendMessage("Couldn't recognize operation");
                }
                return true;
            }
            else if (args[1].equalsIgnoreCase("maxshield")) {
                if (args[2].equalsIgnoreCase("add")) {
                    new PlayerStatsSystem().addmaxshield(Bukkit.getPlayer(args[0]),Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Maxshield has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    new PlayerStatsSystem().removemaxshield(Bukkit.getPlayer(args[0]),Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Maxshield has been removed");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    new PlayerStatsSystem().setmaxshield(Bukkit.getPlayer(args[0]),Integer.valueOf(args[3]));
                    sender.sendMessage( "Maxshield has been set to " + Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("Couldn't recognize operation");
                }
                return true;
            }
            else if (args[1].equalsIgnoreCase("defense")) {
                if (args[2].equalsIgnoreCase("add")) {
                    new PlayerStatsSystem().adddefense(Bukkit.getPlayer(args[0]),Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Defense has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    new PlayerStatsSystem().removedefense(Bukkit.getPlayer(args[0]),Integer.valueOf(args[3]));
                    sender.sendMessage( Integer.valueOf(args[3]) + " Defense has been removed");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    new PlayerStatsSystem().setdefense(Bukkit.getPlayer(args[0]),Integer.valueOf(args[3]));
                    sender.sendMessage( "Defense has been set to " + Integer.valueOf(args[3]));
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

