package DAY2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class Main {
    static void main() {
        UserBeanImpl userBean = new UserBeanImpl();
        while (true) {
            System.out.println("[1] add user");
            System.out.println("[2] list users");
            System.out.println("[3] get user");
            System.out.println("[4] delete user");
            System.out.println("[0] exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 0) {
                break;}
            else if (choice == 1) {
                System.out.println("Enter your user login");
                String login = sc.next();
                System.out.println("Enter your user password");
                String password = sc.next();
                User user = new User();
                user.setLogin(login);
                user.setPassword(password);
                userBean.addUser(user);
                }
            else if (choice == 2) {
                    userBean.allUsers();
            }
            else if (choice == 3) {
                userBean.allUsers();
                System.out.println("Enter your user id");
                int id = sc.nextInt();
                System.out.println(userBean.getUser(id).toString());
            }else if (choice == 4) {
                userBean.allUsers();
                System.out.println("Enter your user id");
                int id = sc.nextInt();
                userBean.deleteUser(userBean.getUser(id));
            }
            }
        }
    }
