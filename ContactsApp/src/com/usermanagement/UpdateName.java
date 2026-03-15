package com.usermanagement;

public class UpdateName implements ProfileCommand {

    private User user;
    private String newName;

    public UpdateName(User user, String newName) {
        this.user = user;
        this.newName = newName;
    }

    @Override
    public void execute() {
        user.setName(newName);
        System.out.println("Name updated successfully");
    }
}