package com.main;

import java.util.Scanner;
import com.usermanagement.*;

public class MyContacts {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            System.out.print("Enter User Type (free/premium): ");
            String type = sc.nextLine();

            UserRegistration reg = new UserRegistration();

            User user = reg.registerUser(name, username, email, password, type);

            System.out.println("\nRegistration Successful");
            System.out.println("Name: " + user.getName());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());

            user.displayUserType();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}