package com.epita.assistants.collections;

import com.epita.assistants.stream.SeqSpecification;

/**
 * Specification for an immutable Set.
 *
 * @param <ELEMENT_TYPE> The type of the elements contained in the Set.
 */
public interface SetSpecification<ELEMENT_TYPE> extends CollectionSpecification {

    /**
     * Checks if an element is in the Set.
     *
     * @param element The element to look for.
     * @return Whether the element is present in the Set or not.
     */
    default boolean contains(final ELEMENT_TYPE element) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Returns a Sequence of the elements of the Set.
     *
     * @return The Sequence.
     */
    default SeqSpecification<ELEMENT_TYPE> seq() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Mutable Set.
     *
     * @param <ELEMENT_TYPE> The type of the elements contained in the MutableSet.
     */
    interface Mutable<ELEMENT_TYPE> extends SetSpecification<ELEMENT_TYPE> {

        /**
         * Adds an element in the MutableSet, if it is not already present.
         *
         * @param element  The element to insert in the MutableSet.
         * @return True if the element could be inserted
         */
        default boolean add(final ELEMENT_TYPE element) {
            throw new UnsupportedOperationException("Not implemented.");
        }

        /**
         * Removes an element from the MutableSet.
         *
         * @param element The element to remove.
         */
        default void remove(final ELEMENT_TYPE element) {
            throw new UnsupportedOperationException("Not implemented.");
        }
    }
}
