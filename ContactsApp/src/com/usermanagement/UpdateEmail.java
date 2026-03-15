package com.usermanagement;

public class UpdateEmail implements ProfileCommand {

    private User user;
    private String newEmail;

    public UpdateEmail(User user, String newEmail) {
        this.user = user;
        this.newEmail = newEmail;
    }

    @Override
    public void execute() {
        user.setEmail(newEmail);
        System.out.println("Email updated successfully");
    }
}