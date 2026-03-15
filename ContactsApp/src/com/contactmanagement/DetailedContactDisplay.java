package com.contactmanagement;

import java.util.Optional;

public class DetailedContactDisplay extends ContactDisplayDecorator {

    private Contact contact;

    public DetailedContactDisplay(ContactDisplay decoratedDisplay, Contact contact) {
        super(decoratedDisplay);
        this.contact = contact;
    }

    @Override
    public String show() {

        StringBuilder sb = new StringBuilder();

        sb.append(decoratedDisplay.show());

        sb.append("\nPhone Numbers: ");

        for (PhoneNumber p : contact.getPhoneNumbers()) {
            sb.append(p.getNumber()).append(" ");
        }

        sb.append("\nEmails: ");

        for (EmailAddress e : contact.getEmailAddresses()) {
            sb.append(Optional.ofNullable(e.getEmail()).orElse("No Email")).append(" ");
        }

        return sb.toString();
    }
}