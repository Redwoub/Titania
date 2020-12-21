package fr.redwoub.titania.commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peux executer cette command");
            return false;
        }
        int pls = 0;
        for(Player player : Bukkit.getOnlinePlayers()){
            pls++;
        }
        sender.sendMessage("§6Titania §f» §a" + pls + " joueurs en ligne");
        return false;
    }
}
