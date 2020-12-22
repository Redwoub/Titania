package fr.redwoub.titania.manager;

import fr.redwoub.titania.Main;
import fr.redwoub.titania.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class RegisterManager {
    private Main main = Main.getInstance();
    public void onRegister(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerManager(), Main.getInstance());
        pm.registerEvents(new MenuCMD(), Main.getInstance());

        main.getCommand("bc").setExecutor(new BcCMD());
        main.getCommand("invsee").setExecutor(new InvseeCMD());
        main.getCommand("freeze").setExecutor(new FreezeCMD());
        main.getCommand("unfreeze").setExecutor(new FreezeCMD());
        main.getCommand("money").setExecutor(new MoneyCMD());
        main.getCommand("menu").setExecutor(new MenuCMD());
        main.getCommand("list").setExecutor(new ListCMD());
        main.getCommand("feed").setExecutor(new FeedCMD());
        main.getCommand("setrank").setExecutor(new SetRankCMD());
    }



}
