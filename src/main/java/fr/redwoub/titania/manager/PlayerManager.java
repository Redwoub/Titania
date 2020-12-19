package fr.redwoub.titania.manager;

import fr.redwoub.titania.Main;
import fr.redwoub.titania.tables.BlockBreak;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerManager implements Listener {

    private Main main = Main.getInstance();

    public int i = 0;

    @EventHandler
    public void onMoove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        if(Main.isFreeze.contains(p.getUniqueId())){
            p.teleport(p.getLocation());
            i++;
            if(i >= 20){
                p.sendMessage("§cTu a étais freeze !\n §cSi tu te déconnect tu sera §c§lbanni §ca vie !");
                i = 0;
            }
        }

    }
}
