package com.epita.assistants.functional;

/**
 * Function2.
 *
 * @param <ARG1_TYPE>      First argument type.
 * @param <ARG2_TYPE>      Second argument type.
 * @param <RETURN_TYPE>    Return type.
 * @param <EXCEPTION_TYPE> Exception type.
 */
public interface Fn2<ARG1_TYPE, ARG2_TYPE, RETURN_TYPE, EXCEPTION_TYPE extends Throwable> {

    /**
     * Apply the function to the given arguments.
     *
     * @param arg1 First argument.
     * @param arg2 Second argument.
     * @return The result of the function application.
     * @throws EXCEPTION_TYPE Type of exception that may be thrown.
     */
    RETURN_TYPE apply(final ARG1_TYPE arg1, final ARG2_TYPE arg2) throws EXCEPTION_TYPE;

    /**
     * Safe function1, guaranteed not to throw.
     *
     * @param <ARG1_TYPE>   First argument type.
     * @param <ARG2_TYPE>   Second argument type.
     * @param <RETURN_TYPE> Return type.
     */
    interface Safe<ARG1_TYPE, ARG2_TYPE, RETURN_TYPE> extends Fn2<ARG1_TYPE, ARG2_TYPE, RETURN_TYPE, RuntimeException> {


        /**
         * Apply the function to the given arguments.
         *
         * @param arg1 First argument.
         * @param arg2 Second argument.
         * @return The result of the function application.
         */
        RETURN_TYPE apply(final ARG1_TYPE arg1, final ARG2_TYPE arg2);
    }

}
