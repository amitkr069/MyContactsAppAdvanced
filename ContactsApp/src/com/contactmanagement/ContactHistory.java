package com.contactmanagement;

import java.util.Stack;

public class ContactHistory {

    private Stack<ContactMemento> history = new Stack<>();

    public void save(Contact contact) {
        history.push(new ContactMemento(contact));
    }

    public Contact undo() {
        if (!history.isEmpty()) {
            return history.pop().getSavedState();
        }
        return null;
    }
}