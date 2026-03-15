package com.usermanagement;

public class ProfileManager {

    public void executeCommand(ProfileCommand command) {
        command.execute();
    }
}