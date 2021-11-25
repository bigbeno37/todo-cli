package com.benosullivan.todocli.filehandlers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class LocalFileHandler implements FileHandler {
    private final Path path = Paths.get("data.txt");

    public LocalFileHandler() throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }

    @Override
    public List<String> readLines() throws IOException {
        return Files.readAllLines(path);
    }

    @Override
    public void appendLine(String line) throws IOException {
        Files.writeString(path, line + "\n", Charset.defaultCharset(), StandardOpenOption.APPEND);
    }

    @Override
    public void clearAllLines() {
        // TODO
    }
}
