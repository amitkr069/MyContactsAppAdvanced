package com.usermanagement;

public class PremiumUser extends User {

    public PremiumUser(String name, String username, String email, String password) {
        super(name, username, email, password);
    }

    @Override
    public void displayUserType() {
        System.out.println("Premium User Account Created");
    }
}