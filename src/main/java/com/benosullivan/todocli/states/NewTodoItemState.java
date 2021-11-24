package com.benosullivan.todocli.states;

import com.benosullivan.todocli.OutputHandler;
import com.benosullivan.todocli.databases.TodoDatabase;
import com.benosullivan.todocli.TodoItem;

public class NewTodoItemState extends ProgramState {
    public NewTodoItemState(OutputHandler output, TodoDatabase db) {
        super(output, db);
    }

    @Override
    public void beforeMessage() {
        output.print("Enter the name of a task: ");
    }

    @Override
    public ProgramState handleMessage(String message) {
        if (message.isEmpty()) {
            output.print("Task must not be empty");
            return this;
        }

        db.addTodoItem(new TodoItem(message, false));

        output.print("Added new task \"" + message + "\"");

        return new MainMenuState(output, db);
    }
}
