package com.benosullivan.todocli.states;

import com.benosullivan.todocli.OutputHandler;
import com.benosullivan.todocli.databases.TodoDatabase;

public class MainMenuState extends ProgramState {
    public MainMenuState(OutputHandler output, TodoDatabase db) {
        super(output, db);
    }

    @Override
    public void beforeMessage() {
        output.print("Please enter a command: ");
    }

    @Override
    public ProgramState handleMessage(String message) {
        switch (message) {
            case "add":
                return new NewTodoItemState(output, db);
            case "list":
                listTodoItems();
                break;
            default:
                output.print("Unknown command \"" + message + "\".");
        }

        return this;
    }

    public void listTodoItems() {
        var items = db.getTodoItems();

        if (items.isEmpty()) {
            output.print("No todo items have been added");
            return;
        }

        items.forEach(item -> output.print(item.getTask()));
    }
}
