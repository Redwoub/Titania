package fr.redwoub.titania.manager;


import fr.redwoub.titania.rank.Accouts;
import fr.redwoub.titania.rank.RankUnit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;


public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        Accouts accouts = new Accouts(player);
        accouts.setup();
        if(accouts.getRank().getPower() <= RankUnit.MODERATEUR.getPower()){
            e.setJoinMessage(accouts.getRank().getPrefix() + player.getName() + " §fvien de rejoindre le serveur");

        } else {
            e.setJoinMessage(ChatColor.GREEN + "+ " + ChatColor.WHITE + player.getName());
        }

        player.setFoodLevel(20);
        player.setHealth(20);

    }

    @EventHandler
    public void onLeft(PlayerQuitEvent e){
        Player player = e.getPlayer();
        Accouts accouts = new Accouts(player);

        if(accouts.getRank().getPower() <= RankUnit.MODERATEUR.getPower()){
            e.setQuitMessage(accouts.getRank().getPrefix() + player.getName() + " §fvien de quitter le serveur");
        } else {
            e.setQuitMessage(ChatColor.RED + "- " + ChatColor.WHITE + player.getName());
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Inventory inv = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if (current == null) return;

        if (inv.getName().equalsIgnoreCase("§7Sanctions pour ")) {

        }
    }

    public ItemStack getItem(Material material, String customName, List<String> lore) {

        ItemStack it = new ItemStack(material, 1);
        ItemMeta itM = it.getItemMeta();
        if (customName != null) itM.setDisplayName(customName);
        if (lore != null) itM.setLore(lore);
        it.setItemMeta(itM);
        return it;
    }
}
