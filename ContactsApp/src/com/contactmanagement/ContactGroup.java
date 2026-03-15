package com.contactmanagement;

import java.util.List;

public class ContactGroup {

    private List<Contact> contacts;

    public ContactGroup(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}