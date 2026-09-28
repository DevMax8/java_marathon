package DAY3.db;

import DAY3.entity.Account;
import DAY3.entity.Wallet;

import java.sql.*;
import java.util.ArrayList;

public class RepoImpl implements Repo {

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:/",
                    "",
                    ""
            );

            System.out.println("CONNECTED!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isUserRegistered(String login) {
        String sql = """
                SELECT *
                FROM t_users
                WHERE login = ?
                LIMIT 1
                """;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Account getAccount(String login, String password) {
        String sql = """
                SELECT *
                FROM t_users
                WHERE login = ? AND password = ?
                LIMIT 1
                """;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Account account = new Account();

                    account.setId(resultSet.getInt("id"));
                    account.setName(resultSet.getString("name"));
                    account.setSurname(resultSet.getString("surname"));
                    account.setLogin(resultSet.getString("login"));
                    account.setPassword(resultSet.getString("password"));

                    int walletId = resultSet.getInt("wallet_id");
                    Wallet wallet = getWalletbyId(walletId);
                    account.setWallet(wallet);

                    return account;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Wallet getWalletbyId(int id) {
        String sql = """
                SELECT *
                FROM t_wallet
                WHERE id = ?
                LIMIT 1
                """;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Wallet wallet = new Wallet();

                    wallet.setId(resultSet.getInt("id"));
                    wallet.setTotal_balance(
                            resultSet.getInt("total_balance")
                    );

                    wallet.setBlocked(
                            resultSet.getBoolean("is_blocked")
                    );

                    return wallet;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addAccount(Account account) {
        boolean isAdded = false;
        try{
            PreparedStatement statement1 = connection.prepareStatement(
                    "INSERT INTO t_wallet(total_balance, is_blocked) Values (?, false)"
            );
            statement1.setInt(1, account.getWallet().getTotal_balance());
            statement1.executeUpdate();

            PreparedStatement statement2 = connection.prepareStatement(
                    "select count(*) as count from t_wallet"
            );
            ResultSet resultSet = statement2.executeQuery();
            int id = 0;
            if (resultSet.next()) {
                id = resultSet.getInt("count");
            }


            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO t_users(login, password, name, surname, wallet_id)" +
                            "VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, account.getLogin());
            statement.setString(2, account.getPassword());
            statement.setString(3, account.getName());
            statement.setString(4, account.getSurname());

            statement.setInt(5, id);
            isAdded = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return isAdded;
    }

    @Override
    public int getTotalBalance(Account account) {
        int balance = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT total_balance " +
                            "FROM t_wallet " +
                            "WHERE id = (" +
                            "SELECT wallet_id FROM t_users WHERE id = ?" +
                            ")"
            );
            statement.setInt(1,account.getId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                balance = resultSet.getInt("total_balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    @Override
    public ArrayList<Account> getAllAccounts() {
        ArrayList<Account> allAccounts = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "Select * from t_users"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setSurname(resultSet.getString("surname"));
                account.setLogin(resultSet.getString("login"));
                account.setPassword(resultSet.getString("password"));
                int walletId = resultSet.getInt("wallet_id");
                Wallet wallet = getWalletbyId(walletId);
                account.setWallet(wallet);
                allAccounts.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allAccounts;
    }

    @Override
    public boolean cashTransfer(Account accountFrom, Account accountTo, int amount) {
        boolean isTransfered = false;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE t_wallet " +
                            "SET total_balance = ? " +
                            "WHERE id = ? "
            );
            statement.setInt(1, accountFrom.getWallet().getTotal_balance() - amount);
            statement.setInt(2, accountFrom.getWallet().getId());
            statement.executeUpdate();

            PreparedStatement statement2 = connection.prepareStatement(
                    "UPDATE t_wallet " +
                            "SET total_balance = ? " +
                            "WHERE id = ? "
            );
            statement2.setInt(1, accountTo.getWallet().getTotal_balance() + amount);
            statement2.setInt(2, accountTo.getWallet().getId());
            statement2.executeUpdate();
            isTransfered = true;
        }catch (Exception e) {
            e.printStackTrace();
        }


        return isTransfered;
    }

    @Override
    public Account getAccountById(int id) {
        Account account = null;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "Select * from t_users where id = ? "
            );
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setSurname(resultSet.getString("surname"));
                account.setLogin(resultSet.getString("login"));
                account.setPassword(resultSet.getString("password"));
                int walletId = resultSet.getInt("wallet_id");
                Wallet wallet = getWalletbyId(walletId);
                account.setWallet(wallet);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }
}