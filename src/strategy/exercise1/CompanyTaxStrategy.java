/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package strategy.exercise1;

public final class CompanyTaxStrategy extends NonNaturalTaxStrategy {
    private static final double RATE = 0.30;

    public double extortCash(double income) { // extrinsic
        return income * RATE;
    }
}
