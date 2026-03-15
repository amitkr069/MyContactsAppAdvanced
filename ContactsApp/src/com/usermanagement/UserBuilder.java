package com.usermanagement;

public class UserBuilder {
    private String name;
    private String username;
    private String email;
    private String password;

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public User build(String type) {
        return UserFactory.createUser(type, name, username, email, password);
    }
}