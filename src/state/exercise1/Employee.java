/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package state.exercise1;

/**
 * Code without clear state machine transitions.  It is very
 * ugly.  Your job is to use the state pattern to clean things
 * up.
 */
public class Employee {
    private State state = new ProgrammerState();
    private final State.StateModifier sm = new State.StateModifier() {
        public void setState(State state) {
            Employee.this.setState(state);
        }
    };

    public int pay() {
        return state.pay(sm);
    }

    public void advance() {
        state.advance(sm);
    }

    public void fire() {
        state.fire(sm);
    }

    private void setState(State state) {
        System.out.println(this.state.getClass().getSimpleName() + " -> " +
            state.getClass().getSimpleName());
        this.state = state;
    }
}
