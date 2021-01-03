package fr.redwoub.titania.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peux executer cette command");
            return false;
        }

        Player player = (Player) sender;
        if(args.length == 0){
            player.sendMessage("§cLa command est : §e/gm 0 | 1 | 2 | 3");
            return false;
        }

        if(args[0].equalsIgnoreCase("0")){
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage("§aVotre mode de jeu a étais changer en mode survival");
        } else if(args[0].equalsIgnoreCase("1")){
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage("§aVotre mode de jeu a étais changer en mode creative");

        } else if(args[0].equalsIgnoreCase("2")){
            player.setGameMode(GameMode.ADVENTURE);
            player.sendMessage("§aVotre mode de jeu a étais changer en mode adventure");

        } else if(args[0].equalsIgnoreCase("3")){
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("§aVotre mode de jeu a étais changer en mode spectator");

        }

        return false;
    }
}
