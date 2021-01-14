/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package proxy.exercise1;

//DON'T CHANGE
public abstract class Scandinavian {
    private final Lutefisk lutefisk = new VirtualLutefisk();

    public abstract void work();

    public abstract void learn();

    public abstract void celebrateChristmas();

    public abstract void entertain();

    protected void eatLutefisk() {
        lutefisk.eat();
    }
}
