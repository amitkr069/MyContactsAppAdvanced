package com.contactmanagement;

import java.util.List;

public class PersonContact extends Contact {

    public PersonContact(String name, List<PhoneNumber> phones, List<EmailAddress> emails) {
        super(name, phones, emails);
    }

    @Override
    public void displayType() {
        System.out.println("Person Contact");
    }
}