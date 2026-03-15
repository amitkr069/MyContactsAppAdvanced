package com.contactmanagement;

public class ContactMemento {

    private Contact savedState;

    public ContactMemento(Contact contact) {
        this.savedState = contact;
    }

    public Contact getSavedState() {
        return savedState;
    }
}