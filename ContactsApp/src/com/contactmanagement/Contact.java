package com.contactmanagement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public abstract class Contact {

    private String contactId;
    private String name;
    private List<PhoneNumber> phoneNumbers;
    private List<EmailAddress> emailAddresses;
    private LocalDateTime createdAt;

    public Contact(String name, List<PhoneNumber> phoneNumbers, List<EmailAddress> emailAddresses) {
        this.contactId = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.emailAddresses = emailAddresses;
        this.createdAt = LocalDateTime.now();
    }

    public String getContactId() {
        return contactId;
    }

    public String getName() {
        return name;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public List<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public abstract void displayType();

    @Override
    public String toString() {
        return "ID: " + contactId +
               "\nName: " + name +
               "\nCreated At: " + createdAt;
    }
}