package Project;

import java.util.*;
import java.io.*;

public class Login {
    class Account {
        private String email;
        private String password;

        Scanner sc = new Scanner(System.in);

        public Account signUp() {
            System.out.println("Enter your details:");
            System.out.print("Email: ");
            email = sc.next();
            Console console = System.console();
            if (isValidEmail(email)) {
                char[] passwordArray = console.readPassword("Password: ");
                password = new String(passwordArray);
            }
            else System.out.println("Invalid email address.");
            return this;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public boolean signIn(List<Account> o) {
            System.out.print("Email: ");
            String inputEmail = sc.next();
            System.out.print("Password: ");
            String inputPassword = sc.next();
            for (Account a : o) {
                if (a.getEmail().equals(inputEmail) && a.getPassword().equals(inputPassword)) {
                    return true; // Valid login
                }
            }
            System.out.println("Invalid credentials.");
            return false;
        }

        public boolean isValidEmail(String e) {
            if (email.contains("@") && email.contains(".")) {
//            password = sc.next();
                return true;
            } else return false;
        }
    }

    private static List<Account> acc = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account");
//       acc.add()
        Login log = new Login();
        int choice = 0;
        do {
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    Account signup = log.new Account();
                    acc.add(signup.signUp());
                    // Enter the Product class here
                break;

                case 2:
                    Account signin = log.new Account();
                if (signin.signIn(acc)) {
                    System.out.println("Account logged in");
                }
                break;
            }
        }while(choice!=3);

        for(Account i : acc) {
            System.out.println(i.email);
        }
    }
}

