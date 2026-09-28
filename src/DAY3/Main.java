package DAY3;

import DAY3.db.Repo;
import DAY3.db.RepoImpl;
import DAY3.entity.Account;
import DAY3.entity.Wallet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Repo repo = new RepoImpl();

        System.out.println("[1] LOGIN");
        System.out.println("[2] REGISTER");

        int log = sc.nextInt();

        if (log == 1) {
            System.out.println("ENTER LOGIN");
            String login = sc.next();

            System.out.println("ENTER PASSWORD");
            String password = sc.next();

            if (repo.isUserRegistered(login)) {
                Account currentUser =
                        repo.getAccount(login, password);

                if (currentUser != null) {
                    while (true) {
                        System.out.println("[1] MY BANK");
                        System.out.println("[2] PEREVOD");
                        System.out.println("[3] EXIT");

                        int choice = sc.nextInt();

                        if (choice == 1) {
                            System.out.println(
                                    "YOUR BALANCE: "
                                            + repo.getTotalBalance(currentUser)
                            );

                        } else if (choice == 2) {
                            for (
                                    Account otherAccount
                                    : repo.getAllAccounts()
                            ) {
                                if (
                                        otherAccount.getId()
                                                != currentUser.getId()
                                ) {
                                    System.out.println(
                                            otherAccount.toString()
                                    );
                                }
                                System.out.println(
                                        "ENTER ACCOUNT ID TO TRANSFER"
                                );
                                int transfer_id = sc.nextInt();

                                System.out.println(
                                        "ENTER AMOUNT OF CASH TO TRANSFER"
                                );
                                int cash_amount = sc.nextInt();

                                if (
                                        cash_amount
                                                <= currentUser
                                                .getWallet()
                                                .getTotal_balance()
                                ) {
                                    if (
                                            repo.cashTransfer(
                                                    currentUser,
                                                    repo.getAccountById(
                                                            transfer_id
                                                    ),
                                                    cash_amount
                                            )
                                    ) {
                                        System.out.println(
                                                "SUCCESSFULLY TRANSFERRED"
                                        );
                                    } else {
                                        System.out.println(
                                                "FAILED TO TRANSFER"
                                        );
                                    }

                                } else {
                                    System.out.println("NOT ENOUGH MONEY");
                                }

                            }
                        } else if (choice == 0) {
                            break;
                        }
                    }

                } else {
                    System.out.println("ERROR PASSWORD");
                }

            } else {
                System.out.println("ERROR LOGIN");
            }

        } else if (log == 2) {
            System.out.println("ENTER LOGIN");
            String login = sc.next();

            System.out.println("ENTER PASSWORD");
            String password = sc.next();

            System.out.println("ENTER NAME");
            String name = sc.next();

            System.out.println("ENTER SURNAME");
            String surname = sc.next();

            System.out.println("ENTER CASH");
            int cash = sc.nextInt();

            Account account = new Account();
            account.setLogin(login);
            account.setPassword(password);
            account.setName(name);
            account.setSurname(surname);

            Wallet wallet = new Wallet();
            wallet.setTotal_balance(cash);
            wallet.setBlocked(false);

            account.setWallet(wallet);

            if (repo.addAccount(account)) {
                System.out.println("SUCCESSFULLY ADDED");
            } else {
                System.out.println("ERROR!!!");
            }
        }

        sc.close();
    }
}