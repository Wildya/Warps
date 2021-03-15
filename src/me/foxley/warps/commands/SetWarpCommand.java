package me.foxley.warps.commands;

import me.foxley.warps.Warps;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarpCommand implements CommandExecutor {

    private Warps warps;

    public SetWarpCommand(Warps warps_) {
        this.warps = warps_;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length > 0 && sender instanceof Player) {
            Player player = (Player) sender;
            warps.setWarp(args[0], player.getLocation());
            player.sendMessage(ChatColor.GREEN + "Le warp " + ChatColor.DARK_GREEN + args[0] + ChatColor.GREEN + " a été placé");
            return true;
        } else {
            return false;
        }
    }

}