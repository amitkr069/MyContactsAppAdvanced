package com.contactmanagement;

public abstract class ContactDisplayDecorator implements ContactDisplay {

    protected ContactDisplay decoratedDisplay;

    public ContactDisplayDecorator(ContactDisplay decoratedDisplay) {
        this.decoratedDisplay = decoratedDisplay;
    }
}