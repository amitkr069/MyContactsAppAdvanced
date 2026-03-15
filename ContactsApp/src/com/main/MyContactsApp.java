/**
 * @author Amit
 * @Version 5.0
 * 
 * This use case contains contact management
 * user creates contacts add added a feature to view contacts
 */
package com.main;

import com.usermanagement.*;
import com.contactmanagement.*;

import java.util.Optional;
import java.util.Scanner;
import java.util.*;

public class MyContactsApp {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== MyContacts App =====");

            if (SessionManager.getInstance().getCurrentUser() == null) {

                System.out.println("1. Register");
                System.out.println("2. Login (Basic)");
                System.out.println("3. Login (Open)");
                System.out.println("4. Exit");

            } else {

            	System.out.println("1. Profile Management");
            	System.out.println("2. Create Contact");
            	System.out.println("3. View Contact");
            	System.out.println("4. Edit Contact");
            	System.out.println("5. Logout");
            	System.out.println("6. Exit");
            }

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (SessionManager.getInstance().getCurrentUser() == null) {

                switch (choice) {
                    case 1 -> registerUser();
                    case 2 -> basicLogin();
                    case 3 -> openLogin();
                    case 4 -> {
                        System.out.println("Exiting application...");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }

            } else {

                switch (choice) {
                    case 1 -> profileManagement();
                    case 2 -> createContact();
                    case 3 -> ViewContact.viewContact();
                    case 4 -> EditContact.editContact();
                    case 5 -> logout();
                    case 6 -> {
                        System.out.println("Exiting application...");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
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

    
    // Basic Login
   

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

    
    // Open Login
    

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

   
    // Profile Management
    

    private static void profileManagement() {

        User currentUser = SessionManager.getInstance().getCurrentUser();

        ProfileManager manager = new ProfileManager();

        System.out.println("\n=== Profile Management ===");
        System.out.println("1. Update Name");
        System.out.println("2. Update Email");
        System.out.println("3. Change Password");
        System.out.println("4. Update Preference");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1 -> {
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                manager.executeCommand(new UpdateName(currentUser, newName));
            }

            case 2 -> {
                System.out.print("Enter new email: ");
                String newEmail = sc.nextLine();
                manager.executeCommand(new UpdateEmail(currentUser, newEmail));
            }

            case 3 -> {
                System.out.print("Enter old password: ");
                String oldPassword = sc.nextLine();

                System.out.print("Enter new password: ");
                String newPassword = sc.nextLine();

                manager.executeCommand(
                    new ChangePassword(currentUser, oldPassword, newPassword)
                );
            }

            case 4 -> {
                System.out.print("Enter preference: ");
                String pref = sc.nextLine();
                manager.executeCommand(new UpdatePreference(currentUser, pref));
            }

            default -> System.out.println("Invalid choice");
        }
    }
    
    private static void createContact() {

        User currentUser = SessionManager.getInstance().getCurrentUser();

        if (currentUser == null) {
            System.out.println("Please login first");
            return;
        }

        System.out.print("Enter Contact Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Type (person/organization): ");
        String type = sc.nextLine();

        List<PhoneNumber> phones = new java.util.ArrayList<>();
        try {
            phones.add(new PhoneNumber(phone));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
//        phones.add(new PhoneNumber(phone));

        List<EmailAddress> emails = new java.util.ArrayList<>();
        emails.add(new EmailAddress(email));

        Contact contact = new ContactBuilder()
                .setName(name)
                .setPhones(phones)
                .setEmails(emails)
                .build(type);

        ContactManager manager = new ContactManager();

        manager.addContact(currentUser.getUsername(), contact);
    }

    
    // Logout
    
    private static void logout() {

        SessionManager.getInstance().logout();

        System.out.println("Logged out successfully!");
    }
}