package fr.redwoub.titania.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player;
        Player target;

        if(!(sender instanceof Player)){
            sender.sendMessage("§cSeul un joueur peux executer cette commande");
            return false;
        }
        player = (Player) sender;
        if(args.length == 0){
            player.sendMessage("§cLa commande est : /invsee <Pseudo du joueur>");
            return false;
        }
        if(Bukkit.getPlayer(args[0]) == null){
            player.sendMessage("§cCe joueur n'est pas connecter ou n'existe pas");
            return false;
        }
        target = Bukkit.getPlayer(args[0]);
        player.openInventory(target.getInventory());
        return false;
    }
}
