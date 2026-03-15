package com.main;

import com.usermanagement.*;

import java.util.Optional;
import java.util.Scanner;

public class MyContactsApp {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== MyContacts App =====");
            System.out.println("1. Register");
            System.out.println("2. Login (Basic - Username)");
            System.out.println("3. Login (Open - Email)");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;

                case 2:
                    basicLogin();
                    break;

                case 3:
                    openLogin();
                    break;

                case 4:
                    System.out.println("Exiting application...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    
    // Registration
   

    private static void registerUser() {

        try {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            if (UserStore.users.containsKey(username)) {
                System.out.println("Username already exists!");
                return;
            }

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            for (User u : UserStore.users.values()) {
                if (u.getEmail().equalsIgnoreCase(email)) {
                    System.out.println("Email already registered!");
                    return;
                }
            }

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            System.out.print("Enter Type (free/premium): ");
            String type = sc.nextLine();

            UserRegistration reg = new UserRegistration();

            User user = reg.registerUser(name, username, email, password, type);

            System.out.println("User Registered Successfully!");
            System.out.println("Username: " + user.getUsername());

        } catch (Exception e) {
            System.out.println("Registration Failed: " + e.getMessage());
        }
    }

    
    //  Basic Auth
    

    private static void basicLogin() {

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Authentication auth = new BasicAuth();

        Optional<User> result = auth.login(username, password);

        if (result.isPresent()) {
            SessionManager.getInstance().login(result.get());

            System.out.println("Basic Login Successful!");
            System.out.println("Welcome " + result.get().getName());

        } else {
            System.out.println("Invalid Username or Password");
        }
    }

    
    //  Open Auth
    

    private static void openLogin() {

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Authentication auth = new OAuth();

        Optional<User> result = auth.login(email, password);

        if (result.isPresent()) {
            SessionManager.getInstance().login(result.get());

            System.out.println("Open Login Successful!");
            System.out.println("Welcome " + result.get().getName());

        } else {
            System.out.println("Invalid Email or Password");
        }
    }
}