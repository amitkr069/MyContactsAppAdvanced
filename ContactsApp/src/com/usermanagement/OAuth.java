package com.usermanagement;

import java.util.Optional;

public class OAuth implements Authentication {

    @Override
    public Optional<User> login(String email, String password) {

        String hashedPassword = PasswordUtil.hashPassword(password);

        for (User user : UserStore.users.values()) {
            if (user.getEmail().equals(email) &&
                user.getPassword().equals(hashedPassword)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }
}