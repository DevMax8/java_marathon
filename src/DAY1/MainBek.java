package DAY1;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainBek {
    static void main() {
        Scanner sc = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();
        User u1 = new User(1, "Akzhol", "Knyazov");
        User u2 = new User(2, "Selena", "Gomez");
        User u3 = new User(3, "Billie", "Eilish");
        users.add(u1);
        users.add(u2);
        users.add(u3);

        Wallet w1 = new Wallet();
        w1.id = 1;
        w1.total_balance = 100000;
        u1.wallet = w1;

        Wallet w2 = new Wallet();
        w2.id = 2;
        w2.total_balance = 80000;
        u2.wallet = w2;

        Wallet w3 = new Wallet();
        w3.id = 3;
        w3.total_balance = 90000;
        u3.wallet = w3;

        int id = 4;
        int myID = 1;
        int t_id = 1;
        while(true){
            System.out.println("[1] ALL USERS");
            System.out.println("[2] ADD USERS");
            System.out.println("[3] CASH TRANSFER USERS");
            System.out.println("[0] EXIT");

            int choice = sc.nextInt();
            if(choice == 0) {
                break;
            }
            else if (choice == 1){
                for (User u : users) {
                    u.getInfo();
                }
            }
            else if (choice == 2){
                User newUser = new User();
                newUser.id = id;
                id++;
                System.out.println("NAME: ");
                String name = sc.next();
                System.out.println("SURNAME: ");
                String surname = sc.next();
                newUser.name = name;
                newUser.surname = surname;
                users.add(newUser);
                System.out.println("ENTER BALANCE: ");
                int balance = sc.nextInt();
                Wallet wallet = new Wallet();
                wallet.id = id;
                newUser.wallet = wallet;
                wallet.total_balance = balance;
                id++;
                System.out.println("USER WAS ADDED");
            }
            else if (choice == 3){
                System.out.printf("%-15s %-15s %-15s", "ID", "NAME", "SURNAME");
                System.out.println();
                for (User u : users) {
                    if (u.id != myID) {
                        System.out.printf("%-15s %-15s %-15s", u.id, u.name, u.surname);
                        System.out.println();
                    }
                }
                System.out.println("КОМУ ОТПРАВЛЯЕМ?");
                int user_id_to = sc.nextInt();
                User userTo = users.get(user_id_to - 1);
                System.out.println("ENTER CASH TRANSFER");
                int cash_transfer = sc.nextInt();
                if (cash_transfer <= u1.wallet.total_balance){
                    Date date = new Date();
                    Timestamp currentTime = new Timestamp(date.getTime());
                    Transaction t1 = new Transaction(t_id, u1, userTo, cash_transfer, currentTime);
                    u1.wallet.total_balance -= cash_transfer;
                    userTo.wallet.total_balance += cash_transfer;
                    System.out.println(userTo.toString());
                    System.out.println("ПЕРЕВЕДЕНО!");
                }
            }

        }
    }
}
