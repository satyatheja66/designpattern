/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package playground.memento.demo2;

// How can we avoid having the fields twice?
public class Employee {
    public enum Position {TESTER, PROGRAMMER, MANAGER}

    private MementoImpl state = new MementoImpl(1000, 2000, Position.TESTER);

    public void pay() {
        state = new MementoImpl(
            state.salary, state.balance + state.salary, state.position
        );
    }

    public void promote() {
        state = switch (state.position) {
            case TESTER -> new MementoImpl(state.salary + 400, state.balance, Position.PROGRAMMER);
            case PROGRAMMER -> new MementoImpl(state.salary * 3, state.balance, Position.MANAGER);
            case MANAGER -> new MementoImpl((int) (state.salary * 1.5), state.balance, Position.MANAGER);
        };
    }


    public String toString() {
        return "Employee{" +
            "salary=" + state.salary +
            ", balance=" + state.balance +
            ", position=" + state.position +
            '}';
    }

    public Memento createMemento() {
        return state;
    }

    public void setMemento(Memento m) {
        this.state = (MementoImpl) m;
    }

    private static class MementoImpl implements Memento {
        private final int salary;
        private final int balance;
        private final Employee.Position position;

        public MementoImpl(int salary, int balance, Position position) {
            this.salary = salary;
            this.balance = balance;
            this.position = position;
        }
    }
}
