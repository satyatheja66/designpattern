/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package playground.memento.demo1;

public class MementoDemoSimpler {
    public static void main(String... args) {
        Employee heinz = new Employee();
        Memento m = heinz.createMemento();
        heinz = null;
        for (int i = 0; i < 10; i++) {
            System.gc();
        }
    }
}
