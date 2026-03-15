package com.usermanagement;

import java.util.Optional;

public class BasicAuth implements Authentication {

    @Override
    public Optional<User> login(String username, String password) {

        String hashedPassword = PasswordUtil.hashPassword(password);

        for (User user : UserStore.users.values()) {
            if (user.getUsername().equals(username) &&
                user.getPassword().equals(hashedPassword)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }
}