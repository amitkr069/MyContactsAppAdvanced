package com.contactmanagement;

import com.usermanagement.*;
import java.util.*;

public class DeleteContact {
	public static void deleteContact() {
		Scanner sc = new Scanner(System.in);
		
	    User currentUser = SessionManager.getInstance().getCurrentUser();

	    ContactManager manager = new ContactManager();

	    System.out.print("Enter contact name to delete: ");
	    String name = sc.nextLine();

	    Contact contact = manager.findContact(currentUser.getUsername(), name);

	    if (contact == null) {
	        System.out.println("Contact not found");
	        return;
	    }

	    System.out.print("Enter your password for confirmation: ");
	    String password = sc.nextLine();

	    if (!currentUser.checkPassword(password)) {
	        System.out.println("Incorrect password. Delete cancelled.");
	        return;
	    }

	    Delete delete = new DeleteLogger();

	    boolean removed = manager.deleteContact(currentUser.getUsername(), contact);

	    if (removed) {
	        delete.onDelete(contact);
	        System.out.println("Contact deleted successfully!");
	    } else {
	        System.out.println("Delete failed");
	    }
	}
}
