/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package composite.exercise1;

import java.util.*;

/**
 * This ContactIterator should iterate through the composite tree structure
 * without first building up a list of elements.  It thus figures out on-the-fly
 * whether there is a next element or not.
 */
public class ContactIterator implements Iterator<Contact> {
    private final Deque<Iterator<Contact>> unfinishedIterators = new ArrayDeque<>();
    private Contact nextContact;
    private boolean readyForRemove = false;
    private Iterator<Contact> iterator;

    public ContactIterator(Contact contact) {
        if (contact.isLeaf()) nextContact = contact;
        else unfinishedIterators.addLast(contact.children());
    }

    public boolean hasNext() {
        if (nextContact == null) {
            nextContact = findNextContact();
        }
        return nextContact != null;
    }

    private Contact findNextContact() {
        while(!unfinishedIterators.isEmpty()) {
            iterator = unfinishedIterators.peekLast();
            if (iterator.hasNext()) {
                Contact contact = iterator.next();
                if (contact.isLeaf()) return contact;
                else unfinishedIterators.addLast(contact.children());
            } else {
                unfinishedIterators.removeLast();
            }
        }
        return null;
    }

    public Contact next() {
        if (!hasNext()) throw new NoSuchElementException();
        Contact result = nextContact;
        nextContact = null;
        readyForRemove = true;
        return result;
    }

    /**
     * This should throw an IllegalStateException if the root node of the
     * ContactIterator is a leaf; otherwise it should remove the element from
     * the composite tree structure.
     */
    public void remove() {
        if (!readyForRemove) throw new IllegalStateException();
        if (iterator == null) throw new IllegalStateException(); // root was a leaf
        iterator.remove();
        readyForRemove = false;
    }
}
