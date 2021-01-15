/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package state.exercise1;

public final class ManagerState extends WorkerState {
    public int pay() {
        System.out.println("Paying lots of $$$ to manager");
        return 30000;
    }

    public State advance() {
        return RETIREE;
    }
}
