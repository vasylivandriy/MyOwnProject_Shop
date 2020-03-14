package ua.lviv.shop.Services;

import ua.lviv.shop.DAOs.BasketDaoCRUD;
import ua.lviv.shop.Entities.Basket;

import java.util.Date;
import java.util.List;

public class BasketService {

    private BasketDaoCRUD basketDaoCRUD;
    private static BasketService basketService;

    public BasketService() {
        this.basketDaoCRUD = new BasketDaoCRUD();
    }

    public static BasketService getInstance() {
        if (basketService == null) {
            basketService = new BasketService();
        }
        return basketService;
    }

    Basket getById(int id) {

        return basketDaoCRUD.getById(id);
    }

    List<Basket> getAll() {
        return basketDaoCRUD.getAll();
    }

    void deleteById(Integer id) {
        basketDaoCRUD.deleteById(id);
    }

    void deleteAll() {
        basketDaoCRUD.deleteAll();
    }


    void update(Basket basket) {

        basketDaoCRUD.update(basket);
    }


    void create(Integer user_id, Integer product_id, Date purchase_date) {

        basketDaoCRUD.create(user_id, product_id, purchase_date);
    }
}
