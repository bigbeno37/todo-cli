package com.benosullivan.todocli;

import com.benosullivan.todocli.databases.InMemoryDatabase;
import com.benosullivan.todocli.databases.LocalFileDatabase;
import com.benosullivan.todocli.filehandlers.LocalFileHandler;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            var engine = new CLIEngine(new SystemOutputHandler(), new LocalFileDatabase(new LocalFileHandler()));

            try (Scanner input = new Scanner(System.in)) {
                while (true) {
                    engine.sendMessage(input.nextLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
