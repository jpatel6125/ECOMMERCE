package Project.Login;

import Project.Category.Category;
import Project.UserSession.UserSession;
import Project.Cart.Cart;
import java.util.*;

public class Login {
    class Account {
        private String email;
        private String password;
        private Cart cart;  // Each account will have a cart

        Scanner sc = new Scanner(System.in);

        public Account() {
            this.cart = new Cart();  // Initialize an empty cart for each account
        }

        public Account signUp() {
            System.out.println("Enter your details:");
            System.out.print("Email: ");
            email = sc.next();
            if (isValidEmail(email)) {
                System.out.print("Password: ");
                password = sc.next();
            } else {
                System.out.println("Invalid email address.");
            }
            return this;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public Cart getCart() {
            return cart;  // Return the associated cart for this account
        }

        public boolean signIn(List<Account> accounts) {
            System.out.print("Email: ");
            String inputEmail = sc.next();
            System.out.print("Password: ");
            String inputPassword = sc.next();
            for (Account a : accounts) {
                if (a.getEmail().equals(inputEmail) && a.getPassword().equals(inputPassword)) {
                    return true;  // Valid login
                }
            }
            System.out.println("Invalid credentials.");
            return false;
        }

        public boolean isValidEmail(String e) {
            return e.contains("@") && e.contains(".");
        }
    }

    private static List<Account> accounts = new ArrayList<>();

    public void login(List<Category> categories) {
        Scanner sc = new Scanner(System.in);
        Login loginSystem = new Login();
        int choice = 0;
        UserSession session = new UserSession(categories);

        do {
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Sign up
                    Account newAccount = loginSystem.new Account();
                    accounts.add(newAccount.signUp());
                    System.out.println("Sign-up successful!");
                    session.start();
                    break;

                case 2:
                    // Sign in
                    Account signInAccount = loginSystem.new Account();
                    if (signInAccount.signIn(accounts)) {
                        System.out.println("You are logged in. Enjoy your shopping!!");
                        session.start();

                        // Link user cart after successful login
                        Cart userCart = signInAccount.getCart();  // Get user's cart
                        // Now the user can add/remove items to/from their cart

                        // Example operation on cart (you would replace this with actual shopping logic)
//                        System.out.println("You have " + userCart.getItemsCount() + " items in your cart.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);

        // Output all registered accounts (for demonstration purposes)
        for (Account account : accounts) {
            System.out.println(account.getEmail());
        }
    }
}
