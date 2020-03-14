package ua.lviv.shop.DAOs;

import ua.lviv.shop.ConnectionManager;
import ua.lviv.shop.Entities.Basket;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BasketDaoCRUD implements CRUD<Basket> {


    private Connection connection;
    private PreparedStatement preparedStatement;

    private String SELECT_ALL = "SELECT * FROM project_shop.users";
    private String SELECT_BY_ID = "SELECT * FROM project_shop.products where id = ?";
    private String DELETE_BY_ID = "DELETE FROM project_shop.products where id = ?";
    private String DELETE_ALL = "DELETE FROM project_shop.products";
    private String CREATE = "INSERT INTO project_shop.users (firstName, lastName, email, role) value (?,?,?,?)";

    public BasketDaoCRUD() {
        this.connection = ConnectionManager.getConnection();
    }

    @Override
    public Basket getById(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return Basket.getBasket(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException("Error until getting basket by id");
        }

    }

    @Override
    public List<Basket> getAll() {

        try {
            List<Basket> basketList = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                basketList.add(Basket.getBasket(resultSet));
            }
            return basketList;

        } catch (SQLException e) {
            throw new RuntimeException("Error until getting all baskets");
        }

    }

    @Override
    public void deleteById(Integer id) {

        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setObject(1, "id");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Basket hasn't deleted by id");
        }

    }

    @Override
    public void deleteAll() {

        try {
            preparedStatement = connection.prepareStatement(DELETE_ALL);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("All baskets hasn't deleted");
        }

    }

    @Override
    public void update(Basket basket) {
        throw new IllegalStateException("There is no update for basket");
    }

    public void create(Integer user_id, Integer product_id, Date purchase_date) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);

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
