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
    
    public Contact findContact(String username, String name) {

        for (Contact c : userContacts.getOrDefault(username, new ArrayList<>())) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }

        return null;
    }
    
    // edit contact
    public void replaceContact(String username, Contact oldContact, Contact newContact) {

        List<Contact> contacts = userContacts.get(username);

        int index = contacts.indexOf(oldContact);

        if (index != -1) {
            contacts.set(index, newContact);
        }
    }
    
    // delete cotact
    public boolean deleteContact(String username, Contact contact) {

        List<Contact> contacts = userContacts.get(username);

        if (contacts != null) {
            return contacts.remove(contact);
        }

        return false;
    }
}