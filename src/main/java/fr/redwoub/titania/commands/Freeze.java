package fr.redwoub.titania.commands;

import fr.redwoub.titania.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Freeze implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {



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

            Player target = Bukkit.getPlayer(args[0]);

            Main.isFreeze.add(target.getUniqueId());
            sender.sendMessage("§aTu a freeze : " + target.getName());
        }

        if(cmd.getName().equalsIgnoreCase("unfreeze")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cSeul un joueur peut executer cette commande");
                return false;
            }

            if (args.length == 0) {
                sender.sendMessage("§cla commande est : /unfreeze <Pseudo du joueur>");
                return false;
            }
            if (Bukkit.getPlayer(args[0]) == null) {
                sender.sendMessage("§cCe joueur n'est pas connecter ou n'existe pas");
                return false;
            }

            Player target = Bukkit.getPlayer(args[0]);

            Main.isFreeze.remove(target.getUniqueId());
            sender.sendMessage("§cTu a unfreeze : " + target.getName());


        }
        return false;
    }

}
