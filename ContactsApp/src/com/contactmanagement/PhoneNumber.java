package com.contactmanagement;

public class PhoneNumber {

    private String number;

    public PhoneNumber(String number) {

        if (!number.matches("[9876][0-9]{9}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}