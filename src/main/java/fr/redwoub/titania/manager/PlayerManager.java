package fr.redwoub.titania.manager;

import fr.redwoub.titania.rank.Accouts;
import fr.redwoub.titania.rank.RankUnit;
import fr.redwoub.titania.utils.Freeze;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

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
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        RankUnit rankUnit = Accouts.getAccount(player).getRank();

        e.setFormat(rankUnit.getPrefix() + "%1$s §7> " + (rankUnit == RankUnit.JOUEUR ? "§7" : "§f") + "%2$s");
    }
}
