package ua.lviv.shop.Services;

import ua.lviv.shop.DAOs.ProductDaoCRUD;
import ua.lviv.shop.Entities.Product;
import ua.lviv.shop.Entities.User;

import java.util.List;

public class ProductService {

    private ProductDaoCRUD productDaoCRUD;
    private static ProductService productService;

    public ProductService() {
        this.productDaoCRUD = new ProductDaoCRUD();
    }

    public static ProductService getInstance() {
        if (productService == null) {
            productService = new ProductService();
        }
        return productService;
    }


    public static Product getById(int id) {
        return productService.getById(id);
    }

    List<Product> getAll() {
        return productService.getAll();
    }

    void deleteById(int id) {
    }

    void deleteAll() {
    }

    void update(Product product) {
    }


    void insert(String name, String description, float price) {
    }

}
