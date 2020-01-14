package com.cyberorange.console.utils;

import java.util.Collection;

public class CollectionUtils {

    public static boolean isEmpty(Collection c) {
        return c == null || c.isEmpty();
    }

    public static boolean isNotEmpty(Collection c) {
        return c != null && c.size() > 0;
    }
}
