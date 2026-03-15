package com.usermanagement;

public class UpdatePreference implements ProfileCommand {

    private User user;
    private String preference;

    public UpdatePreference(User user, String preference) {
        this.user = user;
        this.preference = preference;
    }

    @Override
    public void execute() {
        user.setPreference(preference);
        System.out.println("Preference updated successfully");
    }
}