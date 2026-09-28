package DAY1;

public class Footballer {
    int id;
    String name;
    String surname;
    String position;
    int rating;


    public Footballer(int id, String name, String surname, String position, int rating) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.rating = rating;
    }

    public void getInfo(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Position: " + position);
        System.out.println("Rating: " + rating);}
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
        }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public void setRating(int rating){
        this.rating = rating;
    }
    }