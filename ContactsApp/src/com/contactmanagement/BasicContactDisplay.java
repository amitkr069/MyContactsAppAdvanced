package com.contactmanagement;

public class BasicContactDisplay implements ContactDisplay {

    protected Contact contact;

    public BasicContactDisplay(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String show() {
        return contact.toString();
    }
}