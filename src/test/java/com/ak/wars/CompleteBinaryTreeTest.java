package com.ak.wars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.runners.JUnit4;


public class CompleteBinaryTreeTest {

    @Test
    public void testSingleNodeTree() {
        int[] input = new int[]{1};
        int[] expected = new int[]{1};
        assertArrayEquals(expected, new CompleteBinaryTree().apply(input));
    }

    @Test
    public void testTwoNodeTree() {
        int[] input = new int[] {1, 2};
        int[] expected = new int[]{2, 1};
        assertArrayEquals(expected, new CompleteBinaryTree().apply(input));
    }

    @Test
    public void testSixNodeTree() {
        int[] input = new int[] {1, 2, 2, 6, 7, 5};
        int[] expected = new int[]{6, 2, 5, 1, 2, 7};
        assertArrayEquals(expected, new CompleteBinaryTree().apply(input));
    }

    @Test
    public void testTenNodeTree() {
        int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expected = new int[] {7, 4, 9, 2, 6, 8, 10, 1, 3, 5};
        assertArrayEquals(expected, new CompleteBinaryTree().apply(input));
    }

}