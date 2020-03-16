package com.epita.assistants.functional;

/**
 * Provides a value.
 *
 * @param <CONSUMED_TYPE>  Type of consumed value.
 * @param <EXCEPTION_TYPE> Type of thrown exception.
 */
public interface Consumer<CONSUMED_TYPE, EXCEPTION_TYPE extends Throwable> {

    /**
     * Actually get the value.
     *
     * @return The computed value.
     * @throws EXCEPTION_TYPE Upon error.
     */
    void apply(final CONSUMED_TYPE consumed) throws EXCEPTION_TYPE;

    /**
     * Provides a value, guaranteed to not throw.
     *
     * @param <CONSUMED_TYPE> The type of  value.
     */
    interface Safe<CONSUMED_TYPE> extends Consumer<CONSUMED_TYPE, RuntimeException> {
        void apply(final CONSUMED_TYPE consumed);
    }
}
