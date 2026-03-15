package com.usermanagement;

import java.util.Optional;

//Strategy pattern
public interface Authentication {
    Optional<User> login(String id, String password);
}