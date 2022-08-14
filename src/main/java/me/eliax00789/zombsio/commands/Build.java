package me.eliax00789.zombsio.commands;

import me.eliax00789.zombsio.Zombsio;
import me.eliax00789.zombsio.buildings.other.Door;
import me.eliax00789.zombsio.buildings.other.SlowTrap;
import me.eliax00789.zombsio.buildings.other.Wall;
import me.eliax00789.zombsio.buildings.resources.GoldMine;
import me.eliax00789.zombsio.buildings.resources.GoldStash;
import me.eliax00789.zombsio.buildings.resources.ResourceHarvester;
import me.eliax00789.zombsio.buildings.towers.*;
import me.eliax00789.zombsio.utility.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Build implements TabExecutor {

    public Build() {
        Zombsio.plugin.getCommand("zbuild").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("zombs.commands.zbuild)")) {
            if (args.length != 2) {
                return false;
            }

            if (!(sender instanceof Player)) {
                sender.sendMessage("§cOnly a Player can use this command");
                return false;
            }
            Player player = (Player) sender;

            if (((Integer.parseInt(args[1])) > Zombsio.plugin.getConfig().getIntegerList("Buildings.Door.Health").toArray().length)
                    || (Integer.parseInt(args[1])) < 1) {
                player.sendMessage("§cThe Level can only be between 1 and 8");
            }
            switch (args[0]) {
                case "GoldStash":
                    new GoldStash(player, player.getLocation().getBlock().getLocation(), Integer.valueOf(args[1]));
                case "GoldMine":
                    new GoldMine(player, player.getLocation().getBlock().getLocation(), Integer.valueOf(args[1]));
                case "ResourceHarvester":
                    new ResourceHarvester(player, player.getLocation().getBlock().getLocation(), Integer.valueOf(args[1]));
                case "Wall":
                    new Wall(player, player.getLocation().getBlock().getLocation(), Integer.valueOf(args[1]));
                case "Door":
                    new Door(player, player.getLocation().getBlock().getLocation(), Integer.valueOf(args[1]));
                case "SlowTrap":
                    new SlowTrap(player, player.getLocation().getBlock().getLocation().subtract(0, 1, 0), Integer.valueOf(args[1]));
                case "ArrowTower":
                    new ArrowTower(player, player.getLocation().getBlock().getLocation(), Integer.valueOf(args[1]));
                case "BombTower":
                    new BombTower(player, player.getLocation().getBlock().getLocation(), Integer.valueOf(args[1]));
                case "CannonTower":
                    new CannonTower(player, player.getLocation().getBlock().getLocation(), Integer.valueOf(args[1]));
                case "MageTower":
                    new MageTower(player, player.getLocation().getBlock().getLocation(), Integer.valueOf(args[1]));
                case "MeleeTower":
                    new MeleeTower(player, player.getLocation().getBlock().getLocation(), Integer.valueOf(args[1]));
                default:
                    sender.sendMessage("§cCouldn't recognize building type");
            }

        }  else {
            sender.sendMessage("§cYou do not have permission to execute this command");
            return true;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> toCompleteTo = new ArrayList<String>();
        ArrayList<String> Buildings = new ArrayList<String>();
        Buildings.add("GoldStash");
        Buildings.add("GoldMine");
        Buildings.add("ResourceHarvester");
        Buildings.add("Wall");
        Buildings.add("Door");
        Buildings.add("SlowTrap");
        Buildings.add("ArrowTower");
        Buildings.add("BombTower");
        Buildings.add("CannonTower");
        Buildings.add("MageTower");
        Buildings.add("MeleeTower");
        ArrayList<String> numberlist = new ArrayList<String>();
        for (Integer i = 1; i < 9; i++) {
            numberlist.add(String.valueOf(i));
        }
        if (args.length == 1) {
            for (String s: Buildings) {
                if (s.contains(args[0].toLowerCase())) {
                    toCompleteTo.add(s);
                }
            }
        }
        if (args.length == 2) {
            for (String s: numberlist) {
                if (s.contains(args[1].toLowerCase())) {
                    toCompleteTo.add(s);
                }
            }
        }
        return toCompleteTo;
    }
}
