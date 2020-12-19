package fr.redwoub.titania;

import fr.redwoub.titania.commands.Bc;
import fr.redwoub.titania.commands.Freeze;
import fr.redwoub.titania.commands.Invsee;
import fr.redwoub.titania.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.UUID;

public class Main extends JavaPlugin {

    private static Main instance;
    public static ArrayList<UUID> isFreeze = new ArrayList<>();


    @Override
    public void onEnable(){
        instance = this;
        registerListener();
        registerCommand();
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
