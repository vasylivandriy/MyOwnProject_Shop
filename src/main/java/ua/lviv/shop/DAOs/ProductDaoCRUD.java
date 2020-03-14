package ua.lviv.shop.DAOs;

import ua.lviv.shop.ConnectionManager;
import ua.lviv.shop.Entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoCRUD implements CRUD<Product> {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private String SELECT_ALL = "SELECT * FROM project_shop.users";
    private String SELECT_BY_ID = "SELECT * FROM project_shop.products where id = ?";
    private String DELETE_BY_ID = "DELETE FROM project_shop.products where id = ?";
    private String DELETE_ALL = "DELETE FROM project_shop.products";
    private String CREATE = "INSERT INTO project_shop.users (firstName, lastName, email, role) value (?,?,?,?)";
    private String CHANGE_BY_ID = "UPDATE project_shop.products set name =?, description = ?, price =? where id = ?";


    public ProductDaoCRUD() {
        this.connection = ConnectionManager.getConnection();
    }


    @Override
    public Product getById(Integer id) {

        try {
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return Product.getProduct(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException("Error until getting product by id");
        }

    }

    @Override
    public List<Product> getAll() {
        try {
            List<Product> productList = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                productList.add(Product.getProduct(resultSet));
            }
            return productList;

        } catch (SQLException e) {
            throw new RuntimeException("Error until getting all users");
        }

    }

    @Override
    public void deleteById(Integer id) {

        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Product hasn't deleted by id");
        }
    }

    @Override
    public void deleteAll() {

        try {
            preparedStatement = connection.prepareStatement(DELETE_ALL);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("All products hasn't deleted");
        }

    }

    public void insert(String name, String description, float price) {

        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setFloat(3, price);

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Product hasn't inserted");
        }

    }


        @Override
    public void update(Product product) {

        try {
            preparedStatement = connection.prepareStatement(CHANGE_BY_ID);
            preparedStatement.setObject(1, product.getName());
            preparedStatement.setObject(2, product.getDescription());
            preparedStatement.setObject(3, product.getPrice());
            preparedStatement.setObject(4, product.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Product hasn't updated by id");
        }

}

}
