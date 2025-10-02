package com.example.designpatterns.creational.builder;

import java.time.Instant;
import java.util.List;

public class Report {
    private final String title;
    private final String author;
    private final String content;
    private final List<String> charts;
    private final Instant createdAt;

    public Report(String title, String author, String content, List<String> charts, Instant createdAt) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.charts = charts;
        this.createdAt = createdAt;
    }

    public String summary() {
        return "Report[" + title + "] by " + author + " createdAt=" + createdAt + " charts=" + (charts == null ? 0 : charts.size());
    }
}
