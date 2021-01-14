/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package strategy.exercise1;

public class TrustTaxStrategy implements TaxStrategy {
    private static final double RATE = 0.35;

    public double extortCash(double income) {
        return income * RATE;
    }
}
