package fr.redwoub.titania.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class FeedCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peux executer cette command");
            return false;
        }

        Player player = (Player) sender;
        player.setFoodLevel(20);
        player.sendMessage("§aVotre nourriture a était remis à son maximum");
        return false;
    }
}
