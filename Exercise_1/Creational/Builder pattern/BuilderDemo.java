package com.example.designpatterns.creational.builder;

import java.io.BufferedReader;
import java.util.Arrays;

public class BuilderDemo {
    public static void runDemo(BufferedReader reader) throws Exception {
        System.out.println("Builder Pattern Demo");
        System.out.print("Title: ");
        String title = reader.readLine();
        System.out.print("Author: ");
        String author = reader.readLine();
        System.out.print("Content: ");
        String content = reader.readLine();
        System.out.print("Comma-separated chart names (or blank): ");
        String chartsLine = reader.readLine();

        ReportBuilder rb = new ReportBuilder()
                .withTitle(title)
                .withAuthor(author)
                .withContent(content);

        if (chartsLine != null && !chartsLine.trim().isEmpty()) {
            Arrays.stream(chartsLine.split(","))
                    .map(String::trim)
                    .forEach(rb::addChart);
        }
        Report report = rb.build();
        System.out.println("Built report summary: " + report.summary());
    }
}
