package ua.lviv.shop.DAOs;

import java.sql.ResultSet;
import java.util.List;

public interface CRUD <T>{

    T getById(int id);
    List<T> getAll();
    void deleteById(int id);
    void deleteAll();
    void update( T user);
    void insert(String firstName, String lastName, String email, String role);
}
