package com.ak.wars;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

// https://www.codewars.com/kata/54bd6b4c956834c9870001a1

public class Bagel {
    public final int getValue() {
        return 3;
    }
}

class BagelSolver {

    public static Bagel getBagel() {
        try {
            Field booleanFalse = Boolean.class.getField("TRUE");
            booleanFalse.setAccessible(true);
            Field modifiers = Field.class.getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(booleanFalse, booleanFalse.getModifiers() & ~Modifier.FINAL);
            booleanFalse.set(null, false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return new Bagel();
    }

}