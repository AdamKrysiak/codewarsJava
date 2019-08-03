package com.ak.wars;

// https://www.codewars.com/kata/sums-of-parts/train/java

import java.util.stream.IntStream;

public class SumParts {

    public static int[] sumParts(int[] ls) {
        if(ls.length==0)
            return new int[]{0};
        int sum = IntStream.of(ls).sum();
        int[] resp = new int[ls.length+1];
        int reduce = ls[0];
        resp[0]=sum;
        for (int i = 1; i < ls.length; i++) {
            resp[i] = sum - reduce;
            reduce+=ls[i];
        }
        return resp;
    }
}