package fr.redwoub.titania;

import fr.redwoub.titania.commands.Bc;
import fr.redwoub.titania.commands.Freeze;
import fr.redwoub.titania.commands.Invsee;
import fr.redwoub.titania.database.MySQL;
import fr.redwoub.titania.listener.PlayerManager;
import org.apache.commons.dbcp2.BasicDataSource;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.security.PrivateKey;

public class Main extends JavaPlugin {

    private static Main instance;
    public MySQL mySQL = new MySQL();


    @Override
    public void onEnable(){
        instance = this;
        mySQL.connected("localhost", 3306, "titania", "root", "");
        registerListener();
        registerCommand();
    }

    @Override
    public void onDisable(){
        mySQL.disconnected();
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

}
