package com.contactmanagement;

import java.util.List;
import java.util.Set;
public class PersonContact extends Contact {

	public PersonContact(String name, List<PhoneNumber> phoneNumbers,
            List<EmailAddress> emailAddresses) {

			super(name, phoneNumbers, emailAddresses);
	}

    @Override
    public void displayType() {
        System.out.println("Person Contact");
    }
}