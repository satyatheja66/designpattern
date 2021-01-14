/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package playground.memento.demo2;

import java.util.*;
import java.util.concurrent.*;

public class BigCompany {
    private final Map<Employee, Deque<Memento>> history =
        new ConcurrentHashMap<>();

    public void promote(Employee employee) {
        snapshot(employee);
        employee.promote();
    }

    public void pay(Employee employee) {
        snapshot(employee);
        employee.pay();
    }

    private void snapshot(Employee employee) {
        Memento memento = employee.createMemento();
        history.computeIfAbsent(employee, k -> new ConcurrentLinkedDeque<>())
            .addLast(memento);
    }

    public void undo(Employee employee) {
        Memento m = history.getOrDefault(employee, new ArrayDeque<>()).pollLast();
        if (m != null) employee.setMemento(m);
    }
}
