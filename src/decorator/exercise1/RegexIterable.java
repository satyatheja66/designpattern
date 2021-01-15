/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package decorator.exercise1;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class RegexIterable<T> implements Iterable<T> {
    private final Iterable<T> it;
    private final Pattern pattern;

    // at construction, we build up a new list and add all those
    // objects whose toString() method matches the regular expression
    // Our iterator then simply walks over that list.  remove() should not be
    // allowed
    public RegexIterable(Iterable<T> it, String regex) {
        this.it = it;
        pattern = Pattern.compile(regex);
    }

    private boolean matches(String input) {
        return pattern.matcher(input).matches();
    }

    public Iterator<T> iterator() {
        return StreamSupport.stream(it.spliterator(), false)
            .filter(obj -> matches(String.valueOf(obj)))
            .iterator();
    }
}
