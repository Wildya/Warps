package me.foxley.warps.commands;

import me.foxley.warps.Warps;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class WarpCommand implements TabExecutor {

    private Warps warps;

    public WarpCommand(Warps warps_) {
        this.warps = warps_;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length > 0 && sender instanceof Player) {
            Player player = (Player) sender;

            Location location = warps.getWarp(args[0]);
            if (location != null) {
                player.teleport(location);
                player.sendMessage(ChatColor.GREEN + "Vous avez été téléporté au warp " + ChatColor.DARK_GREEN + args[0]);
            } else {
                player.sendMessage(ChatColor.RED + "Ce warp n'existe pas");
            }
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