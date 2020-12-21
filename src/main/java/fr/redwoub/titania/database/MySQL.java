package fr.redwoub.titania.database;

import fr.redwoub.titania.Main;

import java.sql.*;
import java.util.function.Consumer;

public class MySQL {
    private Connection connection;

    public void connected(String host, int port, String database, String user, String password){
        if(!isConnected()){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
                Main.getInstance().getServer().getConsoleSender().sendMessage("§6[Titania] §aConnection etablie avec la bdd");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void disconnect(){
        if(isConnected()){
            try {
                Main.getInstance().getServer().getConsoleSender().sendMessage("§6[Titania] §cDeconnection avec la bdd...");
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected(){

        try {
            if((connection == null) || (connection.isClosed()) || (connection.isValid(5))){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public void update (String qry){
        try {
            PreparedStatement sts = connection.prepareStatement(qry);
            sts.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTables(){
        update("CREATE TABLES IF NOT EXISTS player_info (" +
                "uuid VARCHAR(255), " +
                "grade VARCHAR(255) ," +
                "coins BIGINT)");
    }

    public void query(String qry, Consumer<ResultSet> consumer){
        try (Connection c = getConnection();
             PreparedStatement s = c.prepareStatement(qry);
             ResultSet rs = s.executeQuery()) {
            consumer.accept(rs);
        } catch(SQLException e){
            throw new IllegalStateException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
