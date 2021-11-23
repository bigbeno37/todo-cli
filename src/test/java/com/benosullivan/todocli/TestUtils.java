package com.benosullivan.todocli;

import static org.junit.jupiter.api.Assertions.fail;

public class TestUtils {
    public static void assertContains(String substring, String string) {
        if (!string.contains(substring)) {
            fail("Expected \"" + string + "\" to contain \"" + substring + "\"");
        }
    }

    public static void assertNotContains(String substring, String string) {
        if (string.contains(substring)) {
            fail("Expected \"" + string + "\" to not contain \"" + substring + "\"");
        }
    }
}
