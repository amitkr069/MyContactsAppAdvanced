package com.searchfilter;

import com.contactmanagement.*;
public class NameCriteria implements SearchCriteria {

    @Override
    public boolean matches(Contact contact, String keyword) {

        return contact.getName()
                .toLowerCase()
                .matches(".*" + keyword.toLowerCase() + ".*");
    }
}
