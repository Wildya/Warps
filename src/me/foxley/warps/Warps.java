package me.foxley.warps;

import me.foxley.warps.commands.DelWarpCommand;
import me.foxley.warps.commands.SetWarpCommand;
import me.foxley.warps.commands.WarpCommand;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Warps extends JavaPlugin {

    private HashMap<String, Location> warps = new HashMap<>();

    @Override
    public void onEnable() {
        this.getCommand("warp").setExecutor(new WarpCommand(this));
        this.getCommand("setwarp").setExecutor(new SetWarpCommand(this));
        this.getCommand("delwarp").setExecutor(new DelWarpCommand(this));
    }

    public Location getWarp(String name) {
        return warps.get(name.toLowerCase());
    }

    public void setWarp(String name, Location location) {
        warps.put(name.toLowerCase(), location);
    }

    public void delWarp(String name) {
        warps.remove(name.toLowerCase());
    }

}
