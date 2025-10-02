package com.example.designpatterns.creational.builder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ReportBuilder {
    private String title;
    private String author;
    private String content;
    private List<String> charts = new ArrayList<>();
    private Instant createdAt = Instant.now();

    public ReportBuilder withTitle(String t) { this.title = t; return this; }
    public ReportBuilder withAuthor(String a) { this.author = a; return this; }
    public ReportBuilder withContent(String c) { this.content = c; return this; }
    public ReportBuilder addChart(String chart) { this.charts.add(chart); return this; }
    public ReportBuilder createdAt(Instant i) { this.createdAt = i; return this; }

    public Report build() {
        return new Report(title, author, content, new ArrayList<>(charts), createdAt);
    }
}
