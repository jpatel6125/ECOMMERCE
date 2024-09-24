package Project.Category;

import Project.Product.Product;
import java.util.*;
public class Category {
    private String categoryName;
    private List<Product> products; // List of products under this category

    // Constructor to initialize the category name and product list
    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.products = new ArrayList<>();
    }

    // Method to get the name of the category
    public String getCategoryName() {
        return categoryName;
    }

    // Method to add a product to the category
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to get the list of products in the category
    public List<Product> getProducts() {
        return products;
    }

    // Method to display all products in the category
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available in this category.");
        } else {
            System.out.println("Products available in " + categoryName + ":");
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                System.out.println((i + 1) + ". " + product.getName() + " - Rs. " + product.getPrice() + " (" + product.getQuantity() + " available)");
            }
        }
    }
}
