package DAY1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Footballer f1 = new Footballer( 1, "Cristiano", "Ronaldo", "LW", 99);
        Footballer f2 = new Footballer(2, "Lionel", "Messi", "RW", 99);
        Footballer f3 = new Footballer(3, "Lamin", "Yamal", "RW", 89);
        Footballer f4 = new Footballer(4, "Kylian", "Mbappe", "LW", 89);
        Footballer f5 = new Footballer(5, "Aigyn", "Sagyntay", "ST", 90);
        Footballer f6 = new Footballer(6, "Akzhol", "Knyazov", "GK", 100);
        ArrayList<Footballer> footballers = new ArrayList<>();
        footballers.add(f1);
        footballers.add(f2);
        footballers.add(f3);
        footballers.add(f4);
        footballers.add(f5);
        footballers.add(f6);

        Club kairat = new Club();
        kairat.countryName = "Kazakhstan";
        kairat.clubName = "FC KAIRAT";
        kairat.footballers = footballers;

        Club chelsea = new Club();
        chelsea.countryName = "England";
        chelsea.clubName = "CHELSEA";
        Footballer f7 = new Footballer(7, "Cole", "Palmer", "ST", 84);
        Footballer f8 = new Footballer(8, "Nicolas", "Jackson", "ST", 81);
        Footballer f9 = new Footballer(9, "Michael", "Mudrick", "RW", 82);
        Footballer f10 = new Footballer(10, "Marc", "Cucurella", "LB", 79);
        Footballer f11 = new Footballer(11, "Jadon", "Sancho", "LW", 84);
        Footballer f12 = new Footballer(12, "Enzo", "Fernandez", "MB", 87);
        ArrayList<Footballer> chelseaFootballers = new ArrayList<>();
        chelseaFootballers.add(f7);
        chelseaFootballers.add(f8);
        chelseaFootballers.add(f9);
        chelseaFootballers.add(f10);
        chelseaFootballers.add(f11);
        chelseaFootballers.add(f12);
        chelsea.footballers = chelseaFootballers;

        kairat.printInfo();
        chelsea.printInfo();


    }
}
