package com.contactmanagement;

import com.usermanagement.*;
import java.util.Scanner;

public class ViewContact {
	public static void viewContact() {
		
		Scanner sc = new Scanner(System.in);
	    User currentUser = SessionManager.getInstance().getCurrentUser();

	    ContactManager manager = new ContactManager();

	    System.out.print("Enter contact name: ");
	    String name = sc.nextLine();

	    Contact contact = manager.findContact(currentUser.getUsername(), name);

	    if (contact == null) {
	        System.out.println("Contact not found");
	        return;
	    }

	    ContactDisplay display =
	            new DetailedContactDisplay(
	                    new BasicContactDisplay(contact),
	                    contact
	            );

	    System.out.println("\n=== Contact Details ===");
	    System.out.println(display.show());
	}
}
