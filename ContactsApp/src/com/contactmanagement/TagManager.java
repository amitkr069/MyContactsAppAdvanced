package com.contactmanagement;

import java.util.HashSet;
import java.util.Set;

public class TagManager {

    private static Set<Tag> tags = new HashSet<>();

    public boolean createTag(String name) {

        Tag tag = TagFactory.getTag(name);

        if (tags.contains(tag)) {
            return false;
        }

        tags.add(tag);
        return true;
    }

    public Set<Tag> getAllTags() {
        return new HashSet<>(tags);
    }
}