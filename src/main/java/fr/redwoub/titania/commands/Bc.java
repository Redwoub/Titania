package fr.redwoub.titania.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Seul un joueur peut executer cette command");
            return false;
        }

        Player p = (Player) sender;

        if(args.length == 0){
            p.sendMessage(ChatColor.RED + "La commande est : /bc <message>");
            return false;
        }

        if(args.length >= 1){

            StringBuilder sb = new StringBuilder();
            for(String str : args){
                sb.append(str + " ");
            }
            Bukkit.broadcastMessage("§b[§4Annonce§b]§6 " + sb.toString());
        }

        return false;
    }
}
