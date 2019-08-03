package com.ak.wars;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpinWords {

    public String spinWords(String sentence) {
        return Stream.of(sentence.split(" "))
                .map(str -> str.length() > 4 ? reverse(str) : str)
                .collect(Collectors.joining(" "));
    }

    private String reverse(String string) {
        String[] split = string.split("");
        LinkedList<String> letters = new LinkedList<>(Arrays.asList(split));
        StringBuilder str = new StringBuilder();
        letters.descendingIterator().forEachRemaining(str::append);
        return str.toString();
    }
}