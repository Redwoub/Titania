package fr.redwoub.titania.manager;

import fr.redwoub.titania.utils.Freeze;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerManager implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();

        if (Freeze.isFreeze(player) && event.getFrom().distance(event.getTo()) > 0) {
            event.setCancelled(true);
            player.sendMessage("§cTu a étais freeze !\n §cSi tu te déconnect tu sera §c§lbanni §ca vie !");
        }
    }
}
