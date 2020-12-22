package fr.redwoub.titania;

import fr.redwoub.titania.commands.*;
import fr.redwoub.titania.database.MySQL;
import fr.redwoub.titania.manager.PlayerManager;
import fr.redwoub.titania.manager.Register;
import fr.redwoub.titania.rank.Accouts;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    private static Main instance;
    private MySQL mySQL = new MySQL();
    public MenuCMD menuCMD = new MenuCMD();

    private List<Accouts> accouts;

    @Override
    public void onEnable(){
        instance = this;
        new Register().onRegister();
        mySQL.connected("localhost", 3306, "titania", "root", "");
        mySQL.createTables();
        accouts = new ArrayList<>();

    }

    @Override
    public void onDisable() {
        mySQL.disconnect();
    }

    public static Main getInstance() {
        return instance;
    }

    public MySQL getMySQL() {
        return mySQL;
    }

    public List<Accouts> getAccouts() {
        return accouts;
    }

    public Accouts getAccouts(Player player){
        return getAccouts().stream().filter(a -> a.getPlayer() == player).findFirst().get();
    }


}
