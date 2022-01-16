package at.plexnet.vanish;

import at.plexnet.vanish.commands.VanishCommand;
import at.plexnet.vanish.listener.ConnectionsListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class VanishPlugin extends JavaPlugin {
    private static VanishPlugin instance;
    private VanishManager vanishManager;

    @Override
    public void onEnable() {
        instance = this;
        this.vanishManager = new VanishManager(this);
        commands();
        listeners();
    }

    @Override
    public void onDisable() {

    }

    public static VanishPlugin getInstance() {
        return instance;
    }

    public VanishManager getVanishManager() {
        return vanishManager;
    }

    public void commands() {
        getCommand("vanish").setExecutor(new VanishCommand());
    }

    public void listeners() {
        Bukkit.getPluginManager().registerEvents(new ConnectionsListener(), this);
    }
}
