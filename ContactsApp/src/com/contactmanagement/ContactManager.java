package com.contactmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactManager {

    public static HashMap<String, List<Contact>> userContacts = new HashMap<>();

    public void addContact(String username, Contact contact) {

        userContacts.putIfAbsent(username, new ArrayList<>());

        userContacts.get(username).add(contact);

        System.out.println("Contact added successfully");
    }

    public List<Contact> getContacts(String username) {
        return userContacts.getOrDefault(username, new ArrayList<>());
    }
}