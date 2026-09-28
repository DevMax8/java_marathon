package DAY2;

import java.util.ArrayList;

public interface UserBean {
    void addUser(User user);
    void deleteUser(User user);
    void allUsers();
    User getUser(int id);
}
