package ua.lviv.shop.DAOs;

import java.sql.ResultSet;
import java.util.List;

public interface CRUD<T> {

    T getById(Integer id);

    List<T> getAll();

    void deleteById(Integer id);

    void deleteAll();

    void update(T user);

//    void insert(String firstName, String lastName, String email, String role);
//    void insert(String name, String description, float price);
}
