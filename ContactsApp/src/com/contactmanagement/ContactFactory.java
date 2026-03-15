package com.contactmanagement;

import java.util.List;

public class ContactFactory {

    public static Contact createContact(String type, String name,
                                        List<PhoneNumber> phones,
                                        List<EmailAddress> emails) {

        if (type.equalsIgnoreCase("person")) {
            return new PersonContact(name, phones, emails);
        }
        else if (type.equalsIgnoreCase("organization")) {
            return new OrganizationContact(name, phones, emails);
        }
        else {
            throw new IllegalArgumentException("Invalid contact type");
        }
    }
}