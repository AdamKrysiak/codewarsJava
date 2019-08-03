package com.ak.wars;

import java.math.BigInteger;

public class BookNum {
    public static long pageDigits(long pages) {

        int length = String.valueOf(pages).length();
        long nines = BigInteger.valueOf(10).pow(length - 1).longValue() - 1;

        long firstValSum = length * (pages - (nines));
        long secValSum = (length - 1) * nines;
        long min = 0;
        for (long i = Math.floorDiv(nines, 10); i >= 9; i = Math.floorDiv(i, 10)) {
            min += i;
        }
        return firstValSum + secValSum - min;
    }

}