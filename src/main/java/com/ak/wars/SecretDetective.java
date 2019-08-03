package com.ak.wars;

import java.util.HashSet;
import java.util.Set;


public class SecretDetective {


    public String recoverSecret(char[][] triplets) {
        HashSet<Character> characters = new HashSet<>();
        Set<StringBuilder> clues = new HashSet<>();
        StringBuilder answear = new StringBuilder();
        for (char[] triplet : triplets) {
            characters.add(triplet[0]);
            characters.add(triplet[1]);
            characters.add(triplet[2]);
            clues.add(new StringBuilder("" + triplet[0] + triplet[1] + triplet[2]));
        }
        while (!characters.isEmpty()) {
            HashSet<String> potentialFirsts = findPotentialFirsts(clues);
            String realFirst= findRealFirst(clues, potentialFirsts);
            answear.append(realFirst);
            characters.remove(realFirst.charAt(0));
            removeFirstFromClues(clues, realFirst);

        }
        return answear.toString();
    }

    private String findRealFirst(Set<StringBuilder> clues, HashSet<String> potentialFirsts) {
        String potentialFirst = "";
        for (String pf : potentialFirsts) {
            potentialFirst = pf;
            boolean found = true;
            for (StringBuilder clue : clues) {
                if (clue.lastIndexOf(pf) > 0)
                    found = false;
            }
            if (found)
                break;
        }
        return potentialFirst;
    }

    private void removeFirstFromClues(Set<StringBuilder> clues, String realFirst) {
        for (StringBuilder clue : clues) {
            int i = clue.lastIndexOf(realFirst);
            if (i != -1)
                clue.deleteCharAt(i);
        }
        clues.removeIf(e -> e.length() == 0);
    }

    private HashSet<String> findPotentialFirsts(Set<StringBuilder> clues) {
        HashSet<String> potentialFirsts = new HashSet<>();
        for (StringBuilder clue : clues) {
            potentialFirsts.add(String.valueOf(clue.charAt(0)));
        }
        return potentialFirsts;
    }

}