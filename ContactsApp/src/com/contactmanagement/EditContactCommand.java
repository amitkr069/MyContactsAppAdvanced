package com.contactmanagement;

import java.util.List;

public class EditContactCommand {

    private Contact contact;
    private ContactHistory history;

    public EditContactCommand(Contact contact, ContactHistory history) {
        this.contact = contact;
        this.history = history;
    }

    public void execute(String newName, List<PhoneNumber> phones, List<EmailAddress> emails) {

        history.save(contact);

        contact.setName(newName);
        contact.setPhoneNumbers(phones);
        contact.setEmailAddresses(emails);
    }

    public Contact undo() {
        return history.undo();
    }
}