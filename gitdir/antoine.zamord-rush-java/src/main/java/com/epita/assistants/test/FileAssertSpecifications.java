package com.epita.assistants.test;

import com.epita.assistants.functional.Fn1;

import java.nio.file.Path;

/**
 * The file assertion class
 */
public interface FileAssertSpecifications {
    /**
     * Check that the file at a given path exists.
     * Returns the path if the file exists.
     * Throws an assertion error if the file does not exist.
     *
     * @param given             The given path
     * @return                  The given path if the file exists
     * @throws AssertionError   The assertion error
     */
    default Path exists(final Path given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that the file at a given path exists.
     * Returns the path if the file exists.
     * Throws the value returned by the supplier if the file does not exist.
     *
     * @param given             The given path
     * @param exception         The supplier giving the exception
     * @param <EXCEPTION_TYPE>  Type of thrown exception
     * @return                  The given path if the file exists
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <EXCEPTION_TYPE extends Throwable> Path exists(final Path given,
                                                           final Fn1.Safe<Path, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that the file at a given path is a directory.
     * Returns the path if the file is a directory.
     * Throws an assertion error if the file is not a directory.
     *
     * @param given             The given path
     * @return                  The given path if the file is a directory
     * @throws AssertionError   The assertion error
     */
    default Path isDirectory(final Path given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that the file at a given path is a directory.
     * Returns the path if the file is a directory.
     * Throws the value returned by the supplier if the file is not a directory.
     *
     * @param given             The given path
     * @param exception         The supplier giving the exception
     * @param <EXCEPTION_TYPE>  Type of thrown exception
     * @return                  The given path if the file is a directory
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <EXCEPTION_TYPE extends Throwable> Path isDirectory(final Path given,
                                                                final Fn1.Safe<Path, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that the file at a given path is a regular file.
     * Returns the path if the file is a regular file.
     * Throws an assertion error if the file is not a regular file.
     *
     * @param given             The given path
     * @return                  The given path if the file is a regular file
     * @throws AssertionError   The assertion error
     */
    default Path isFile(final Path given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that the file at a given path is a regular file.
     * Returns the path if the file is a regular file.
     * Throws the value returned by the supplier if the file is not a regular file.
     *
     * @param given             The given path
     * @param exception         The supplier giving the exception
     * @param <EXCEPTION_TYPE>  Type of thrown exception
     * @return                  The given path if the file is a regular file
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <EXCEPTION_TYPE extends Throwable> Path isFile(final Path given,
                                                           final Fn1.Safe<Path, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that the file at a given path is empty.
     * Returns the path if the file is empty.
     * Throws an assertion error if the file is not empty.
     *
     * @param given             The given path
     * @return                  The given path if the file is empty
     * @throws AssertionError   The assertion error
     */
    default Path isEmpty(final Path given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that the file at a given path is empty.
     * Returns the path if the file is empty.
     * Throws the value returned by the supplier if the file is not empty.
     *
     * @param given             The given path
     * @param exception         The supplier giving the exception
     * @param <EXCEPTION_TYPE>  Type of thrown exception
     * @return                  The given path if the file is empty
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <EXCEPTION_TYPE extends Throwable> Path isEmpty(final Path given,
                                                            final Fn1.Safe<Path, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that the file at a given path is not empty.
     * Returns the path if the file is not empty.
     * Throws an assertion error if the file is empty.
     *
     * @param given             The given path
     * @return                  The given path if the file is not empty
     * @throws AssertionError   The assertion error
     */
    default Path isNotEmpty(final Path given) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Check that the file at a given path is not empty.
     * Returns the path if the file is not empty.
     * Throws the value returned by the supplier if the file is empty.
     *
     * @param given             The given path
     * @param exception         The supplier giving the exception
     * @param <EXCEPTION_TYPE>  Type of thrown exception
     * @return                  The given path if the file is not empty
     * @throws EXCEPTION_TYPE   The exception returned by the supplier
     */
    default <EXCEPTION_TYPE extends Throwable> Path isNotEmpty(final Path given,
                                                               final Fn1.Safe<Path, EXCEPTION_TYPE> exception)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }
}
