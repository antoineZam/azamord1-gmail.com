package com.epita.assistants.test;

/**
 * The class for assertion errors
 */
public class AssertionError extends Error {
    public AssertionError(Object expected, Object given) {
        this("[" + expected + "]", given);
    }

    public AssertionError(String expected, Object given) {
        this(expected, "[" + given + "]");
    }

    public AssertionError(String expected, String given) {
        super("Expected " + expected + ", got " + given);
    }
}
