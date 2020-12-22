package fr.redwoub.titania.manager;

import fr.redwoub.titania.Main;
import fr.redwoub.titania.rank.Accouts;
import fr.redwoub.titania.utils.Freeze;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerManager implements Listener {


    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();

        if (Freeze.isFreeze(player) && event.getFrom().distance(event.getTo()) > 0) {
            player.teleport(player.getLocation());
            player.sendMessage("§cTu a étais freeze !\n §cSi tu te déconnect tu sera §c§lbanni §ca vie !");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        Accouts accouts = new Accouts(player);
        accouts.setup();
        accouts.addCoins(10);
        ItemStack it = new ItemStack(Material.WOOD_PICKAXE);
        ItemMeta itm = it.getItemMeta();
        itm.spigot().setUnbreakable(true);
        it.setItemMeta(itm);
        player.getInventory().addItem(it);
    }
}
