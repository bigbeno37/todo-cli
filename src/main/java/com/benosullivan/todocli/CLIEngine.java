package com.benosullivan.todocli;

import com.benosullivan.todocli.databases.TodoDatabase;
import com.benosullivan.todocli.states.MainMenuState;
import com.benosullivan.todocli.states.ProgramState;

public class CLIEngine {
    private OutputHandler output;
    private ProgramState currentState;

    public CLIEngine(OutputHandler output, TodoDatabase db) {
        this.output = output;

        this.currentState = new MainMenuState(output, db);
        this.currentState.beforeMessage();
    }

    public void sendMessage(String message) {
        currentState = currentState.handleMessage(message);
        currentState.beforeMessage();
    }
}
