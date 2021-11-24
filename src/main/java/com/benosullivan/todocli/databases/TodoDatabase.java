package com.benosullivan.todocli.databases;

import com.benosullivan.todocli.TodoItem;

import java.util.List;

public interface TodoDatabase {
    void addTodoItem(TodoItem item);
    List<TodoItem> getTodoItems();
}
