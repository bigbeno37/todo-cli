package com.benosullivan.todocli;

import com.benosullivan.todocli.databases.InMemoryDatabase;
import org.junit.jupiter.api.Test;

import static com.benosullivan.todocli.TestUtils.assertContains;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainMenuTest {
    @Test
    public void showsPleaseEnterACommandWhenStarted() {
        var output = new MockOutputHandler();

        assertEquals(0, output.getNumberOfMessages());
        new CLIEngine(output, new InMemoryDatabase());
        assertEquals(1, output.getNumberOfMessages());
        assertEquals("Please enter a command: ", output.getMostRecentMessage());
    }

    @Test
    public void onlyShowsPleaseEnterACommandOnce() {
        var output = new MockOutputHandler();
        var engine = new CLIEngine(output, new InMemoryDatabase());

        assertEquals(1, output.getNumberOfMessages());
        engine.sendMessage("add");
        assertEquals(2, output.getNumberOfMessages());
        assertEquals("Enter the name of a task: ", output.getMostRecentMessage());
    }

    @Test
    public void showsErrorIfInvalidCommand() {
        var output = new MockOutputHandler();
        var engine = new CLIEngine(output, new InMemoryDatabase());

        assertEquals(1, output.getNumberOfMessages());
        engine.sendMessage("foobarbaz");
        assertEquals(3, output.getNumberOfMessages());
        assertContains("Unknown command", output.getNthMostRecentMessage(1));
    }
}
