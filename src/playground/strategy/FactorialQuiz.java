/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2021, Heinz Kabutz, All rights reserved.
 */

package playground.strategy;

import java.math.*;
import java.util.stream.*;

public class FactorialQuiz {
    public static void main(String... args) {
        for (int i = 0; i < 10; i++) {
            test();
        }
    }

    private static void test() {
        long time = System.nanoTime();
        try {
            BigInteger result = LongStream.rangeClosed(1, 200_000)
                // 12 seconds for 1 thread, how much for 16 threads on 8 cores?
                .mapToObj(BigInteger::valueOf)
                .parallel()
                .reduce(BigInteger.ONE, BigInteger::multiply);
            System.out.println(result.bitCount());
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
    }
}
