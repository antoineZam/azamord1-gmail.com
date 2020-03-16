package com.epita.assistants.functional;

/**
 * The Tuple3 interface defines a standard 3 values Tuple
 *
 * @param <A_TYPE> The type of the first value
 * @param <B_TYPE> The type of the second value
 * @param <C_TYPE> The type of the third value
 */
public interface Tuple3Specification<A_TYPE, B_TYPE, C_TYPE> {
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

    /**
     * Accesses the tuple's third value
     *
     * @return The third value
     */
    default C_TYPE third() {
        throw new UnsupportedOperationException("not implemented");
    }
}
