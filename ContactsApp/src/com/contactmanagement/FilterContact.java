package com.contactmanagement;

import com.usermanagement.*;
import java.util.*;
import com.searchfilter.*;
public class FilterContact {
	public static void filterByDateAdded() {

	    User currentUser = SessionManager.getInstance().getCurrentUser();

	    ContactManager manager = new ContactManager();

	    List<Contact> contacts = manager.getContacts(currentUser.getUsername());

	    if (contacts.isEmpty()) {
	        System.out.println("No contacts available");
	        return;
	    }

	    ContactFilter filter = new DateFilter();

	    List<Contact> filteredContacts = filter.apply(contacts);

	    System.out.println("\nContacts Sorted By Date Added:");

	    ViewContact.displayAllContacts(filteredContacts);
	}
}
