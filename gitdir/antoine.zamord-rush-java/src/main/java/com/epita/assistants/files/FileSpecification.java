package com.epita.assistants.files;

/**
 * The interface to interact with files.
 */
public interface FileSpecification {
    /**
     * Read the open file into a byte array.
     *
     * @return      The bytes read from the file.
     */
    default byte[] readBytes() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Read the open file into a string.
     *
     * @return      The string read from the file.
     */
    default String readString() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Get the name of the open file.
     *
     * @return      The name of the file.
     */
    default String getName() {
        throw new UnsupportedOperationException("not implemented");
    }
}
