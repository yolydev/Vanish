package at.plexnet.vanish.commands;

import at.plexnet.vanish.VanishManager;
import at.plexnet.vanish.VanishPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        VanishManager manager = VanishPlugin.getInstance().getVanishManager();

        if(!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to use the vanish command.");
        }
        if(args.length == 1) {
            Player player = Bukkit.getPlayer(args[0]);
            if(player == null) {
                sender.sendMessage("Spieler ist nicht online.");
                return true;
            }

            if(manager.isVanished(player)) {
                manager.setVanished(player, false);
                sender.sendMessage("Der Spieler "+ player.getName() + " ist jetzt nicht mehr unsichtbar.");
            } else {
                manager.setVanished(player, true);
                sender.sendMessage("Der Spieler "+ player.getName() + " ist jetzt unsichtbar.");
            }
            return true;

        } else if(sender instanceof Player) {
            Player player = (Player) sender;

            if(manager.isVanished(player)) {
                manager.setVanished(player, false);
                sender.sendMessage("Du bist jetzt nicht mehr unsichtbar.");
            } else {
                manager.setVanished(player, true);
                sender.sendMessage("Du bist jetzt unsichtbar.");
            }
        }

        return false;
    }
}
