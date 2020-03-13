package ua.lviv.shop.DAOs;

import ua.lviv.shop.ConnectionManager;
import ua.lviv.shop.Entities.Basket;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class BasketDaoCRUD implements CRUD<Basket> {


    private Connection connection;
    //        private String SELECT_ALL = "SELECT * FROM project_shop.users";
//        private String SELECT_BY_ID = "SELECT * FROM project_shop.products where id = ?";
//        private String DELETE_BY_ID = "DELETE FROM project_shop.products where id = ?";
//        private String DELETE_ALL = "DELETE FROM project_shop.products";
    private String INSERT = "INSERT INTO project_shop.users (firstName, lastName, email, role) value (?,?,?,?)";
//        private String UPDATE_BY_ID = "UPDATE project_shop.products set name =?, description = ?, price =? where id = ?";


    public BasketDaoCRUD() {
        this.connection = ConnectionManager.getConnection();
    }

    @Override
    public Basket getById(int id) {
        return null;
    }

    @Override
    public List<Basket> getAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update(Basket basket) {

    }

    public void insert(int user_id, int product_id, Date purchase_date) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setObject(1, user_id);
            preparedStatement.setObject(2, product_id);
            preparedStatement.setObject(3, purchase_date);

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Basket has not inserted");
        }
    }
}
