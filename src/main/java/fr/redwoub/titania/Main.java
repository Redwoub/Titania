package fr.redwoub.titania;

import fr.redwoub.titania.commands.BcCMD;
import fr.redwoub.titania.commands.FreezeCMD;
import fr.redwoub.titania.commands.InvseeCMD;
import fr.redwoub.titania.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private void registerListener(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerManager(), this);
    }

    private void registerCommand(){
        getCommand("bc").setExecutor(new BcCMD());
        getCommand("invsee").setExecutor(new InvseeCMD());
        getCommand("freeze").setExecutor(new FreezeCMD());
        getCommand("unfreeze").setExecutor(new FreezeCMD());
    }

    @Override
    public void onEnable(){
        registerListener();
        registerCommand();
    }
}
