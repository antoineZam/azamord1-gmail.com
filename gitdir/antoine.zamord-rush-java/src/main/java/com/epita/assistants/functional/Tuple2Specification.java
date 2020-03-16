package com.epita.assistants.functional;

/**
 * The Tuple2 interface defines a standard 2 values Tuple
 *
 * @param <A_TYPE> The type of the first value
 * @param <B_TYPE> The type of the second value
 */
public interface Tuple2Specification<A_TYPE, B_TYPE> {
    /**
     * Accesses the tuple's first value
     *
     * @return The first value
     */
    default A_TYPE first() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Accesses the tuple's second value
     *
     * @return The second value
     */
    default B_TYPE second() {
        throw new UnsupportedOperationException("not implemented");
    }
}
