package com.contactmanagement;

import java.util.List;

public class OrganizationContact extends Contact {

    public OrganizationContact(String name, List<PhoneNumber> phones, List<EmailAddress> emails) {
        super(name, phones, emails);
    }

    @Override
    public void displayType() {
        System.out.println("Organization Contact");
    }
}