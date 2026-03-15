package com.searchfilter;

import com.contactmanagement.*;
import java.util.List;

public class TagFilter implements ContactFilter {

    private String keyword;

    public TagFilter(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public List<Contact> apply(List<Contact> contacts) {

        return contacts.stream()
                .filter(contact -> contact.getTags().stream()
                        .anyMatch(tag -> tag.getName().equalsIgnoreCase(keyword)))
                .toList();
    }
}
