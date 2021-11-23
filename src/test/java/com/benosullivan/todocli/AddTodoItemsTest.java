package com.benosullivan.todocli;

import com.benosullivan.todocli.databases.InMemoryDatabase;
import org.junit.jupiter.api.Test;

import static com.benosullivan.todocli.TestUtils.assertContains;
import static com.benosullivan.todocli.TestUtils.assertNotContains;

public class AddTodoItemsTest {
    @Test
    public void addTodoItem() {
        var output = new MockOutputHandler();
        
        var engine = new CLIEngine(output, new InMemoryDatabase());

        assertNotContains("Wash the dishes", output.getMostRecentMessage());

        engine.sendMessage("add");
        engine.sendMessage("Wash the dishes");

        assertContains("Wash the dishes", output.getNthMostRecentMessage(1));
    }
}
