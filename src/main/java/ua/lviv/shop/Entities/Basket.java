package ua.lviv.shop.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Basket {

    private int id;
    private int user_id;
    private int product_id;
    private Date purchase_date;

    public Basket(int id, int user_id, int product_id, Date purchase_date) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.purchase_date = purchase_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", purchase_date=" + purchase_date +
                '}';
    }

    public static Basket getBasket(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        int user_id = resultSet.getInt("user_id");
        int product_id = resultSet.getInt("product_id");
        Date purchase_date = resultSet.getDate("purchase_date");

        return new Basket(id, user_id, product_id, purchase_date);
    }

}
