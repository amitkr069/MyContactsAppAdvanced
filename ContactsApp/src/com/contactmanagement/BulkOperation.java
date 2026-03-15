package com.contactmanagement;

import com.usermanagement.*;
import java.util.*;
public class BulkOperation {
	public static void bulkDeleteContacts() {
		Scanner sc = new Scanner(System.in);
		
	    User currentUser = SessionManager.getInstance().getCurrentUser();

	    ContactManager manager = new ContactManager();

	    List<Contact> userContacts = manager.getContacts(currentUser.getUsername());

	    ViewContact.displayAllContacts(userContacts);

	    if (userContacts.isEmpty()) {
	        return;
	    }

	    System.out.print("\nEnter indexes to delete (comma separated): ");
	    String input = sc.nextLine();

	    String[] parts = input.split(",");

	    List<Contact> contactsToDelete = new ArrayList<>();

	    try {

	        for (String part : parts) {

	            int index = Integer.parseInt(part.trim()) - 1;

	            if (index >= 0 && index < userContacts.size()) {
	                contactsToDelete.add(userContacts.get(index));
	            }
	        }

	        if (contactsToDelete.isEmpty()) {
	            System.out.println("No valid contacts selected");
	            return;
	        }

	        System.out.print("Enter password for confirmation: ");
	        String password = sc.nextLine();

	        if (!currentUser.checkPassword(password)) {
	            System.out.println("Incorrect password");
	            return;
	        }

	        ContactGroup group = new ContactGroup(contactsToDelete);

	        manager.bulkDelete(currentUser.getUsername(), group.getContacts());

	        Delete delete = new DeleteLogger();

	        group.getContacts().forEach(delete::onDelete);

	        System.out.println("Bulk delete successful!");

	    } catch (Exception e) {
	        System.out.println("Invalid input");
	    }
	}
}
