package fr.redwoub.titania.manager;


import fr.redwoub.titania.rank.Accouts;
import fr.redwoub.titania.rank.RankUnit;
import fr.redwoub.titania.utils.Freeze;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class PlayerManager implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();

        if (Freeze.isFreeze(player) && event.getFrom().distance(event.getTo()) > 0) {
            player.teleport(player.getLocation());
            player.sendMessage("§cTu a étais freeze !\n §cSi tu te déconnect tu sera §4§lbanni §ca vie !");
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        RankUnit rankUnit = Accouts.getAccount(player).getRank();

        event.setFormat(rankUnit.getPrefix() + "%1$s §7> " + (rankUnit == RankUnit.JOUEUR ? "§7" : "§f") + "%2$s");
    }
}




