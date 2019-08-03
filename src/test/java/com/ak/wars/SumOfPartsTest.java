package com.ak.wars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfPartsTest {

    @Test
    public void test_fractions() throws Exception {
        long[][] lst;
        long[][] lst2;
        lst = new long[][]{{1, 2}, {1, 3}, {10, 40}};
        lst2 = new long[][]{{69, 130}, {87, 1310}, {30, 40}};
        assertEquals("(6,12)(4,12)(3,12)", SumOfParts.convertFrac(lst));
        assertEquals("(18078,34060)(2262,34060)(25545,34060)", SumOfParts.convertFrac(lst2));
    }
}


