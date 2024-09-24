package Project;

import Project.Login.Login;
import Project.Product.Product;
import Project.Category.Category;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Initialize products
        Product shirt = new Product("Shirt", 500, 10, 5);
        Product jeans = new Product("Jeans", 1000, 5, 5);
        Product sneakers = new Product("Sneakers", 850, 7, 5);

        Product iphone = new Product("iPhone", 145500, 4, 3);
        Product samsung = new Product("Samsung Galaxy", 152000, 3, 4);
        Product pixel = new Product("Google Pixel", 80000, 5, 2);

        Product tv = new Product("Smart TV", 35000, 8, 4);
        Product speaker = new Product("Bluetooth Speaker", 1600, 10, 7);
        Product lamp = new Product("Lamp", 800, 15, 10);

        // Create categories
        Category clothing = new Category("Clothing");
        clothing.addProduct(shirt);
        clothing.addProduct(jeans);
        clothing.addProduct(sneakers);

        Category smartphones = new Category("Smartphones");
        smartphones.addProduct(iphone);
        smartphones.addProduct(samsung);
        smartphones.addProduct(pixel);

        Category electronicsAndDecor = new Category("Electronics & Home Decor");
        electronicsAndDecor.addProduct(tv);
        electronicsAndDecor.addProduct(speaker);
        electronicsAndDecor.addProduct(lamp);

        // List of categories
        List<Category> categories = new ArrayList<>();
        categories.add(clothing);
        categories.add(smartphones);
        categories.add(electronicsAndDecor);

        Scanner sc = new Scanner(System.in);
        // Start user session
        int usersChoice = 1;
        Login user = new Login();
        do {
            System.out.println("1. Enter");
            System.out.println("2. Exit");
            usersChoice = sc.nextInt();
            if(usersChoice == 1) {
                user.login(categories);
            }
        }while(usersChoice == 1);
    }
}
