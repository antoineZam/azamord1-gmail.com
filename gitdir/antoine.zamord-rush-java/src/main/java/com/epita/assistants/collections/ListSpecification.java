package com.epita.assistants.collections;

import com.epita.assistants.functional.Maybe;
import com.epita.assistants.functional.MaybeSpecification;
import com.epita.assistants.stream.SeqSpecification;

/**
 * Specification for an immutable List.
 *
 * @param <ELEMENT_TYPE> The type of the elements contained in the List.
 */
public interface ListSpecification<ELEMENT_TYPE> extends CollectionSpecification {

    /**
     * Gets an element from the List.
     *
     * @param index The index at which the element is located.
     * @return An element from the List if the index is valid, an empty type if it is not.
     */
    default MaybeSpecification<ELEMENT_TYPE> get(final int index) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Returns a Sequence of the elements of the List.
     *
     * @return The Sequence.
     */
    default SeqSpecification<ELEMENT_TYPE> seq() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Mutable List.
     *
     * @param <ELEMENT_TYPE> The type of the elements contained by the List.
     */
    interface Mutable<ELEMENT_TYPE> extends ListSpecification<ELEMENT_TYPE> {

        /**
         * Adds a new element at the end of the MutableList.
         *
         * @param element The element to insert in the MutableList.
         */
        default void add(final ELEMENT_TYPE element) {
            throw new UnsupportedOperationException("Not implemented.");
        }

        /**
         * Removes an element from the MutableList.
         *
         * @param index The index of the element to be removed.
         * @return The element to remove if the index is valid, an empty type if it is not.
         */
        default MaybeSpecification<ELEMENT_TYPE> remove(final int index) {
            throw new UnsupportedOperationException("Not implemented.");
        }
    }
}
