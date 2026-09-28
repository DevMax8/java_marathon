package DAY1;

public class User {
    int id;
    String name;
    String surname;
    Wallet wallet;
    public User() {
    }

    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public void getInfo(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Wallet: " + wallet.total_balance);
        }

    }

