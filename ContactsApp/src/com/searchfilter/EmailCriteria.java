package com.searchfilter;
import com.contactmanagement.*;

public class EmailCriteria implements SearchCriteria {

    @Override
    public boolean matches(Contact contact, String keyword) {

        return contact.getEmailAddresses().stream()
                .anyMatch(e -> e.getEmail().toLowerCase().contains(keyword.toLowerCase()));
    }
}