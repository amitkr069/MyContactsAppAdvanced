package com.searchfilter;
import com.contactmanagement.*;

public interface SearchCriteria {
    boolean matches(Contact contact, String keyword);
}