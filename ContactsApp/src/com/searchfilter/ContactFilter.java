package com.searchfilter;

import java.util.List;
import com.contactmanagement.*;

public interface ContactFilter {
    List<Contact> apply(List<Contact> contacts);
}