package fr.redwoub.titania.commands;

import fr.redwoub.titania.rank.Accouts;
import fr.redwoub.titania.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class MenuCMD implements CommandExecutor, Listener {
    private Inventory inv;


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("seul un joueur peux executer cette command");
            return false;
        }
        Player player = (Player) sender;

        inv = Bukkit.createInventory(null, 54, "§6Menu");
        inv.setItem(53, new ItemBuilder(Material.BARRIER).setName("§cClose Menu").setLore("§7Left click to close this menu.").toItemStack());
        inv.setItem(0, new ItemBuilder(Material.IRON_INGOT).setName("§6Add 10$").toItemStack());

        player.openInventory(inv);
        return false;
    }

    @EventHandler
    public void onInterract(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        ItemStack current = e.getCurrentItem();
        Accouts accouts = new Accouts(player);

        switch (current.getType()){
            case IRON_INGOT:
                if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§6Add 10$")){
                    accouts.addCoins(10);
                    player.sendMessage("§aVotre compte a était créditer de 10$\n" + "§aFaite §e/money §apour votre nouveau solde");
                    e.setCancelled(true);
                }
                break;

            case BARRIER:
                if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§cClose Menu")){
                    e.setCancelled(true);
                    player.closeInventory();
                }
                break;
            default: break;
        }
    }

}
