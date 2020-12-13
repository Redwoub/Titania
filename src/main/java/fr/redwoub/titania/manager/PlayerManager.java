package fr.redwoub.titania.manager;

import fr.redwoub.titania.Main;
import fr.redwoub.titania.commands.Freeze;
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

        if(p == Freeze.target){
            if(Freeze.isFreeze == true){
                i++;
                p.teleport(p.getLocation());
            }
            if(i >= 15){
                p.sendMessage("§cTu a étais freeze !\n §cSi tu te déconnect tu sera §c§lbanni §ca vie !");
                i = 0;
            }

        }

    }




}
