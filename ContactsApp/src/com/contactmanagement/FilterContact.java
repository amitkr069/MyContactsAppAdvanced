package com.contactmanagement;

import com.usermanagement.*;
import java.util.*;
import com.searchfilter.*;

import java.util.Scanner;

public class FilterContact {
	public static void filterContacts() {
		Scanner sc = new Scanner(System.in);
		
	    User currentUser = SessionManager.getInstance().getCurrentUser();

	    ContactManager manager = new ContactManager();

	    List<Contact> contacts = manager.getContacts(currentUser.getUsername());

	    if (contacts.isEmpty()) {
	        System.out.println("No contacts available");
	        return;
	    }

	    System.out.println("1. Filter by Date Added");
	    System.out.println("2. Filter by Tag");

	    int choice = Integer.parseInt(sc.nextLine());

	    ContactFilter filter = null;

	    switch (choice) {

	        case 1 -> filter = new DateFilter();

	        case 2 -> {
	            System.out.print("Enter tag: ");
	            String tag = sc.nextLine();
	            filter = new TagFilter(tag);
	        }

	        default -> {
	            System.out.println("Invalid choice");
	            return;
	        }
	    }

	    List<Contact> filtered = filter.apply(contacts);

	    ViewContact.displayAllContacts(filtered);
	}
}
