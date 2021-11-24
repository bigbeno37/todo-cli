package com.benosullivan.todocli;

import com.benosullivan.todocli.databases.InMemoryDatabase;
import org.junit.jupiter.api.Test;

import static com.benosullivan.todocli.TestUtils.assertContains;
import static com.benosullivan.todocli.TestUtils.assertNotContains;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTodoItemTest {
    @Test
    public void addTodoItem() {
        var output = new MockOutputHandler();
        
        var engine = new CLIEngine(output, new InMemoryDatabase());

        assertNotContains("Wash the dishes", output.getMostRecentMessage());

        engine.sendMessage("add");
        engine.sendMessage("Wash the dishes");

        assertContains("Wash the dishes", output.getNthMostRecentMessage(1));
    }

    @Test
    public void errorIfTaskIsEmpty() {
        var output = new MockOutputHandler();

        var engine = new CLIEngine(output, new InMemoryDatabase());

        assertEquals(1, output.getNumberOfMessages());

        engine.sendMessage("add");
        engine.sendMessage("");

        assertEquals(4, output.getNumberOfMessages());
        assertEquals("Task must not be empty", output.getNthMostRecentMessage(1));
    }
}
