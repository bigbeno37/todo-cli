package com.benosullivan.todocli;

import java.util.ArrayList;
import java.util.List;

public class MockOutputHandler implements OutputHandler {
    private List<String> messages = new ArrayList<String>();

    @Override
    public void print(String message) {
        this.messages.add(message);
    }

    public String getNthMostRecentMessage(int n) {
        return messages.get(messages.size() - 1 - n);
    }

    public String getMostRecentMessage() {
        return messages.get(messages.size() - 1);
    }

    public int getNumberOfMessages() {
        return messages.size();
    }
}
