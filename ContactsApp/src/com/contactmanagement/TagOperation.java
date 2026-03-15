package com.contactmanagement;
import com.usermanagement.*;

import java.util.Scanner;
import java.util.List;
import java.util.Set;
public class TagOperation {
	static Scanner sc = new Scanner(System.in);
	public void createTag() {
		
	    TagManager manager = new TagManager();

	    System.out.print("Enter tag name: ");
	    String name = sc.nextLine();

	    try {
	        boolean created = manager.createTag(name);

	        if (created) {
	            System.out.println("Tag created successfully");
	        } else {
	            System.out.println("Tag already exists");
	        }

	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	public void viewTags() {

	    TagManager manager = new TagManager();

	    System.out.println("\nAvailable Tags:");

	    for (Tag tag : manager.getAllTags()) {
	        System.out.println(tag);
	    }
	}
	
	public void applyTagsToContact() {

	    User currentUser = SessionManager.getInstance().getCurrentUser();

	    ContactManager manager = new ContactManager();

	    List<Contact> contacts = manager.getContacts(currentUser.getUsername());

	    if (contacts.isEmpty()) {
	        System.out.println("No contacts available");
	        return;
	    }

	    ViewContact.displayAllContacts(contacts);

	    System.out.print("Select contact number: ");
	    int index = Integer.parseInt(sc.nextLine()) - 1;

	    if (index < 0 || index >= contacts.size()) {
	        System.out.println("Invalid contact number");
	        return;
	    }

	    Contact contact = contacts.get(index);

	    TagManager tagManager = new TagManager();

	    Set<Tag> allTags = tagManager.getAllTags();

	    if (allTags.isEmpty()) {
	        System.out.println("No tags available");
	        return;
	    }

	    System.out.println("\nAvailable Tags:");

	    for (Tag tag : allTags) {
	        System.out.println(tag);
	    }

	    System.out.print("Enter tags to add (comma separated): ");
	    String input = sc.nextLine();

	    String[] parts = input.split(",");

	    for (String p : parts) {
	        Tag tag = TagFactory.getTag(p.trim());

	        if (allTags.contains(tag)) {
	            contact.addTag(tag);
	        }
	    }

	    System.out.println("Tags added successfully");
	}
	
	public void removeTagsFromContact() {

	    User currentUser = SessionManager.getInstance().getCurrentUser();

	    ContactManager manager = new ContactManager();

	    List<Contact> contacts = manager.getContacts(currentUser.getUsername());

	    if (contacts.isEmpty()) {
	        System.out.println("No contacts available");
	        return;
	    }

	    ViewContact.displayAllContacts(contacts);

	    System.out.print("Select contact number: ");
	    int index = Integer.parseInt(sc.nextLine()) - 1;

	    if (index < 0 || index >= contacts.size()) {
	        System.out.println("Invalid contact number");
	        return;
	    }

	    Contact contact = contacts.get(index);

	    if (contact.getTags().isEmpty()) {
	        System.out.println("No tags assigned");
	        return;
	    }

	    System.out.println("Current Tags: " + contact.getTags());

	    System.out.print("Enter tag to remove: ");
	    String name = sc.nextLine();

	    contact.removeTag(TagFactory.getTag(name));

	    System.out.println("Tag removed successfully");
	}
}
