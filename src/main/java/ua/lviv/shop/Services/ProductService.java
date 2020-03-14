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


    public Product getById(int id) {
        return productDaoCRUD.getById(id);
    }

    List<Product> getAll() {
        return productDaoCRUD.getAll();
    }

    void deleteById(Integer id) {
        productDaoCRUD.deleteById(id);
    }

    void deleteAll() {
        productDaoCRUD.deleteAll();
    }

    void update(Product product) {

        productDaoCRUD.update(product);
    }


    void insert(String name, String description, float price) {
        productDaoCRUD.insert(name, description, price);
    }

}
