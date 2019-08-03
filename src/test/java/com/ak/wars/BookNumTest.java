package com.ak.wars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookNumTest {

    @Test
    public void testFour() {
        assertEquals(4, BookNum.pageDigits(4));
    }

    @Test
    public void testTwelve() {
        assertEquals(11, BookNum.pageDigits(10));
    }

    @Test
    public void testOneHundred() {
        assertEquals(192, BookNum.pageDigits(100));
    }



    @Test
    public void tousand() {
        assertEquals(2893, BookNum.pageDigits(1000));
    }
    @Test
    public void tentousand() {
        assertEquals(38894, BookNum.pageDigits(10000));
    }

    @Test
    public void testMax() {
        assertEquals(192, BookNum.pageDigits(400000000000000000L));
    }

}
//
//0   1
//1   1
//2   1
//3   1
//4   1
//5   1
//6   1
//7   1
//8   1
//9   1
//10  2
//11  2
//12  2
//13  2
//14  2
//15  2
//16  2
//17  2
//18  2
//19  2
//20  2
//
//10^n+1 -1