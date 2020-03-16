package com.epita.assistants.functional;

/**
 * The `Maybe` interface is similar to Haskell's Maybe type
 * (https://wiki.haskell.org/Maybe)
 * <p>
 * It represents a type where the value may not exist.
 * If `Maybe` contains a value, then it is `Just` value. If it is empty, it is
 * `Nothing`.
 *
 * @param <VALUE_TYPE> The type it may or may not contain
 */
public interface MaybeSpecification<VALUE_TYPE> {
    /**
     * If `Maybe` contains a value, returns the application of `fn1` on this
     * value, else returns `fn0`'s result
     *
     * @param fn1           The function to apply on the possibly contained value
     * @param fn0           The function to apply if `Maybe` contains nothing
     * @param <RETURN_TYPE> The return type
     * @return `fn1` or `fn0`'s result
     * @throws EXCEPTION_TYPE Type of exception that may be thrown.
     */
    default <RETURN_TYPE, EXCEPTION_TYPE extends Throwable>
    RETURN_TYPE match(Fn1<VALUE_TYPE, RETURN_TYPE, EXCEPTION_TYPE> fn1, Fn0<RETURN_TYPE, EXCEPTION_TYPE> fn0)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * If `Maybe` contains a value, returns `Just` a result of `fn`'s
     * application on this value, else, returns `Nothing`
     *
     * @param fn            The function to apply
     * @param <RETURN_TYPE> The function's return type
     * @return A `Maybe` containing the result of `fn`'s application, or nothing
     * @throws EXCEPTION_TYPE Type of exception that may be thrown.
     */
    default <RETURN_TYPE, EXCEPTION_TYPE extends Throwable>
    MaybeSpecification<RETURN_TYPE> map(Fn1<VALUE_TYPE, RETURN_TYPE, EXCEPTION_TYPE> fn) throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * If `Maybe` contains a value, returns it, else returns the result of `fnOther`
     *
     * @param fnOther A function.
     * @return The contained value or the result of `fnOther`
     * @throws EXCEPTION_TYPE Type of exception that may be thrown.
     */
    default <EXCEPTION_TYPE extends Throwable>
    VALUE_TYPE orElseGet(Fn0<VALUE_TYPE, EXCEPTION_TYPE> fnOther) throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * If `Maybe` contains a value, returns it, else returns `other`
     *
     * @param other The other value
     * @return The contained value or the other value
     */
    default VALUE_TYPE orElse(VALUE_TYPE other) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Whether this is a `Nothing` or not
     *
     * @return true if called on `Nothing`
     */
    default boolean isNothing() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Whether this is a `Just` or not
     *
     * @return true if called on a `Just`
     */
    default boolean isJust() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Get the inner value. If the method is called on `Nothing`, throws a `NullPointerException`
     *
     * @return The inner value
     * @throws NullPointerException
     */
    default VALUE_TYPE value() throws NullPointerException {
        throw new UnsupportedOperationException("not implemented");
    }
}
