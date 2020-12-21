package fr.redwoub.titania;

import fr.redwoub.titania.commands.BcCMD;
import fr.redwoub.titania.commands.FreezeCMD;
import fr.redwoub.titania.commands.InvseeCMD;
import fr.redwoub.titania.database.MySQL;
import fr.redwoub.titania.database.Tables;
import fr.redwoub.titania.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    public MySQL mySQL = new MySQL();
    private Tables tables = new Tables();

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
        instance = this;
        registerListener();
        registerCommand();
        mySQL.connected("localhost", 3306, "titania", "root", "");
        tables.createTables();

    }

    @Override
    public void onDisable() {
        mySQL.disconnect();
    }

    public static Main getInstance() {
        return instance;
    }
}
