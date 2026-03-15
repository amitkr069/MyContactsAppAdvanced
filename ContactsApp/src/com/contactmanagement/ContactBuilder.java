package com.contactmanagement;

import java.util.List;

public class ContactBuilder {

    private String name;
    private List<PhoneNumber> phones;
    private List<EmailAddress> emails;

    public ContactBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ContactBuilder setPhones(List<PhoneNumber> phones) {
        this.phones = phones;
        return this;
    }

    public ContactBuilder setEmails(List<EmailAddress> emails) {
        this.emails = emails;
        return this;
    }

    public Contact build(String type) {
        return ContactFactory.createContact(type, name, phones, emails);
    }
}