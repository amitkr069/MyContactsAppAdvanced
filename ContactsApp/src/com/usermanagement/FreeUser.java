package com.usermanagement;

public class FreeUser extends User {

    public FreeUser(String name, String username, String email, String password) {
        super(name, username, email, password);
    }

    @Override
    public void displayUserType() {
        System.out.println("Free User Account Created");
    }
}