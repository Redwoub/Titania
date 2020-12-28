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

    public static Accouts getAccount(Player player){
        return Main.getInstance().getAccouts().stream().filter(a -> a.getPlayer() == player).findFirst().get();
    }

    public RankUnit getRank(){
        return (RankUnit) Main.getInstance().getMySQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(rs.next()){
                    return RankUnit.getByName(rs.getString("grade"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return RankUnit.JOUEUR;
        });
    }

    public void setRank(RankUnit rankUnit){
        Main.getInstance().getMySQL().update("UPDATE " +  TABLE + " SET grade='" + rankUnit + "' WHERE uuid='" + uuid + "'");
    }

    public void delete(){
        Main.getInstance().getAccouts().remove(this);
    }

    public long getCoins(){
        return (long) Main.getInstance().getMySQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", resultSet -> {
            try {
                if(resultSet.next()){
                    return resultSet.getLong("coins");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        });
    }

    public void setCoins(long coins){
        Main.getInstance().getMySQL().update("UPDATE " +  TABLE + " SET coins='" + coins + "' WHERE uuid='" + uuid + "'");
    }

    public void addCoins(long coins){
        setCoins(getCoins() + coins);
    }

    public void removeCoins(long coins){
        setCoins(getCoins() < coins ? 0 : getCoins() - coins);
    }

}
