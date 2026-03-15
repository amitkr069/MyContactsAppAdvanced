package com.usermanagement;

public class UserFactory {

    public static User createUser(String type, String name, String username, String email, String password) {

        if (type.equalsIgnoreCase("free")) {
            return new FreeUser(name, username, email, password);
        } 
        else if (type.equalsIgnoreCase("premium")) {
            return new PremiumUser(name, username, email, password);
        } 
        else {
            throw new IllegalArgumentException("Invalid user type");
        }
    }
}