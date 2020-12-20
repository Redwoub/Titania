package fr.redwoub.titania.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BcCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player;
        StringBuilder stringBuilder;

        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Seul un joueur peut executer cette command");
            return false;
        }
        player = (Player) sender;
        if(args.length == 0){
            player.sendMessage(ChatColor.RED + "La commande est : /bc <message>");
            return false;
        }
        stringBuilder = new StringBuilder();
        for(String str : args){
            stringBuilder.append(str);
            stringBuilder.append(' ');
        }
        Bukkit.broadcastMessage("§b[§4Annonce§b]§6 " + stringBuilder.toString());
        return false;
    }
}
