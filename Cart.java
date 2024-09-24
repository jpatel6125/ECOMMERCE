package Project.Cart;

import Project.Product.Product;
import Project. Category.Category;
import java.util.*;
public class Cart {
    private List<Product> cartItems; // List to hold the products
    private List<Integer> quantities; // List to hold the corresponding quantities

    public Cart() {
        cartItems = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) {
        if (cartItems.contains(product)) {
            // If product already exists in the cart, increase the quantity
            int index = cartItems.indexOf(product);
            quantities.set(index, quantities.get(index) + quantity);
        } else {
            // Otherwise, add product and quantity to the cart
            cartItems.add(product);
            quantities.add(quantity);
        }
    }

    double total = 0;
    public void displayCart() {

        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("Your cart:");
        for (int i = 0; i < cartItems.size(); i++) {
            Product product = cartItems.get(i);
            int quantity = quantities.get(i);
            double price = product.getPrice() * quantity;
            System.out.println(product.getName() + " -> " + quantity + " x Rs. " + product.getPrice() + " = Rs. " + price);
            total += price;
        }

        System.out.println("Total: Rs. " + total);
    }
    public double getTotal() {
        return total;
    }
}
