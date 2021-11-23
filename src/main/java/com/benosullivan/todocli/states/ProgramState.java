package com.benosullivan.todocli.states;

import com.benosullivan.todocli.OutputHandler;
import com.benosullivan.todocli.databases.TodoDatabase;

public abstract class ProgramState {
    protected OutputHandler output;
    protected TodoDatabase db;

    public ProgramState(OutputHandler output, TodoDatabase db) {
        this.output = output;
        this.db = db;
    }

    public abstract void beforeMessage();
    public abstract ProgramState handleMessage(String message);
}
