package com.benosullivan.todocli;

import com.benosullivan.todocli.filehandlers.FileHandler;

import java.util.List;

public class MockFileHandler implements FileHandler {
    List<String> lines;

    public MockFileHandler(String... lines) {
        this.lines = List.of(lines);
    }

    @Override
    public List<String> readLines() {
        return lines;
    }

    @Override
    public void appendLine(String line) {
        lines.add(line);
    }

    @Override
    public void clearAllLines() {
        lines.clear();
    }
}
