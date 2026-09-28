package DAY3.entity;

public class Wallet {
    private int id;
    private int total_balance;
    private boolean isBlocked;

    public Wallet() {
    }

    public Wallet(int id, int total_balance, boolean isBlocked) {
        this.id = id;
        this.total_balance = total_balance;
        this.isBlocked = isBlocked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal_balance() {
        return total_balance;
    }

    public void setTotal_balance(int total_balance) {
        this.total_balance = total_balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", total_balance=" + total_balance +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
