package fr.redwoub.titania.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private Connection connection;

    public void connected(String host, int port, String database, String user, String password){

        if(!isConnected()){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
                System.out.println("[Titania] connection avec la bdd etabli");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void disconnected(){
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
            if((connection == null) || (connection.isClosed()) || (connection.isValid(5))) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Connection getConnection() {
        return connection;
    }
}
