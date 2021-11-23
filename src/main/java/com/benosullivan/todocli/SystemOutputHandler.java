package com.benosullivan.todocli;

public class SystemOutputHandler implements OutputHandler {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
