package com.usermanagement;

public class ValidationUtil {

    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 6;
    }

    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z0-9_]{4,15}$");
    }
}