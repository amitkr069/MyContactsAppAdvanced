package com.usermanagement;

public class UserRegistration {

    public User registerUser(String name, String username, String email, String password, String type) {

        if (!ValidationUtil.isValidUsername(username)) {
            throw new IllegalArgumentException("Invalid Username");
        }

        if (!ValidationUtil.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid Email Format");
        }

        if (!ValidationUtil.isValidPassword(password)) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }

        String hashedPassword = PasswordUtil.hashPassword(password);

        User user = new UserBuilder()
                .setName(name)
                .setUsername(username)
                .setEmail(email)
                .setPassword(hashedPassword)
                .build(type);

        return user;
    }
}