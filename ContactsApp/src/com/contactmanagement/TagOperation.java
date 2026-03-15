package com.contactmanagement;
import java.util.Scanner;
public class TagOperation {
	public void createTag() {
		Scanner sc = new Scanner(System.in);
		
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
}
