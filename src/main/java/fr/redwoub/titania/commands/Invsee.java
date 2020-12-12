package fr.redwoub.titania.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Invsee implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("§cSeul un joueur peux executer cette commande");
            return false;
        }

        Player p = (Player) sender;

        if(args.length == 0){
            p.sendMessage("§cLa commande est : /invsee <Pseudo du joueur>");
            return false;
        }

        if(Bukkit.getPlayer(args[0]) == null){
            p.sendMessage("§cCe joueur n'est pas connecter ou n'existe pas");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);
        p.openInventory(target.getInventory());

        return false;
    }
}
