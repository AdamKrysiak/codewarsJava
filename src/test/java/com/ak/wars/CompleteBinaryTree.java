package com.ak.wars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompleteBinaryTree implements Function<int[], int[]> {
    @Override
    public int[] apply(int[] ints) {
        List<Integer> elements = IntStream.of(ints).boxed().collect(Collectors.toList());
        System.out.println();
        System.out.println(elements);
        var orderedList = new ArrayList<Integer>();
        var queue = new LinkedList<List<Integer>>();
        queue.add(elements);
        while (!queue.isEmpty()) {
            List<Integer> allElements = queue.pollFirst();
            int rootNodeIndex = getRootNodeIndex(allElements);
            if (allElements.size() < 2)
                orderedList.addAll(allElements);
            else if (allElements.size() == 2) {
                orderedList.add(allElements.get(allElements.size() - 1));
                queue.add(Collections.singletonList(allElements.get(0)));
            } else {
                orderedList.add(allElements.get(rootNodeIndex));
                List<Integer> leftBranch = allElements.subList(0, rootNodeIndex);
                List<Integer> rightBranch = allElements.subList(rootNodeIndex + 1, allElements.size());
                queue.add(leftBranch);
                queue.add(rightBranch);
            }
        }
        System.out.println(orderedList);
        return orderedList.stream().mapToInt(e->e).toArray();
    }


    private int getRootNodeIndex(List<Integer> elements) {
        int minFullTreeDepth = (int) Math.floor(Math.log(elements.size()) / Math.log(2.0));
        int maxTreeDepth = (int) Math.ceil(Math.log(elements.size()) / Math.log(2.0));
        int countOfElementsInMinFullTree = (int) Math.pow(2, minFullTreeDepth) - 1;
        int leftSizeVelocity = (int) Math.pow(2, maxTreeDepth - 2);

        int countOfElementsThatLeft = elements.size() - countOfElementsInMinFullTree;
        int leftBoundary = Math.min(leftSizeVelocity, countOfElementsThatLeft);

        List<Integer> fullTree = elements.subList(leftBoundary, leftBoundary + countOfElementsInMinFullTree);

        int indexInMinFullTree = Math.floorDiv(fullTree.size(), 2);
        return leftBoundary + indexInMinFullTree;

    }
}
