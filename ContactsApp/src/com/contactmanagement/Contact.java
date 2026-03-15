package com.contactmanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.UUID;

public abstract class Contact {

    private String contactId;
    private String name;
    private List<PhoneNumber> phoneNumbers;
    private List<EmailAddress> emailAddresses;
    private LocalDateTime createdAt;
    private Set<Tag> tags = new HashSet<>();

    public Contact(String name, List<PhoneNumber> phoneNumbers,
            List<EmailAddress> emailAddresses) {

		 this.contactId = UUID.randomUUID().toString();
		 this.name = name;
		 this.phoneNumbers = new ArrayList<>(phoneNumbers);
		 this.emailAddresses = new ArrayList<>(emailAddresses);
		 this.createdAt = LocalDateTime.now();
    }

    // Copy Constructor
    public Contact(Contact other) {
        this.contactId = other.contactId;
        this.name = other.name;
        this.phoneNumbers = new ArrayList<>(other.phoneNumbers);
        this.emailAddresses = new ArrayList<>(other.emailAddresses);
        this.createdAt = other.createdAt;
    }

    public String getContactId() {
        return contactId;
    }

    public String getName() {
        return name;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return new ArrayList<>(phoneNumbers);
    }

    public List<EmailAddress> getEmailAddresses() {
        return new ArrayList<>(emailAddresses);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public Set<Tag> getTags() {
        return new HashSet<>(tags);
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = new ArrayList<>(phoneNumbers);
    }

    public void setEmailAddresses(List<EmailAddress> emailAddresses) {
        this.emailAddresses = new ArrayList<>(emailAddresses);
    }
    
    public void addTag(Tag tag) {
        tags.add(tag);
    }
    
    public void removeTag(Tag tag) {
        tags.remove(tag);
    }

    public abstract void displayType();

    @Override
    public String toString() {
        return
               "\nName: " + name +
               "\nCreated At: " + createdAt;
    }
}