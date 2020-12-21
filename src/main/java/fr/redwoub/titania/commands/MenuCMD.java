package fr.redwoub.titania.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class MenuCMD implements CommandExecutor {
    private Inventory inv;


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("seul un joueur peux executer cette command");
            return false;
        }
        Player player = (Player) sender;

        inv = Bukkit.createInventory(null, 54, "§6Menu");
        return false;
    }

}
