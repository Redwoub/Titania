package fr.redwoub.titania.commands;

import fr.redwoub.titania.utils.Freeze;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player target;

        if(!(sender instanceof Player)){
            sender.sendMessage("§cSeul un joueur peut executer cette commande");
            return false;
        }
        if(cmd.getName().equalsIgnoreCase("freeze")) {
            if (args.length == 0) {
                sender.sendMessage("§cla commande est : /freeze <Pseudo du joueur>");
                return false;
            }
            if (Bukkit.getPlayer(args[0]) == null) {
                sender.sendMessage("§cCe joueur n'est pas connecter ou n'existe pas");
                return false;
            }
            target = Bukkit.getPlayer(args[0]);
            Freeze.setFreeze(target, true);
            sender.sendMessage("§aTu a freeze : " + target.getName());
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("unfreeze")) {
            if (args.length == 0) {
                sender.sendMessage("§cla commande est : /unfreeze <Pseudo du joueur>");
                return false;
            }
            if (Bukkit.getPlayer(args[0]) == null) {
                sender.sendMessage("§cCe joueur n'est pas connecter ou n'existe pas");
                return false;
            }
            target = Bukkit.getPlayer(args[0]);
            Freeze.setFreeze(target, false);
            sender.sendMessage("§cTu a unfreeze : " + target.getName());
            return true;
        }
        return false;
    }

}
