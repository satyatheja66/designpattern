/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package state.exercise1;

public class RetireeState extends State {
    public int pay(StateModifier sm) {
        System.out.println("Handing out crumbs to retiree");
        return 5000;
    }

    public void advance(StateModifier sm) {
        sm.setState(new EndState());
    }
}
