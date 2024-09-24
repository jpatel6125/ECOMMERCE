package Project.UserSession;
import Project.Cart.Cart;
import Project.Category.Category;
import Project.Product.Product;

import java.util.List;
import java.util.Scanner;

public class UserSession {
    private Cart cart;
    private List<Category> categories;

    public UserSession(List<Category> categories) {
        this.categories = categories;
        this.cart = new Cart();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the E-Commerce Application!");
        boolean shopping = true;

        while (shopping) {
            System.out.println("What would you like to do?");
            System.out.println("1. View Cart");
            System.out.println("2. Browse Products");
            System.out.println("3. Check Out");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    cart.displayCart();
                    break;
                case 2:
                    browseProducts();
                    break;
                case 3:
                    shopping = false;
                    System.out.println("Your total bill is: Rs. " + cart.getTotal());
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    public void browseProducts() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a category:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
        }
        int categoryChoice = sc.nextInt();
        if (categoryChoice > 0 && categoryChoice <= categories.size()) {
            Category selectedCategory = categories.get(categoryChoice - 1);
            selectedCategory.displayProducts();
            System.out.println("Select a product to add to cart:");
            int productChoice = sc.nextInt();
            if (productChoice > 0 && productChoice <= selectedCategory.getProducts().size()) {
                Product selectedProduct = selectedCategory.getProducts().get(productChoice - 1);
                System.out.println("Enter the quantity:");
                int quantity = sc.nextInt();
                if (quantity > 0 && quantity <= selectedProduct.getQuantity()) {
                    cart.addToCart(selectedProduct, quantity);
                    selectedProduct.reduceQuantity(quantity);
                    System.out.println("Product added to cart!");
                } else {
                    System.out.println("Product quantity not in sock.");
                }
            } else {
                System.out.println("Invalid product choice.");
            }
        } else {
            System.out.println("Invalid category choice.");
        }
    }
}
