package com.ak.wars;

import java.util.function.Function;

import static java.lang.Math.abs;

/**
 * Solution for KATA "Find The Parity Outlier"
 * https://www.codewars.com/kata/5526fc09a1bbd946250002dc
 */
class FindOutlier {

    static int find(int[] integers) {
        System.out.println(integers);
        Function<Integer, Boolean> func = (abs(integers[0]) % 2 + abs(integers[1]) % 2 + abs(integers[2]) % 2) > 1 ?
                i -> abs(i) % 2 == 0 : i -> abs(i) % 2 == 1;
        for (var i : integers)
            if (func.apply(i))
                return i;
        return -1;

    }
}