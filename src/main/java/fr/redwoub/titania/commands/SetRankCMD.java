package fr.redwoub.titania.commands;

import fr.redwoub.titania.rank.Accouts;
import fr.redwoub.titania.rank.RankUnit;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SetRankCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peux executer cette command");
            return false;
        }
        Player player = (Player) sender;
        if(args.length < 2){
            player.sendMessage("§cLa command est : §e/setrank <Pseudo du joueur> <rank>");
            return false;
        }

        if(Bukkit.getPlayer(args[0]) == null){
            player.sendMessage("§cCe joueur n'est pas connecter ou n'existe pas !");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        Accouts accouts = new Accouts(target);

        RankUnit rank = RankUnit.valueOf(args[1].toUpperCase());

        accouts.setRank(rank);
        player.sendMessage("§aVous avez bien changer le rank de " + target.getName() + " en : §e " + rank);
        return false;
    }
}
