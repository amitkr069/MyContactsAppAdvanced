package com.searchfilter;
import com.contactmanagement.*;


public class TagSearchCriteria implements SearchCriteria {

    @Override
    public boolean matches(Contact contact, String keyword) {

        for (Tag tag : contact.getTags()) {
            if (tag.getName().equalsIgnoreCase(keyword)) {
                return true;
            }
        }

        return false;
    }
}