package fr.redwoub.titania;

public class Main extends JavaPlugin {

    private static Main instance;


    @Override
    public void onEnable(){
        instance = this;
    }

    @Override
    public void onDisable(){

    }

    public static Main getInstance() {
        return instance;
    }
}
