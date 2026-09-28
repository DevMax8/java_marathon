package DAY2;

import java.util.ArrayList;

public class UserBeanImpl implements UserBean{
    private ArrayList<User> listofUsers = new ArrayList<>();
    private int id = 1;
    public UserBeanImpl(){
    }

    @Override
    public void addUser(User user) {
        user.setId(id);
        listofUsers.add(user);
        id++;
    }

    @Override
    public void deleteUser(User user) {
        listofUsers.remove(user);
    }

    @Override
    public void allUsers() {
        for (User user : listofUsers){
            System.out.println(user.toString());
        }
    }

    @Override
    public User getUser(int id) {
        for (User user : listofUsers){
            if (user.getId() == id)
                return user;
        }
        return null;
    }
}
