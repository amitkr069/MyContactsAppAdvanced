package com.contactmanagement;

public class DeleteLogger implements Delete {

    @Override
    public void onDelete(Contact contact) {
        System.out.println("Observer: Contact deleted -> " + contact.getName());
    }
}