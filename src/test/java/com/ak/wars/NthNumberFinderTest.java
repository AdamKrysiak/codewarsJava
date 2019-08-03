package com.ak.wars;

import org.junit.Assert;
import org.junit.Test;

public class NthNumberFinderTest {

    @Test
    public void basicTest() {

        for (int i = 0; i < 30; i++) // Testing for 0 to 29 digits
            Assert.assertEquals("272619325597593231536305887388".charAt(i) - '0', NthNumberFinder.findDigit(i));

        Assert.assertEquals(1, NthNumberFinder.findDigit(1000));
        Assert.assertEquals(4, NthNumberFinder.findDigit(10000));
        Assert.assertEquals(4, NthNumberFinder.findDigit(100000));
        Assert.assertEquals(5, NthNumberFinder.findDigit(1000000));
        Assert.assertEquals(3, NthNumberFinder.findDigit(10000000));
        Assert.assertEquals(9, NthNumberFinder.findDigit(100000000));
        Assert.assertEquals(1, NthNumberFinder.findDigit(1000000000));
    }
}
