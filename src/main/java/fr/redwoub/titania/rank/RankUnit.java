package fr.redwoub.titania.rank;

import java.util.ArrayList;
import java.util.Arrays;

public enum RankUnit {

    JOUEUR("Joueur", 7, "§7"),
    VIP("VIP", 6, "§5[§eVIP§5] "),
    MVP("MVP", 5, "§6[§bMVP§6] "),
    MODERATEUR("MODERATEUR", 4, "§aMod "),
    RESPONSABLE("RESPONSABLE", 3, "§cResp "),
    DEVELOPPER("DEVELOPPER", 2, "§1Dev "),
    ADMINISTRATEUR("ADMINISTRATEUR", 1, "§4Admin "),
    FONDATEUR("Fondateur", 0 , "§4Fondateur ");


    private String name;
    private int power;
    private String prefix;

    RankUnit(String name, int power, String prefix){
        this.name = name;
        this.power = power;
        this.prefix = prefix;
    }

    public static RankUnit getByName(String name){
        return Arrays.stream(values()).filter(r -> r.getName().equalsIgnoreCase(name)).findAny().orElse(RankUnit.JOUEUR);
    }

    public static RankUnit getbyPower(int power){
        return Arrays.stream(values()).filter(r -> r.getPower() == power).findAny().orElse(RankUnit.JOUEUR);
    }


    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String getPrefix() {
        return prefix;
    }
}
