package com.contactmanagement;

import com.usermanagement.*;
import com.searchfilter.*;
import java.util.*;

public class SearchContact {
	public static void searchContacts() {
		Scanner sc = new Scanner(System.in);

	    User currentUser = SessionManager.getInstance().getCurrentUser();

	    ContactManager manager = new ContactManager();

	    System.out.println("\nSearch By:");
	    System.out.println("1. Name");
	    System.out.println("2. Phone");
	    System.out.println("3. Email");

	    int choice = sc.nextInt();
	    sc.nextLine();

	    System.out.print("Enter keyword: ");
	    String keyword = sc.nextLine();

	    SearchCriteria criteria = null;

	    switch (choice) {
	        case 1 -> criteria = new NameCriteria();
	        case 2 -> criteria = new PhoneCriteria();
	        case 3 -> criteria = new EmailCriteria();
	        default -> {
	            System.out.println("Invalid choice");
	            return;
	        }
	    }

	    List<Contact> results = manager.searchContacts(
	            currentUser.getUsername(),
	            criteria,
	            keyword
	    );

	    if (results.isEmpty()) {
	        System.out.println("No contacts found");
	        return;
	    }

	    ViewContact.displayAllContacts(results);
	}
}
