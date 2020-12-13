package fr.redwoub.titania;

import fr.redwoub.titania.commands.Bc;
import fr.redwoub.titania.commands.Freeze;
import fr.redwoub.titania.commands.Invsee;
import fr.redwoub.titania.database.MySQL;
import fr.redwoub.titania.manager.PlayerManager;
import org.apache.commons.dbcp2.BasicDataSource;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private BasicDataSource connectionPool;
    private MySQL mySQL;


    @Override
    public void onEnable(){
        instance = this;
        initConnection();
        registerListener();
        registerCommand();
    }

    @Override
    public void onDisable(){

    }

    public static Main getInstance() {
        return instance;
    }

    private void registerListener(){

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerManager(), this);

    }

    public void registerCommand(){

        getCommand("bc").setExecutor(new Bc());
        getCommand("invsee").setExecutor(new Invsee());
        getCommand("freeze").setExecutor(new Freeze());
        getCommand("unfreeze").setExecutor(new Freeze());
    }

    private void initConnection(){
        connectionPool = new BasicDataSource();
        connectionPool.setDriverClassName("com.mysql.jdbc.Driver");
        connectionPool.setUsername("root");
        connectionPool.setPassword("");
        connectionPool.setUrl("jdbc:mysql://localhost:3306/titania?autoReconnect=true");
        connectionPool.setInitialSize(1);
        connectionPool.setMaxTotal(15);
    }

    public MySQL getmySQL(){
       return mySQL;
    }

}
