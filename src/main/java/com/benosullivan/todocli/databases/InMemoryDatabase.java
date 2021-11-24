package com.benosullivan.todocli.databases;

import com.benosullivan.todocli.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements TodoDatabase {
    private final List<TodoItem> todoItems = new ArrayList<>();

    @Override
    public void addTodoItem(TodoItem item) {
        this.todoItems.add(item);
    }

    @Override
    public List<TodoItem> getTodoItems() {
        return todoItems;
    }
}
