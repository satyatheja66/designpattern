/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package strategy.exercise1;

public class CompanyTaxStrategy implements TaxStrategy {
    private static final double RATE = 0.30;
    private static final double EMPLOYEE_RATE = 0.45;
    private static final double TRUST_RATE = 0.35;
    private final double income;

    public CompanyTaxStrategy(double income) {
        this.income = income;
    }

    public double extortCash() {
        return income * RATE;
    }
}
