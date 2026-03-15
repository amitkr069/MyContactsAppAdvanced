package com.searchfilter;

import com.contactmanagement.*;

public class PhoneCriteria implements SearchCriteria {

    @Override
    public boolean matches(Contact contact, String keyword) {

        return contact.getPhoneNumbers().stream()
                .anyMatch(p -> p.getNumber().matches(".*" + keyword + ".*"));
    }
}