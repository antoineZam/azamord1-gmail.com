package com.epita.assistants.functional;

/**
 * Function1.
 *
 * @param <ARG_TYPE>       Argument type.
 * @param <RETURN_TYPE>    Return type.
 * @param <EXCEPTION_TYPE> Exception type.
 */
public interface Fn1<ARG_TYPE, RETURN_TYPE, EXCEPTION_TYPE extends Throwable> {

    /**
     * Applies the function to the given argument.
     *
     * @param arg The argument.
     * @return The result of the function application.
     * @throws EXCEPTION_TYPE Upon error.
     */
    RETURN_TYPE apply(final ARG_TYPE arg) throws EXCEPTION_TYPE;

    /**
     * Safe function1, guaranteed not to throw.
     *
     * @param <ARG_TYPE>    Argument type.
     * @param <RETURN_TYPE> Return type.
     */
    public interface Safe<ARG_TYPE, RETURN_TYPE> extends Fn1<ARG_TYPE, RETURN_TYPE, RuntimeException> {

        /**
         * Applies the function to the given argument.
         *
         * @param arg The argument.
         * @return The result of the function application.
         */
        RETURN_TYPE apply(final ARG_TYPE arg);
    }

}
