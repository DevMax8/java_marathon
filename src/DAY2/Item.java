package DAY2;

public class Item {
    private int id;
    private String name;
    private int price;
    private int amount;

    public Item(){

    }
    public Item(int id, String name, int price, int amount){
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
//Setters
    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

//Getters
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getAmount(){
        return amount;
    }


    public String toString(){
        return "ID: " + id + " Name: " + name + " Price: " + price + " Amount: " + amount;
    }

}
