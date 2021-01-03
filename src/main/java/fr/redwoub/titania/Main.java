package fr.redwoub.titania;

import fr.redwoub.titania.database.MySQL;
import fr.redwoub.titania.manager.RegisterManager;
import fr.redwoub.titania.rank.Accouts;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    private static Main instance;
    private MySQL mySQL = new MySQL();

    private List<Accouts> accouts;

    @Override
    public void onEnable(){
        instance = this;
        new RegisterManager().onRegister();
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

    public void createFile(String fileName){
        if(!getDataFolder().exists()){
            getDataFolder().mkdir();
        }

        File file = new File(getDataFolder(), fileName + ".yml");

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public File getFile(String fileName){
        return new File(getDataFolder(), fileName + ".yml");
    }
}
