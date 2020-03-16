package com.epita.assistants.files;

/**
 * Represents an error when dealing with file IO.
 */
public class FileError extends RuntimeException {
    FileError(final String message) {
        super(message);
    }
}
