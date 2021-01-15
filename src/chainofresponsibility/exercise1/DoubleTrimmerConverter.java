/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package chainofresponsibility.exercise1;

public class DoubleTrimmerConverter extends Converter {
    public DoubleTrimmerConverter(Converter next) {
        super(next);
    }

    public Object handle(Object o) {
        if (o instanceof Double) {
            // if the object is a Double, we trim to the nearest Integer,
            // but still return a Double instance
            o = (double)Math.round((Double) o);
        }
        return super.handle(o);
    }
}
