/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package strategy.exercise1;

import java.util.*;

public class TaxPayer {
    public static final TaxStrategy COMPANY = new CompanyTaxStrategy();
    public static final TaxStrategy EMPLOYEE = new EmployeeTaxStrategy();
    public static final TaxStrategy TRUST = new TrustTaxStrategy();

    private final double income;
    private final TaxStrategy taxStrategy;

    public TaxPayer(TaxStrategy taxStrategy, double income) {
        this.taxStrategy = Objects.requireNonNull(taxStrategy);
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public double extortCash() {
        return taxStrategy.extortCash(income);
    }
}
