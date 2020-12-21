package fr.redwoub.titania.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Tables {
    MySQL instance = new MySQL();


    public void createTables(){
        update("CREATE TABLES IF NOT EXISTS player_info(" +
                "uuid VARCHAR(255)," +
                "grade VARCHAR(255)," +
                "coins BIGINT)");
    }

    public void update (String qry){
        try (Connection c = instance.getConnection();
             PreparedStatement s = c.prepareStatement(qry)) {
            s.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
