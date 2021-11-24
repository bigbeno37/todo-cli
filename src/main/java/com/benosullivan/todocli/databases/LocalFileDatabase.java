package com.benosullivan.todocli.databases;

import com.benosullivan.todocli.TodoItem;
import com.benosullivan.todocli.filehandlers.FileHandler;

import java.io.IOException;
import java.util.List;

public class LocalFileDatabase implements TodoDatabase {
    private FileHandler file;
    private InMemoryDatabase db = new InMemoryDatabase();

    public LocalFileDatabase(FileHandler file) throws IOException {
        this.file = file;
        file.readLines().forEach(line -> {
            String[] data = line.split(",");
            String task = data[0];
            boolean completed = Boolean.parseBoolean(data[1]);

            db.addTodoItem(new TodoItem(task, completed));
        });
    }

    @Override
    public void addTodoItem(TodoItem item) {
        db.addTodoItem(item);
        try {
            file.appendLine(item.toString());
        } catch (IOException e) {
            // TODO: Use OutputHandler
            e.printStackTrace();
        }
    }

    @Override
    public List<TodoItem> getTodoItems() {
        return db.getTodoItems();
    }
}
