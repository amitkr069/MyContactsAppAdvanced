package com.contactmanagement;

import com.usermanagement.*;
import java.util.Scanner;
import java.util.List;
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
	
	public static void displayAllContacts(List<Contact> contacts) {

	    if (contacts.isEmpty()) {
	        System.out.println("No contacts available");
	        return;
	    }

	    System.out.println("\nYour Contacts:");

	    for (int i = 0; i < contacts.size(); i++) {

	        Contact c = contacts.get(i);

	        System.out.println((i + 1) + ". " + c.getName());

	        for (PhoneNumber p : c.getPhoneNumbers()) {
	            System.out.println("   Phone: " + p.getNumber());
	        }

	        for (EmailAddress e : c.getEmailAddresses()) {
	            System.out.println("   Email: " + e.getEmail());
	        }
	        
	        System.out.println("   Tags: " + c.getTags());
	    }
	}
}
