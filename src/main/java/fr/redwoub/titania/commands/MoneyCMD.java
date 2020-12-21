package fr.redwoub.titania.commands;

import fr.redwoub.titania.rank.Accouts;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoneyCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){


        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peux executer cette command");
            return false;
        }

        Accouts accouts = new Accouts((Player) sender);

        if(args.length > 2 ){
            sender.sendMessage("§cLa commande est : /money");
            return false;
        }

        sender.sendMessage("§bVous avez actuellement : " + ChatColor.RED + accouts.getCoins() + " §b$");

        return false;
    }
}
