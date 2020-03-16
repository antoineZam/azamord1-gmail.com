package com.epita.assistants.functional;

/**
 * Provides a value.
 *
 * @param <SUPPLIED_TYPE>  Type of provided value.
 * @param <EXCEPTION_TYPE> Type of thrown exception.
 */
public interface Fn0<SUPPLIED_TYPE, EXCEPTION_TYPE extends Throwable> {

    /**
     * Actually get the value.
     *
     * @return The computed value.
     * @throws EXCEPTION_TYPE Upon error.
     */
    SUPPLIED_TYPE get() throws EXCEPTION_TYPE;

    /**
     * Provides a value, guaranteed to not throw.
     *
     * @param <SUPPLIED_TYPE> The type of  value.
     */
    interface Safe<SUPPLIED_TYPE> extends Fn0<SUPPLIED_TYPE, RuntimeException> {

        /**
         * Get the value.
         *
         * @return The computed value.
         */
        SUPPLIED_TYPE get();
    }
}
