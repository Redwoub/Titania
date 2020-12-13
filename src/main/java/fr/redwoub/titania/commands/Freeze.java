package fr.redwoub.titania.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Freeze implements CommandExecutor {

    public static boolean isFreeze = false;
    public static Player ta;

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
            String t = args[0];
            if (Bukkit.getPlayer(t) == null) {
                sender.sendMessage("§cCe joueur n'est pas connecter ou n'existe pas");
                return false;
            }

            ta = Bukkit.getPlayer(t);

            isFreeze = true;
        }

        if(cmd.getName().equalsIgnoreCase("unfreeze")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cSeul un joueur peut executer cette commande");
                return false;
            }

            if (args.length == 0) {
                sender.sendMessage("§cla commande est : /freeze <Pseudo du joueur>");
                return false;
            }
            String t = args[0];
            if (Bukkit.getPlayer(t) == null) {
                sender.sendMessage("§cCe joueur n'est pas connecter ou n'existe pas");
                return false;
            }
            ta = Bukkit.getPlayer(t);

            isFreeze = false;
        }
        return false;
    }

}
