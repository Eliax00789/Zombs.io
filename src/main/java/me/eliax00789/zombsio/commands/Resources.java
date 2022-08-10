package me.eliax00789.zombsio.commands;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Resources implements TabExecutor {

    public Resources() {
        Zombsio.plugin.getCommand("zresources").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("zombs.commands.zresources")) {
            if (args[1].equalsIgnoreCase("wood")) {
                if (args[2].equalsIgnoreCase("add")) {
                    Config.getInstance().WOOD.put(args[0], Config.getInstance().WOOD.get(args[0]) + Integer.valueOf(args[3]));
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    Config.getInstance().WOOD.put(args[0], Config.getInstance().WOOD.get(args[0]) - Integer.valueOf(args[3]));
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    Config.getInstance().WOOD.put(args[0], Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("Couldn't recognize operation");
                }
            }
            else if (args[1].equalsIgnoreCase("stone")) {
                if (args[2].equalsIgnoreCase("add")) {
                    Config.getInstance().STONE.put(args[0], Config.getInstance().STONE.get(args[0]) + Integer.valueOf(args[3]));
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    Config.getInstance().STONE.put(args[0], Config.getInstance().STONE.get(args[0]) - Integer.valueOf(args[3]));
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    Config.getInstance().STONE.put(args[0], Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("Couldn't recognize operation");
                }
            }
            else if (args[1].equalsIgnoreCase("gold")) {
                if (args[2].equalsIgnoreCase("add")) {
                    Config.getInstance().GOLD.put(args[0], Config.getInstance().GOLD.get(args[0]) + Integer.valueOf(args[3]));
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    Config.getInstance().GOLD.put(args[0], Config.getInstance().GOLD.get(args[0]) - Integer.valueOf(args[3]));
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    Config.getInstance().GOLD.put(args[0], Integer.valueOf(args[3]));
                }
                else {
                    sender.sendMessage("Couldn't recognize operation");
                }
            }
            else {
                sender.sendMessage("Couldn't recognize resource type");
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> toCompleteTo = new ArrayList<String>();
        if (args.length == 1) {
            for (Player p: Bukkit.getServer().getOnlinePlayers()) {
                if (p.getName().contains(args[0].toLowerCase())) {
                    toCompleteTo.add(p.getName());
                }
            }
        }
        if (args.length == 2) {
            for (String s: new ArrayList<String>(){{add("wood");add("stone");add("gold");}}) {
                if (s.contains(args[1].toLowerCase())) {
                    toCompleteTo.add(s);
                }
            }
        }
        if (args.length == 3) {
            for (String s: new ArrayList<String>(){{add("add");add("remove");add("set");}}) {
                if (s.contains(args[2].toLowerCase())) {
                    toCompleteTo.add(s);
                }
            }
        }
        if (args.length == 4) {
            for (String s: new ArrayList<String>(){{for (Integer i = 0;i < 100; i++) add(i.toString());}}) {
                if (s.contains(args[3].toLowerCase())) {
                    toCompleteTo.add(s);
                }
            }
        }
        return null;
    }
}
