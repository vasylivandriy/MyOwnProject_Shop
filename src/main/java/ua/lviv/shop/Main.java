package ua.lviv.shop;

import ua.lviv.shop.DAOs.UserDaoCRUD;
import ua.lviv.shop.Entities.User;
import ua.lviv.shop.Services.ProductService;

public class Main {

    public static void main(String[] args) {

        UserDaoCRUD userDaoCRUD = new UserDaoCRUD();

        System.out.println(userDaoCRUD.getById(1));
        userDaoCRUD.getAll().forEach(System.out::println);

//        userDaoCRUD.insert("Mark", "Potebnia", "kjshfdh@gmail.com", "Text redactor");
//        userDaoCRUD.update(new User(1, "Petro", "Hryb", "jhjsdf@gmail.com", "mekhanik"));
//
//        userDaoCRUD.deleteById(2);
//        userDaoCRUD.deleteAll();




    }

}
