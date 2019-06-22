package com.ak.wars;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;



class RangeExtraction {
    public static String rangeExtraction(int[] numberArray) {
        List<Integer> inputs = convertArrayToList(numberArray);
        MinMax minMax = MinMax.countMinMax(inputs);
        List<List<Integer>> groups = splitInputsOnGroups(inputs, minMax.min, minMax.max);
        return groups.stream()
                .map(MinMax::countMinMax)
                .map(MinMax::mapToRange)
                .collect(Collectors.joining(","));
    }

    private static List<List<Integer>> splitInputsOnGroups(List<Integer> inputs, Integer min, Integer max) {
        List<List<Integer>> groups = new LinkedList<>();
        var currentGroup = new LinkedList<Integer>();
        var recentElement = min;

        for (int integer = min; integer <= max; integer++) {
            if (inputs.contains(integer)) {
                if (integer - recentElement == 1) {
                    currentGroup.add(integer);
                } else {
                    groups.add(currentGroup);
                    currentGroup = new LinkedList<>();
                    currentGroup.add(integer);
                }
                recentElement = integer;
            }
        }
        groups.remove(0);
        groups.add(currentGroup);
        return groups;
    }

    private static List<Integer> convertArrayToList(int[] numberArray) {
        return Arrays.stream(numberArray).boxed().collect(Collectors.toList());
    }

    static class MinMax {

        private int min;
        private int max;
        private MinMax(){}

        static MinMax countMinMax(List<Integer> list) {
            MinMax minMax = new MinMax();
            minMax.min = Collections.min(list);
            minMax.max = Collections.max(list);
            return minMax;
        }

        String mapToRange() {
            if (min != max)
                if (max - min == 1) {
                    return min + "," + max;
                } else {
                    return min + "-" + max;
                }
            else
                return String.valueOf(max);
        }
    }
}
