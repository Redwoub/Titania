package fr.redwoub.titania.rank;

import fr.redwoub.titania.Main;
import org.bukkit.entity.Player;

import java.sql.SQLException;


public class Accouts {

    private static final String TABLE = "player_info ";
    private Player player;
    private String uuid;

    public Accouts(Player player) {
        this.player = player;
        uuid = player.getUniqueId().toString();
    }

    public Player getPlayer() {
        return player;
    }

    public void setup(){
        Main.getInstance().getAccouts().add(this);
        Main.getInstance().getMySQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs ->{
            try {
                if(!rs.next()){
                    Main.getInstance().getMySQL().update("INSERT INTO " + TABLE + "(uuid, grade, coins) VALUES ('" + uuid + "', '" + RankUnit.JOUEUR.getName() + "', '1000')");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public void delete(){
        Main.getInstance().getAccouts().remove(this);
    }

}
