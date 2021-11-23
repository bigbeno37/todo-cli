package com.benosullivan.todocli;

import com.benosullivan.todocli.databases.InMemoryDatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var engine = new CLIEngine(new SystemOutputHandler(), new InMemoryDatabase());

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                engine.sendMessage(input.nextLine());
            }
        }
    }
}
