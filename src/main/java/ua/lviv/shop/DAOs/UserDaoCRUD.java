package ua.lviv.shop.DAOs;

import ua.lviv.shop.ConnectionManager;
import ua.lviv.shop.Entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoCRUD implements CRUD<User> {

    private String SELECT_ALL = "SELECT * FROM project_shop.users";
    private String SELECT_BY_ID = "SELECT * FROM project_shop.users where id = ?";
    private String DELETE_BY_ID = "DELETE FROM project_shop.users where id = ?";
    private String DELETE_ALL = "DELETE FROM project_shop.users";
    private String INSERT = "INSERT INTO project_shop.users (firstName, lastName, email, role) value (?,?,?,?)";
    private String UPDATE_BY_ID = "UPDATE project_shop.users set firstName = ?, lastName = ?, email = ?, role = ? where id = ?";

    public UserDaoCRUD() {
        this.connection = ConnectionManager.getConnection();
    }

    private Connection connection;
    private PreparedStatement preparedStatement;


    @Override
    public User getById(Integer id) {

        try {
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return User.getUser(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException("Error until getting user by id");
        }

    }

    @Override
    public List<User> getAll() {


        try {
            List<User> userList = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                userList.add(User.getUser(resultSet));
            }
            return userList;

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
            throw new RuntimeException("User was not deleted by id");
        }


    }

    @Override
    public void deleteAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("All users was not deleted");
        }

    }

    @Override
    public void update(User user) {

        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setObject(1, user.getFirstName());
            preparedStatement.setObject(2, user.getLastName());
            preparedStatement.setObject(3, user.getEmail());
            preparedStatement.setObject(4, user.getRole());
            preparedStatement.setObject(5, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("User was not updated by id");
        }

    }


    public void insert(String firstName, String lastName, String email, String role) {
        try {
            preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setObject(1, firstName);
            preparedStatement.setObject(2, lastName);
            preparedStatement.setObject(3, email);
            preparedStatement.setObject(4, role);

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("User was not inserted");
        }

    }
}
