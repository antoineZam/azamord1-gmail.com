package com.epita.assistants.functional;

/**
 * Tests if a given input is true.
 *
 * @param <INPUT_TYPE>     Type of input of the predicate.
 * @param <EXCEPTION_TYPE> Type of exception that may be raised.
 */
public interface Predicate<INPUT_TYPE, EXCEPTION_TYPE extends Throwable> {

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param input The input argument
     * @return {@code true}     If the input argument matches the predicate,
     * otherwise {@code false}
     * @throws EXCEPTION_TYPE Upon exception.
     */
    boolean test(INPUT_TYPE input) throws EXCEPTION_TYPE;

    /**
     * Tests if a given input is true, guaranteed to not throw.
     *
     * @param <INPUT_TYPE> Type of input of the predicate.
     */
    interface Safe<INPUT_TYPE> extends Predicate<INPUT_TYPE, RuntimeException> {
        /**
         * Evaluates this predicate on the given argument.
         *
         * @param input The input argument
         * @return {@code true} If the input argument matches the predicate,
         * otherwise {@code false}
         */
        boolean test(INPUT_TYPE input);
    }
}
