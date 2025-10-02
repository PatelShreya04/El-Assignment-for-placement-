package com.example.designpatterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSortStrategy implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> data) {
        List<Integer> copy = new ArrayList<>(data);
        Collections.sort(copy); // simulate quick efficient sort using JDK
        return copy;
    }
}
