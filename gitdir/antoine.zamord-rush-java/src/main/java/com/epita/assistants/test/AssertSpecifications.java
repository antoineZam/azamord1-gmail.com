package com.epita.assistants.test;

import com.epita.assistants.collections.CollectionSpecification;
import com.epita.assistants.functional.Fn1;

/**
 * The assertion class
 */
public interface AssertSpecifications {
    /**
     * Check that a given object is null.
     * Returns null if the given object is null.
     * Throws an assertion error if the given object is not null.
     *
     * @param given             The given object
     * @param <VALUE_TYPE>      Type of given object
     * @return                  `null` if the given object is null
     * @throws AssertionError   The assertion error
     */
    default <VALUE_TYPE> VALUE_TYPE isNull(final VALUE_TYPE given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given object is null.
     * Returns null if the given object is null.
     * Throws the value returned by the supplier if the given object is not null.
     *
     * @param given             The given object
     * @param exception         The supplier giving the exception
     * @param <VALUE_TYPE>      Type of given object
     * @param <EXCEPTION_TYPE>  Type of thrown exception
     * @return                  `null` if the given object is null
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <VALUE_TYPE, EXCEPTION_TYPE extends Throwable> VALUE_TYPE isNull(final VALUE_TYPE given,
                                                                             final Fn1.Safe<VALUE_TYPE, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given object is not null.
     * Returns the given object if the given object is not null.
     * Throws an assertion error if the given object is null.
     *
     * @param given             The given object
     * @param <VALUE_TYPE>      Type of given object
     * @return                  The given object if it is not null
     * @throws AssertionError   The assertion error
     */
    default <VALUE_TYPE> VALUE_TYPE isNotNull(final VALUE_TYPE given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given object is not null.
     * Returns the given object if the given object is not null.
     * Throws the value returned by the supplier if the given object is null.
     *
     * @param given             The given object
     * @param exception         The supplier giving the exception
     * @param <VALUE_TYPE>      Type of given object
     * @param <EXCEPTION_TYPE>  Type of thrown exception
     * @return                  The given object if it is not null
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <VALUE_TYPE, EXCEPTION_TYPE extends Throwable> VALUE_TYPE isNotNull(final VALUE_TYPE given,
                                                                                final Fn1.Safe<VALUE_TYPE, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given object is equal to an expected object.
     * Returns the given object if the given object is equal to the expected object.
     * Throws an assertion error if the given object is different from the expected object.
     *
     * @param expected          The expected object
     * @param given             The given object
     * @param <VALUE_TYPE>      Type of given object
     * @return                  The given object if it is equal to the expected object
     * @throws AssertionError   The assertion error
     */
    default <VALUE_TYPE> VALUE_TYPE isEqual(final Object expected, final VALUE_TYPE given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given object is equal to an expected object.
     * Returns the given object if the given object is equal to the expected object.
     * Throws the value returned by the supplier if the given object is
     * different from the expected object.
     *
     * @param expected          The expected object
     * @param given             The given object
     * @param exception         The supplier giving the exception
     * @param <VALUE_TYPE>      Type of given object
     * @param <EXCEPTION_TYPE>  Type of thrown exception
     * @return                  The given object if it is equal to the expected object
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <VALUE_TYPE, EXCEPTION_TYPE extends Throwable> VALUE_TYPE isEqual(final Object expected, final VALUE_TYPE given,
                                                                              final Fn1.Safe<VALUE_TYPE, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given object is different from an expected object.
     * Returns the given object if the given object is different to the expected object.
     * Throws an assertion error if the given object is equal to the expected object.
     *
     * @param expected          The expected object
     * @param given             The given object
     * @param <VALUE_TYPE>      Type of given object
     * @return                  The given object if it is different to the expected object
     * @throws AssertionError   The assertion error
     */
    default <VALUE_TYPE> VALUE_TYPE isNotEqual(final Object expected, final VALUE_TYPE given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given object is different from an expected object.
     * Returns the given object if the given object is different to the expected object.
     * Throws the value returned by the supplier if the given object is equal
     * to the expected object.
     *
     * @param expected          The expected object
     * @param given             The given object
     * @param exception         The supplier giving the exception
     * @param <VALUE_TYPE>      Type of given object
     * @param <EXCEPTION_TYPE>  Type of thrown exception
     * @return                  The given object if it is different to the expected object
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <VALUE_TYPE, EXCEPTION_TYPE extends Throwable> VALUE_TYPE isNotEqual(final Object expected, final VALUE_TYPE given,
                                                                                 final Fn1.Safe<VALUE_TYPE, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given boolean is equal to true.
     * Returns true if the given boolean is true.
     * Throws an assertion error if the given boolean is false.
     *
     * @param given             The given boolean
     * @return                  True if the given boolean is true
     * @throws AssertionError   The assertion error
     */
    default boolean isTrue(final boolean given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given boolean is equal to true.
     * Returns true if the given boolean is true.
     * Throws the value returned by the supplier if the given boolean is false.
     *
     * @param given             The given boolean
     * @param exception         The supplier giving the exception
     * @param <EXCEPTION_TYPE>  Type of thrown Exception
     * @return                  True if the given boolean is true
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <EXCEPTION_TYPE extends Throwable> boolean isTrue(final boolean given,
                                                              final Fn1.Safe<Boolean, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given boolean is equal to false.
     * Returns false if the given boolean is false.
     * Throws an assertion error if the given boolean is true.
     *
     * @param given             The given boolean
     * @return                  False if the given boolean is false
     * @throws AssertionError   The assertion error
     */
    default boolean isFalse(final boolean given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given boolean is equal to false.
     * Returns false if the given boolean is false.
     * Throws the value returned by the supplier if the given boolean is true.
     *
     * @param given             The given boolean
     * @param exception         The supplier giving the exception
     * @param <EXCEPTION_TYPE>  Type of thrown exception
     * @return                  False if the given boolean is false
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <EXCEPTION_TYPE extends Throwable> boolean isFalse(final boolean given,
                                                               final Fn1.Safe<Boolean, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given collection is empty.
     * Returns the given collection if the given collection is empty.
     * Throws an assertion error if the given collection is not empty.
     *
     * @param given             The given collection
     * @param <VALUE_TYPE>      Type of given collection
     * @return                  The given collection if it is empty
     * @throws AssertionError   The assertion error
     */
    default <VALUE_TYPE extends CollectionSpecification> VALUE_TYPE isEmpty(final VALUE_TYPE given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given collection is empty.
     * Returns the given collection if the given collection is empty.
     * Throws the value returned by the supplier if the given collection is not empty.
     *
     * @param given             The given collection
     * @param exception         The supplier giving the exception
     * @param <VALUE_TYPE>      Type of given collection
     * @param <EXCEPTION_TYPE>  Type of thrown exception
     * @return                  The given collection if it is empty
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <VALUE_TYPE extends CollectionSpecification, EXCEPTION_TYPE extends Throwable> VALUE_TYPE isEmpty(final VALUE_TYPE given,
                                                                                                              Fn1.Safe<VALUE_TYPE, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given collection is not empty.
     * Returns the given collection if the given collection is not empty.
     * Throws an assertion error if the given collection is empty.
     *
     * @param given             The given collection
     * @param <VALUE_TYPE>      Type of given collection
     * @return                  The given collection if it is not empty
     * @throws AssertionError   The assertion error
     */
    default <VALUE_TYPE extends CollectionSpecification> VALUE_TYPE isNotEmpty(final VALUE_TYPE given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that a given collection is not empty.
     * Returns the given collection if the given collection is not empty.
     * Throws the value returned by the supplier if the given collection is empty.
     *
     * @param given             The given collection
     * @param exception         The supplier giving the exception
     * @param <VALUE_TYPE>      Type of given collection
     * @param <EXCEPTION_TYPE>  Type of thrown exception
     * @return                  The given collection if it is not empty
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <VALUE_TYPE extends CollectionSpecification, EXCEPTION_TYPE extends Throwable> VALUE_TYPE isNotEmpty(final VALUE_TYPE given,
                                                                                                                 Fn1.Safe<VALUE_TYPE, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }
}
