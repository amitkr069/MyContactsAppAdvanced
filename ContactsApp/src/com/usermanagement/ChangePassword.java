package com.usermanagement;

public class ChangePassword implements ProfileCommand {

    private User user;
    private String oldPassword;
    private String newPassword;

    public ChangePassword(User user, String oldPassword, String newPassword) {
        this.user = user;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    @Override
    public void execute() {

        String hashedOldPassword = PasswordUtil.hashPassword(oldPassword);

        if (!user.getPassword().equals(hashedOldPassword)) {
            System.out.println("Old password is incorrect");
            return;
        }

        user.setPassword(newPassword);

        System.out.println("Password changed successfully");
    }
}