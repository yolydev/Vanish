package at.plexnet.vanish.listener;

import at.plexnet.vanish.VanishManager;
import at.plexnet.vanish.VanishPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ConnectionsListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        VanishManager manager = VanishPlugin.getInstance().getVanishManager();
        manager.hideAll(event.getPlayer());
    }
}
