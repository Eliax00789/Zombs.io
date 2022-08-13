package me.eliax00789.zombsio.commands;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.towers.ArrowTower;
import me.eliax00789.zombsio.entity.PlayerStats;
import me.eliax00789.zombsio.entity.PlayerStatsSystem;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
                sender.sendMessage("§cPlayer is not online");
                return true;
            }
            Player player = Bukkit.getPlayer(args[0]);

            if (!player.getGameMode().equals(GameMode.SURVIVAL)) {
                sender.sendMessage("§cYou can use this comand only in Survival Mode");
                return true;
            }

            Double[] stats = PlayerStats.stats.get(player);
            if (args[1].equalsIgnoreCase("health")) {
                if (args[2].equalsIgnoreCase("add")) {
                    if ((stats[0] + Double.valueOf(args[3])) < stats[1]) {
                        stats[0] = stats[0] + Double.valueOf(args[3]);
                        sender.sendMessage( "§a" + Integer.valueOf(args[3]) + " Health has been added");
                    } else sender.sendMessage( "§cYou can't add Health over your Max health");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    if ((stats[0] - Double.valueOf(args[3])) > 0) {
                        stats[0] = stats[0] - Double.valueOf(args[3]);
                        sender.sendMessage("§a" + Integer.valueOf(args[3]) + " Health has been removed");
                    } else sender.sendMessage( "§cYou can't remove Health under 0");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    if ((Double.valueOf(args[3])) > 0 && (Double.valueOf(args[3])) < stats[1]) {
                        stats[0] = Double.valueOf(args[3]);
                        sender.sendMessage("§aHealth has been set to " + Integer.valueOf(args[3]));
                    } else sender.sendMessage( "§cYou can't set Health over Max health or under 0");
                }
                else
                {
                    sender.sendMessage("§cCouldn't recognize operation");
                }
            }
            else if (args[1].equalsIgnoreCase("maxhealth")) {
                if (args[2].equalsIgnoreCase("add")) {
                    stats[1] = stats[1] + Double.valueOf(args[3]);
                    if (stats[0] > (stats[1] + Double.valueOf(args[3]))) {
                        stats[0] = Double.valueOf(args[3]);
                    }
                    sender.sendMessage( "§a" + Integer.valueOf(args[3]) + " Maxhealth has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    if (stats[1] + Double.valueOf(args[3]) > 0 ) {
                        stats[1] = stats[1] - Double.valueOf(args[3]);
                    }
                    if (stats[0] > (stats[1] - Double.valueOf(args[3]))) {
                        stats[0] = Double.valueOf(args[3]);
                    }
                    sender.sendMessage( "§a" + Integer.valueOf(args[3]) + " Maxhealth has been removed");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    stats[1] = Double.valueOf(args[3]);

                    if (stats[0] > Double.valueOf(args[3])) {
                        stats[0] = Double.valueOf(args[3]);
                    }
                    sender.sendMessage( "§aMaxHealth has been set to " + Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("§cCouldn't recognize operation");
                }
            }
            else if (args[1].equalsIgnoreCase("shield")) {
                if (args[2].equalsIgnoreCase("add")) {
                    stats[2] = stats[2] + Double.valueOf(args[3]);
                    sender.sendMessage( "§a" + Integer.valueOf(args[3]) + " Shield has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    stats[2] = stats[2] - Double.valueOf(args[3]);
                    sender.sendMessage( "§a" + Integer.valueOf(args[3]) + " Shield has been removed");

                }
                else if (args[2].equalsIgnoreCase("set")) {
                    stats[2] = Double.valueOf(args[3]);
                    sender.sendMessage("§aShield has been set to " + Integer.valueOf(args[3]));
                }
                else
                {
                    sender.sendMessage("§cCouldn't recognize operation");
                }
            }
            else if (args[1].equalsIgnoreCase("maxshield")) {
                if (args[2].equalsIgnoreCase("add")) {
                    stats[3] = stats[3] + Double.valueOf(args[3]);
                    sender.sendMessage( "§a" + Integer.valueOf(args[3]) + " Maxshield has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    stats[3] = stats[3] - Double.valueOf(args[3]);
                    sender.sendMessage( "§a" + Integer.valueOf(args[3]) + " Maxshield has been removed");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    stats[3] = Double.valueOf(args[3]);
                    sender.sendMessage( "§a" + "Maxshield has been set to " + Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("§cCouldn't recognize operation");
                }
            }
            else if (args[1].equalsIgnoreCase("defense")) {
                    if (args[2].equalsIgnoreCase("add")) {
                        if ((stats[2] + Double.valueOf(args[3])) < 1000) {
                        stats[4] = stats[4] + Double.valueOf(args[3]);
                        sender.sendMessage("§a" + Integer.valueOf(args[3]) + " Defense has been added");
                        }else sender.sendMessage( "§cYou can't add Defense over 1000");
                    }
                else if (args[2].equalsIgnoreCase("remove")) {
                    if ((stats[4] - Double.valueOf(args[3])) > -1) {
                        stats[4] = stats[4] - Double.valueOf(args[3]);
                        sender.sendMessage( "§a" + Integer.valueOf(args[3]) + " Defense has been removed");
                    }
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    if ((Double.valueOf(args[3])) < 1000 && (Double.valueOf(args[3])) > -1) {
                        stats[4] = Double.valueOf(args[3]);
                        sender.sendMessage("§aDefense has been set to " + Integer.valueOf(args[3]));
                    }else sender.sendMessage( "§cYou can't set Defense over 1000 or under 0");
                }
                else {
                    sender.sendMessage("§cCouldn't recognize operation");
                }
            }
            else {
                sender.sendMessage("§cCouldn't recognize resource type");
            }
            PlayerStats.stats.put(player,stats);
            PlayerStats.save();
            return true;
        }
        else {
            sender.sendMessage("§cYou do not have permission to execute this command");
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

