package com.benosullivan.todocli.filehandlers;

import java.io.IOException;
import java.util.List;

public interface FileHandler {
    List<String> readLines() throws IOException;
    void appendLine(String line) throws IOException;
    void clearAllLines() throws IOException;
}
