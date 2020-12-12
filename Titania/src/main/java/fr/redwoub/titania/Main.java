package fr.redwoub.titania;

import fr.redwoub.titania.commands.Bc;
import fr.redwoub.titania.commands.Freeze;
import fr.redwoub.titania.commands.Invsee;
import fr.redwoub.titania.listener.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private BasicDataSource connectionPool;


    @Override
    public void onEnable(){
        instance = this;
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
}
