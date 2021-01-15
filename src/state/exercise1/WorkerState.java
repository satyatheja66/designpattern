/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package state.exercise1;

public abstract class WorkerState extends State {
    public void fire(StateModifier sm) {
        sm.setState(END);
    }
}
