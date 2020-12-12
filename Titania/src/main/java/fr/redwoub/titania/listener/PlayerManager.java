package fr.redwoub.titania.listener;

import fr.redwoub.titania.commands.Freeze;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerManager implements Listener {

    @EventHandler
    public void onMoove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(Freeze.isFreeze == true){
            e.setCancelled(true);
            p.sendMessage("§cVous avez était freeze !");
        }
    }
}
