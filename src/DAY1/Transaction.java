package DAY1;

import java.sql.Timestamp;

public class Transaction {
    int id;
    User userFrom;
    User userTo;
    int amount;
    Timestamp date;
    public Transaction(int id, User userFrom, User userTo, int amount, Timestamp date){
        this.id = id;
        this.userFrom = userFrom;
        this.userTo = userTo;
        if (amount < userFrom.wallet.total_balance){
            this.amount = amount;
        }
        this.date = date;
    }
}
