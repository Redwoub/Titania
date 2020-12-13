package fr.redwoub.titania.database;


import com.google.gson.internal.$Gson$Preconditions;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;

public class MySQL {
    private BasicDataSource connectionPool;

    public MySQL(BasicDataSource connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Connection getConnection() throws SQLException{
        return connectionPool.getConnection();
    }

    public void createTable(){
        update("CREATE TABLE IF NOT EXISTS breakblock (" +
                        "uuid VARCHAR(255), " +
                        "block BIGINT)");
    }

    public void update(String qry){
         try (Connection c = getConnection();
              PreparedStatement sts = c.prepareStatement(qry)){
             sts.executeUpdate();

         }catch(Exception e){
             e.printStackTrace();
         }
    }

    public Object query(String qry, Function<ResultSet, Object> consumer){
        try (Connection c = getConnection();
            PreparedStatement sts = c.prepareStatement(qry);
            ResultSet rs = sts.executeQuery()){
            return consumer.apply(rs);

        }catch (Exception e){
            throw new IllegalStateException(e.getMessage());
        }
    }

    public void query(String qry, Consumer<ResultSet> consumer){
        try (Connection c = getConnection();
             PreparedStatement sts = c.prepareStatement(qry);
             ResultSet rs = sts.executeQuery()){
            consumer.accept(rs);

        }catch (Exception e){
            throw new IllegalStateException(e.getMessage());
        }
    }
}
