/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package playground.memento.demo3;

public class MementoDemo {
    public static void main(String... args) {
        BigCompany bc = new BigCompany();

        Employee heinz = new Employee();
//                        TESTER  $1000  $ 2000
        bc.pay(heinz);     //     TESTER  $1000  $ 3000
        bc.pay(heinz);     //     TESTER  $1000  $ 4000
        bc.promote(heinz); // PROGRAMMER  $1400  $ 4000
        bc.pay(heinz);     // PROGRAMMER  $1400  $ 5400
        bc.pay(heinz);     // PROGRAMMER  $1400  $ 6800
        bc.promote(heinz); //    MANAGER  $4200  $ 6800
        bc.undo(heinz);    // PROGRAMMER  $1400  $ 6800
        bc.undo(heinz);    // PROGRAMMER  $1400  $ 5400
        bc.pay(heinz);     // PROGRAMMER  $1400  $ 6800
        bc.pay(heinz);     // PROGRAMMER  $1400  $ 8200
        bc.promote(heinz); //    MANAGER  $4200  $ 8200
        bc.pay(heinz);     //    MANAGER  $4200  $12400

        System.out.println("heinz = " + heinz);

        ///*
        Employee hk = new Employee();
        System.out.println("hk = " + hk);
        hk.setMemento(heinz.createMemento());
        System.out.println("hk = " + hk);
         //*/
    }
}
