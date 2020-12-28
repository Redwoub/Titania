package fr.redwoub.titania.rank;

import java.util.Arrays;

public enum RankUnit {

    JOUEUR("Joueur", 0, "§7"),
    VIP("VIP", 0, "§5[§eVIP§5] "),
    MVP("MVP", 0, "§6[§bMVP§6] "),
    MODERATEUR("MODERATEUR", 0, "§aMod "),
    RESPONSABLE("RESPONSABLE", 0, "§cResp "),
    DEVELOPPER("DEVELOPPER", 0, "§6Dev "),
    ADMINISTRATEUR("ADMINISTRATEUR", 0, "§4Admin "),
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
