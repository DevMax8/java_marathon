package DAY1;

import java.util.ArrayList;

public class Club {
    public String countryName;
    public String clubName;
    public ArrayList<Footballer> footballers;

    public void printInfo(){
        System.out.println("-----------------------------------------");
        System.out.printf("%-15s %-15s", "CLUB", "Country");
        System.out.println();
        System.out.printf("%-15s %-15s", clubName, countryName);
        System.out.println();
        System.out.printf("%-15s %-15s %-15s", "ID", "NAME", "SURNAME");
        System.out.println();
        for (Footballer player : footballers) {
            System.out.printf("%-15s %-15s %-15s", player.id, player.name, player.surname);
            System.out.println();
        }


    }
}