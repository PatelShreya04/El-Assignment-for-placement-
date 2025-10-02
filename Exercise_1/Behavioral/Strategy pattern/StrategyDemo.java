package com.example.designpatterns.behavioral.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StrategyDemo {
    public static void runDemo(BufferedReader reader) throws IOException {
        System.out.println("Strategy Pattern Demo");
        System.out.println("Enter comma-separated integers (e.g. 5,3,9,1): ");
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) {
            System.out.println("No input; returning to menu.");
            return;
        }
        List<Integer> data = Arrays.stream(line.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Choose strategy: 1) QuickSort  2) MergeSort");
        String opt = reader.readLine();
        SortingStrategy strategy = "2".equals(opt) ? new MergeSortStrategy() : new QuickSortStrategy();
        List<Integer> result = strategy.sort(data);
        System.out.println("Sorted result: " + result);
    }
}
