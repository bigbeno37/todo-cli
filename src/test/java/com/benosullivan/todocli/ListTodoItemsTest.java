package com.benosullivan.todocli;

import com.benosullivan.todocli.databases.InMemoryDatabase;
import com.benosullivan.todocli.databases.LocalFileDatabase;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.benosullivan.todocli.TestUtils.assertContains;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTodoItemsTest {
    @Test
    public void showsNoTodoItemsByDefault() {
        var output = new MockOutputHandler();
        var engine = new CLIEngine(output, new InMemoryDatabase());

        engine.sendMessage("list");

        assertEquals("No todo items have been added", output.getNthMostRecentMessage(1));
    }

    @Test
    public void showsOneTodoItemAfterAddingTodoItem() {
        var output = new MockOutputHandler();
        var engine = new CLIEngine(output, new InMemoryDatabase());

        engine.sendMessage("add");
        engine.sendMessage("Wash the dishes");
        engine.sendMessage("list");

        assertContains("Wash the dishes", output.getNthMostRecentMessage(1));
    }

    @Test
    public void showsOneTodoItemFromLoadedFile() throws IOException {
        var output = new MockOutputHandler();
        var db = new LocalFileDatabase(new MockFileHandler("Wash the dishes,false"));

        var engine = new CLIEngine(output, db);
        engine.sendMessage("list");

        assertContains("Wash the dishes", output.getNthMostRecentMessage(1));
    }
}
