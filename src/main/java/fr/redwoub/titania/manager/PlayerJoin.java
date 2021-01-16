package fr.redwoub.titania.manager;


import fr.redwoub.titania.rank.Accouts;
import fr.redwoub.titania.rank.RankUnit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;



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

}
