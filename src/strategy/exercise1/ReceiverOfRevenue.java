/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package strategy.exercise1;

//DON'T CHANGE
public class ReceiverOfRevenue {
    public static void main(String... args) {
        TaxPayer heinz, maxsol, family;
        heinz = new TaxPayer(TaxPayer.EMPLOYEE, 50000);
        maxsol = new TaxPayer(TaxPayer.COMPANY, 100000);
        family = new TaxPayer(TaxPayer.TRUST, 30000);
        System.out.println(heinz.extortCash());
        System.out.println(maxsol.extortCash());
        System.out.println(family.extortCash());
        // TaxPayer anon = new TaxPayer(new TaxStrategy() {
        //     public double extortCash(double income) {
        //         return 0;
        //     }
        // }, 100_000_000_000.0);
        // System.out.println(anon.extortCash());
    }
}
