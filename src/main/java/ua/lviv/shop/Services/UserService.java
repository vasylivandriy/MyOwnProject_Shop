package ua.lviv.shop.Services;

import ua.lviv.shop.DAOs.UserDaoCRUD;
import ua.lviv.shop.Entities.User;

import java.util.List;

public class UserService {

    private UserDaoCRUD userDaoCRUD;
    private static UserService userService;

    public UserService() {
        this.userDaoCRUD = new UserDaoCRUD();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    User getById(int id) {

        return userDaoCRUD.getById(id);
    }

    List<User> getAll() {
        return userDaoCRUD.getAll();
    }

    void deleteById(Integer id) {
        userDaoCRUD.deleteById(id);
    }

    void deleteAll() {
        userDaoCRUD.deleteAll();
    }


    void update(User user) {

        userDaoCRUD.update(user);
    }


    void insert(String firstName, String lastName, String email, String role) {

        userDaoCRUD.insert(firstName, lastName, email, role);
    }


}

