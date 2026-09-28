package DAY3.db;

import DAY3.entity.Account;
import DAY3.entity.Wallet;

import java.util.ArrayList;

public interface Repo {
    boolean isUserRegistered(String login);
    Account getAccount(String login, String password);
    Wallet getWalletbyId(int id);
    boolean addAccount(Account account);
    int getTotalBalance(Account account);
    ArrayList<Account> getAllAccounts();
    boolean cashTransfer(Account accountFrom, Account accountTo, int amount);
    Account getAccountById(int id);
}
