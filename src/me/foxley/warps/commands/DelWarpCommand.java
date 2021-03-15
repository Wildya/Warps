package me.foxley.warps.commands;

import me.foxley.warps.Warps;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DelWarpCommand implements TabExecutor {

    private Warps warps;

    public DelWarpCommand(Warps warps_) {
        this.warps = warps_;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length > 0 && sender instanceof Player) {
            Player player = (Player) sender;
            warps.delWarp(args[0]);
            player.sendMessage(ChatColor.GREEN + "Le warp " + ChatColor.DARK_GREEN + args[0] + ChatColor.GREEN + " a été supprimé");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {

        return new ArrayList<>(warps.getWarpsNames());
    }

}
