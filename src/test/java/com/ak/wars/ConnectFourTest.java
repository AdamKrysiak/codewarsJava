package com.ak.wars;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConnectFourTest {
    @Test
    public void firstTest() {
        List<String> myList = new ArrayList<>(Arrays.asList(
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "G_Red",
                "B_Yellow"
        ));
        assertEquals("it should return Yellow", "Yellow", ConnectFour.whoIsWinner(myList));
    }

    @Test
    public void secondTest() {
        List<String> myList = new ArrayList<>(Arrays.asList(
                "C_Yellow",
                "E_Red",
                "G_Yellow",
                "B_Red",
                "D_Yellow",
                "B_Red",
                "B_Yellow",
                "G_Red",
                "C_Yellow",
                "C_Red",
                "D_Yellow",
                "F_Red",
                "E_Yellow",
                "A_Red",
                "A_Yellow",
                "G_Red",
                "A_Yellow",
                "F_Red",
                "F_Yellow",
                "D_Red",
                "B_Yellow",
                "E_Red",
                "D_Yellow",
                "A_Red",
                "G_Yellow",
                "D_Red",
                "D_Yellow",
                "C_Red"
        ));
        assertEquals("it should return Yellow", "Yellow", ConnectFour.whoIsWinner(myList));
    }

    @Test
    public void thirdTest() {
        List<String> myList = new ArrayList<>(Arrays.asList(
                "A_Yellow",
                "B_Red",
                "B_Yellow",
                "C_Red",
                "G_Yellow",
                "C_Red",
                "C_Yellow",
                "D_Red",
                "G_Yellow",
                "D_Red",
                "G_Yellow",
                "D_Red",
                "F_Yellow",
                "E_Red",
                "D_Yellow"
        ));
        assertEquals("it should return Red", "Red", ConnectFour.whoIsWinner(myList));
    }

    @Test
    public void fourthTest() {
        List<String> myList = new ArrayList<>(Arrays.asList(
                "F_Yellow", "A_Red", "E_Yellow", "C_Red", "F_Yellow", "E_Red", "C_Yellow", "B_Red", "F_Yellow", "B_Red", "D_Yellow", "A_Red", "D_Yellow", "E_Red", "E_Yellow", "D_Red", "D_Yellow", "B_Red", "A_Yellow", "E_Red", "G_Yellow", "C_Red", "G_Yellow", "E_Red", "C_Yellow", "D_Red", "A_Yellow", "G_Red", "C_Yellow", "G_Red", "D_Yellow", "F_Red", "G_Yellow", "G_Red", "B_Yellow", "F_Red", "C_Yellow", "B_Red", "A_Yellow", "A_Red", "F_Yellow", "B_Red"
        ));
        assertEquals("it should return Yellow", "Yellow", ConnectFour.whoIsWinner(myList));
    }

    @Test
    public void fifthTest() {
        List<String> myList = new ArrayList<>(Arrays.asList(
                "B_Yellow", "E_Red", "D_Yellow", "E_Red", "D_Yellow", "A_Red", "G_Yellow", "E_Red", "E_Yellow", "E_Red", "C_Yellow", "F_Red", "F_Yellow", "E_Red", "G_Yellow", "D_Red", "F_Yellow", "D_Red", "A_Yellow", "B_Red", "A_Yellow", "B_Red", "D_Yellow", "G_Red", "C_Yellow", "A_Red", "F_Yellow", "G_Red", "G_Yellow", "A_Red", "G_Yellow", "D_Red", "C_Yellow", "F_Red", "A_Yellow", "C_Red", "C_Yellow", "F_Red", "B_Yellow", "C_Red", "B_Yellow", "B_Red"
        ));
        assertEquals("it should return Yellow", "Yellow", ConnectFour.whoIsWinner(myList));
    }

    @Test
    public void sixthTest() {
        List<String> myList = new ArrayList<>(Arrays.asList(
                "D_Yellow", "D_Red", "B_Yellow", "A_Red", "C_Yellow", "G_Red", "G_Yellow", "A_Red", "G_Yellow", "E_Red", "E_Yellow", "E_Red", "B_Yellow", "C_Red", "G_Yellow", "E_Red", "D_Yellow", "F_Red", "E_Yellow", "B_Red", "C_Yellow", "B_Red", "A_Yellow", "E_Red", "A_Yellow", "D_Red", "C_Yellow", "F_Red", "B_Yellow", "D_Red", "C_Yellow", "F_Red", "B_Yellow", "D_Red", "A_Yellow", "C_Red", "A_Yellow", "F_Red", "F_Yellow", "G_Red", "G_Yellow", "F_Red"
        ));
        assertEquals("it should return Red", "Red", ConnectFour.whoIsWinner(myList));
    }
@Test
    public void seventhTest() {
        List<String> myList = new ArrayList<>(Arrays.asList(
                "A_Yellow", "A_Red", "D_Yellow", "A_Red", "A_Yellow", "C_Red", "C_Yellow", "E_Red", "A_Yellow", "E_Red", "G_Yellow", "E_Red", "C_Yellow", "G_Red", "E_Yellow", "A_Red", "B_Yellow", "E_Red", "E_Yellow", "C_Red", "C_Yellow", "F_Red", "B_Yellow", "C_Red", "B_Yellow", "G_Red", "G_Yellow", "D_Red", "F_Yellow", "B_Red", "B_Yellow", "F_Red", "B_Yellow", "F_Red", "G_Yellow", "F_Red", "G_Yellow", "F_Red", "D_Yellow", "D_Red", "D_Yellow", "D_Red"
        ));
        assertEquals("it should return Yellow", "Yellow", ConnectFour.whoIsWinner(myList));
    }

}
