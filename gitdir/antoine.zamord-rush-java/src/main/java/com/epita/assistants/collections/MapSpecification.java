package com.epita.assistants.collections;

import com.epita.assistants.functional.MaybeSpecification;
import com.epita.assistants.functional.Tuple2Specification;
import com.epita.assistants.stream.SeqSpecification;

/**
 * Specification for an immutable Map.
 *
 * @param <KEY_TYPE>   The type of the keys used to get values from the Map.
 * @param <VALUE_TYPE> The type of the values stored in the Map.
 */
public interface MapSpecification<KEY_TYPE, VALUE_TYPE> extends CollectionSpecification {

    /**
     * Gets the value linked to a key in the Map.
     *
     * @param key The key.
     * @return The value linked to the key if there is one, an empty type otherwise.
     */
    default MaybeSpecification<VALUE_TYPE> get(final KEY_TYPE key) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Returns a Sequence of the elements of the Map.
     *
     * @param <ENTRY_TYPE> Type pairing the type of keys and the type of values used in the Map.
     * @return The Sequence.
     */
    default <ENTRY_TYPE extends Tuple2Specification<KEY_TYPE, VALUE_TYPE>>
    SeqSpecification<? extends Tuple2Specification<KEY_TYPE, VALUE_TYPE>> seq() {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /**
     * Mutable Map.
     *
     * @param <KEY_TYPE>   The type of the keys used to get values from the MutableMap.
     * @param <VALUE_TYPE> The type of the values stored in the MutableMap.
     */
    interface Mutable<KEY_TYPE, VALUE_TYPE> extends MapSpecification<KEY_TYPE, VALUE_TYPE> {

        /**
         * Insert a value linked with a key in the MutableMap. If the given key is already linked with a value, replaces
         * this value with the one given as argument.
         *
         * @param key   The key through which the value shall be accessed later on.
         * @param value The value to insert in the MutableMap.
         */
        default void add(final KEY_TYPE key, final VALUE_TYPE value) {
            throw new UnsupportedOperationException("Not implemented.");
        }

        /**
         * Removes a value from the MutableMap.
         *
         * @param key The key linked to the element to remove.
         * @return The removed value if there is one linked to the key, an empty type otherwise.
         */
        default MaybeSpecification<VALUE_TYPE> remove(final KEY_TYPE key) {
            throw new UnsupportedOperationException("Not implemented.");
        }
    }
}