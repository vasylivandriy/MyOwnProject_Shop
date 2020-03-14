package ua.lviv.shop.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

public class Basket {

    private Integer id;
    private Integer user_id;
    private Integer product_id;
    private Date purchase_date;

    public Basket(Integer id, Integer user_id, Integer product_id, Date purchase_date) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.purchase_date = purchase_date;
    }

    public Basket(Integer user_id, Integer product_id, Date purchase_date) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.purchase_date = purchase_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public static Basket getBasket(ResultSet resultSet)  {


        try {
            Integer basket_id = resultSet.getInt("id");
            Integer user_id = resultSet.getInt("user_id");
            Integer product_id = resultSet.getInt("product_id");
            Date purchase_date = resultSet.getDate("purchase_date");

            return new Basket(basket_id, user_id, product_id, purchase_date);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while getting a basket");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(id, basket.id) &&
                Objects.equals(user_id, basket.user_id) &&
                Objects.equals(product_id, basket.product_id) &&
                Objects.equals(purchase_date, basket.purchase_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, product_id, purchase_date);
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
}
