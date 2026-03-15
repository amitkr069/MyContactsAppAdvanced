package com.contactmanagement;

import com.usermanagement.*;
import java.util.*;
public class EditContact {
	public static void editContact() {
		
		Scanner sc = new Scanner(System.in);
	    User currentUser = SessionManager.getInstance().getCurrentUser();

	    ContactManager manager = new ContactManager();

	    System.out.print("Enter contact name to edit: ");
	    String oldName = sc.nextLine();

	    Contact contact = manager.findContact(currentUser.getUsername(), oldName);

	    if (contact == null) {
	        System.out.println("Contact not found");
	        return;
	    }

	    ContactHistory history = new ContactHistory();

	    EditContactCommand command = new EditContactCommand(contact, history);

	    try {
	        System.out.print("Enter new name: ");
	        String newName = sc.nextLine();

	        System.out.print("Enter new phone: ");
	        String phone = sc.nextLine();

	        System.out.print("Enter new email: ");
	        String email = sc.nextLine();

	        List<PhoneNumber> phones = new ArrayList<>();
	        phones.add(new PhoneNumber(phone));

	        List<EmailAddress> emails = new ArrayList<>();
	        emails.add(new EmailAddress(email));

	        command.execute(newName, phones, emails);

	        System.out.println("Contact updated successfully!");

	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
}
