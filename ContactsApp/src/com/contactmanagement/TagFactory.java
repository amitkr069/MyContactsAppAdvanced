package com.contactmanagement;

import java.util.HashMap;
import java.util.Map;

public class TagFactory {

    private static Map<String, Tag> tagPool = new HashMap<>();

    public static Tag getTag(String name) {

        String key = name.toLowerCase();

        if (!tagPool.containsKey(key)) {
            tagPool.put(key, new Tag(name));
        }

        return tagPool.get(key);
    }
}