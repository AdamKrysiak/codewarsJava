package com.ak.wars;

import java.util.ArrayList;

public class SumOfParts {
    // your code
    public static String convertFrac(long[][] fractions) {
        long numerator = 0;
        long denominator = 1;
        ArrayList<Long> allDenominators = getAllDenominators(fractions);
        for (long[] fraction : fractions) {
            denominator *= fraction[1];
            Long multiplicator = allDenominators.stream()
                    .filter(e -> fraction[1] != e)
                    .reduce(Math::multiplyExact)
                    .orElse(1L);

            numerator += fraction[0] * multiplicator;
        }
        denominator = determineMinimumDenominator(numerator, denominator);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fractions.length; i++) {
            result.append("(")
                    .append(Math.floorDiv(fractions[i][0] * denominator, fractions[i][1]))
                    .append(",").append(denominator)
                    .append(")");

        }
        return result.toString();
        // your code
    }

    private static ArrayList<Long> getAllDenominators(long[][] fractions) {
        ArrayList<Long> allDenominators = new ArrayList<>();
        for (long[] fraction : fractions) {
            allDenominators.add(fraction[1]);
        }
        return allDenominators;
    }

    private static long determineMinimumDenominator(long numerator, long denominator) {
        for (int i = 2; i < numerator / 2; ) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
            } else i++;

        }
        return denominator;
    }
}
