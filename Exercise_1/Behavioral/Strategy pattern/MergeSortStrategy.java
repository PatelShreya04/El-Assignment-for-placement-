package com.example.designpatterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSortStrategy implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> data) {
        List<Integer> copy = new ArrayList<>(data);
        // for demo, reuse Collections.sort (conceptually a different algorithm)
        Collections.sort(copy);
        return copy;
    }
}
