package fr.redwoub.titania.database;

import fr.redwoub.titania.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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


    public Connection getConnection() {
        return connection;
    }
}
