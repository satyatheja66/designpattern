/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package playground.memento.demo3;

import java.lang.ref.*;

// How to avoid identity theft?
public class Employee {
    public enum Position {TESTER, PROGRAMMER, MANAGER}

    private int salary = 1000;
    private int balance = 2000;
    private Position position = Position.TESTER;

    public void pay() {
        balance += salary;
    }

    public void promote() {
        switch (position) {
            case TESTER:
                position = Position.PROGRAMMER;
                salary += 400;
                break;
            case PROGRAMMER:
                position = Position.MANAGER;
                salary *= 3;
                break;
            case MANAGER:
                salary *= 1.5;
                break;
        }
    }

    public String toString() {
        return "Employee{" +
            "salary=" + salary +
            ", balance=" + balance +
            ", position=" + position +
            '}';
    }

    public Memento createMemento() {
        return new MementoImpl(this);
    }

    public void setMemento(Memento m) {
        MementoImpl mi = (MementoImpl) m;
        if (this != mi.originator.get())
            throw new IllegalArgumentException("Originator mismatch");
        this.salary = mi.salary;
        this.balance = mi.balance;
        this.position = mi.position;
    }

    private static class MementoImpl implements Memento {
        private final int salary;
        private final int balance;
        private final Employee.Position position;
        private final Reference<Employee> originator;

        public MementoImpl(Employee employee) {
            this.salary = employee.salary;
            this.balance = employee.balance;
            this.position = employee.position;
            this.originator = new WeakReference<>(employee);
        }
    }

    protected void finalize() {
        System.out.println("Finalized");
    }
}
