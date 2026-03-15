package com.searchfilter;


import java.util.Comparator;
import java.util.List;
import com.contactmanagement.*;

public class DateFilter implements ContactFilter {

    @Override
    public List<Contact> apply(List<Contact> contacts) {

        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getCreatedAt).reversed())
                .toList();
    }
}