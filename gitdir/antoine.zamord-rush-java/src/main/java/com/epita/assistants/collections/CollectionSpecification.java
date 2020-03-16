package com.epita.assistants.collections;

/**
 * Specification for an immutable Collection.
 */
public interface CollectionSpecification {

    /**
     * Checks if the Collection is empty.
     *
     * @return True if the Collection does not contain any element.
     */
    default boolean isEmpty() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Returns the number of elements present in the Collection.
     *
     * @return The number of elements present in the Collection.
     */
    default int count() {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
