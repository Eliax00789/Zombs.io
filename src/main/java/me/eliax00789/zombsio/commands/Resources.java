package me.eliax00789.zombsio.commands;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Resources implements TabExecutor {

    public Resources() {
        Zombsio.plugin.getCommand("zresources").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("zombs.commands.zresources")) {
            if (args.length != 4) {
                return false;
            }
            if (!Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
                sender.sendMessage("§cPlayer is not online");
                return true;
            }
            if (args[1].equalsIgnoreCase("wood")) {
                if (args[2].equalsIgnoreCase("add")) {
                    Config.getInstance().WOOD.put(args[0], Config.getInstance().WOOD.get(args[0]) + Integer.valueOf(args[3]));
                    sender.sendMessage( "§a" +Integer.valueOf(args[3]) + " Wood has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    if ((Config.getInstance().WOOD.get(args[0]) + Double.valueOf(args[3])) < 0) {
                        Config.getInstance().WOOD.put(args[0], Integer.valueOf(args[3]));
                        sender.sendMessage( "§aWood has been set to " + Integer.valueOf(args[3]));
                    } else sender.sendMessage( "§cYou can't remove Wood under 0");
                    Config.getInstance().WOOD.put(args[0], Config.getInstance().WOOD.get(args[0]) - Integer.valueOf(args[3]));
                    sender.sendMessage( "§a" +Integer.valueOf(args[3]) + " Wood has been removed");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    if ((Double.valueOf(args[3])) > -1) {
                        Config.getInstance().WOOD.put(args[0], Integer.valueOf(args[3]));
                        sender.sendMessage( "§aWood has been set to " + Integer.valueOf(args[3]));
                    } else sender.sendMessage( "§cYou can't set wood under 0");
                }
                else {
                    sender.sendMessage("§cCouldn't recognize operation");
                }
                return true;
            }
            else if (args[1].equalsIgnoreCase("stone")) {
                if (args[2].equalsIgnoreCase("add")) {
                    Config.getInstance().STONE.put(args[0], Config.getInstance().STONE.get(args[0]) + Integer.valueOf(args[3]));
                    sender.sendMessage( "§a" +Integer.valueOf(args[3]) + " Stone has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    if ((Config.getInstance().STONE.get(args[0]) - Double.valueOf(args[3])) < 0) {
                        Config.getInstance().STONE.put(args[0], Config.getInstance().STONE.get(args[0]) - Integer.valueOf(args[3]));
                        sender.sendMessage( "§a" +Integer.valueOf(args[3]) + " Stone has been removed");
                    } else sender.sendMessage( "§cYou can't remove Stone under 0");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    if ((Double.valueOf(args[3])) > -1) {
                        Config.getInstance().STONE.put(args[0], Integer.valueOf(args[3]));
                        sender.sendMessage( "§aStone has been set to " + Integer.valueOf(args[3]));
                    } else sender.sendMessage( "§cYou can't set Stone under 0");
                }
                else {
                    sender.sendMessage("§cCouldn't recognize operation");
                }
                return true;
            }
            else if (args[1].equalsIgnoreCase("gold")) {
                if (args[2].equalsIgnoreCase("add")) {
                    Config.getInstance().GOLD.put(args[0], Config.getInstance().GOLD.get(args[0]) + Integer.valueOf(args[3]));
                    sender.sendMessage( "§a" +Integer.valueOf(args[3]) + " Gold has been added");
                }
                else if (args[2].equalsIgnoreCase("remove")) {
                    if ((Config.getInstance().GOLD.get(args[0]) - Double.valueOf(args[3])) < 0) {
                        Config.getInstance().GOLD.put(args[0], Config.getInstance().GOLD.get(args[0]) - Integer.valueOf(args[3]));
                        sender.sendMessage( "§a" +Integer.valueOf(args[3]) + " Gold has been removed");
                    } else sender.sendMessage( "§cYou can't remove Gold under 0");
                }
                else if (args[2].equalsIgnoreCase("set")) {
                    if ((Double.valueOf(args[3])) > -1) {
                        Config.getInstance().GOLD.put(args[0], Integer.valueOf(args[3]));
                        sender.sendMessage( "§aGold has been set to " + Integer.valueOf(args[3]));
                    } else sender.sendMessage( "§cYou can't set Gold under 0");
                }
                else {
                    sender.sendMessage("§cCouldn't recognize operation");
                }
                return true;
            }
            else {
                sender.sendMessage("§cCouldn't recognize resource type");
            }
            return true;
        }
        else {
            sender.sendMessage("§cYou do not have permission to execute this command");
            return true;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> toCompleteTo = new ArrayList<String>();
        Collection<Player> playerlist = (Collection<Player>) Bukkit.getOnlinePlayers();
        ArrayList<String> resourcelist = new ArrayList<String>();
        resourcelist.add("wood");
        resourcelist.add("stone");
        resourcelist.add("gold");
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
            for (String s: resourcelist) {
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
