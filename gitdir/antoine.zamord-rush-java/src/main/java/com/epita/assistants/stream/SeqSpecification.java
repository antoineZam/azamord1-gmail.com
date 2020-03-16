package com.epita.assistants.stream;

import com.epita.assistants.collections.ListSpecification;
import com.epita.assistants.collections.MapSpecification;
import com.epita.assistants.collections.SetSpecification;
import com.epita.assistants.functional.Consumer;
import com.epita.assistants.functional.Fn1;
import com.epita.assistants.functional.Maybe;
import com.epita.assistants.functional.Predicate;

import java.util.Comparator;

/**
 * Base interface for sequences.
 *
 * @param <ELEMENT_TYPE> The type of element managed by the sequence.
 */
public interface SeqSpecification<ELEMENT_TYPE> {

    /**
     * Consumes elements from the sequence and applies the given consumer to each of them.
     *
     * @param consumer         The consumer to apply.
     * @param <EXCEPTION_TYPE> The type of exception that might be raised.
     * @throws EXCEPTION_TYPE Upon error in the consumer.
     */
    default <EXCEPTION_TYPE extends Throwable>
    void forEach(final Consumer<ELEMENT_TYPE, EXCEPTION_TYPE> consumer) throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Maps the content of the stream into another stream using the given mapping function.
     *
     * @param mapFn            The mapping function.
     * @param <RES_TYPE>       The result type.
     * @param <EXCEPTION_TYPE> The type of exception.
     * @return The sequence of the new type.
     * @throws EXCEPTION_TYPE Upon error in the mapping function.
     */
    default <RES_TYPE, EXCEPTION_TYPE extends Throwable>
    SeqSpecification<RES_TYPE> map(final Fn1<ELEMENT_TYPE, RES_TYPE, EXCEPTION_TYPE> mapFn) throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Filters elements from the stream, keeping only those validating the given predicate.
     *
     * @param predicate        The predicate to validate.
     * @param <EXCEPTION_TYPE> The type of exception that might be raised.
     * @return The sequence of the new type.
     * @throws EXCEPTION_TYPE Upon error in the predicate.
     */
    default <EXCEPTION_TYPE extends Throwable>
    SeqSpecification<ELEMENT_TYPE> filter(final Predicate<? super ELEMENT_TYPE, EXCEPTION_TYPE> predicate) throws
                                                                                                           EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Maps and flattens the sequence.
     *
     * @param flatFn           The flatMap function, returns a sequence.
     * @param <RES_TYPE>       The return type.
     * @param <EXCEPTION_TYPE> The type of exception that might be raised.
     * @return The sequence of the new type.
     * @throws EXCEPTION_TYPE Upon error in the predicate.
     */
    default <RES_TYPE, EXCEPTION_TYPE extends Throwable>
    SeqSpecification<RES_TYPE> flatMap(final Fn1<? super ELEMENT_TYPE, ? extends SeqSpecification<RES_TYPE>,
            EXCEPTION_TYPE> flatFn) throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Keeps only distinct elements into the sequence.
     *
     * @param <EXCEPTION_TYPE> The type of exception that might be raised.
     * @return The sequence of the new type.
     * @throws EXCEPTION_TYPE Upon error in the predicate.
     */
    default <EXCEPTION_TYPE extends Throwable>
    SeqSpecification<ELEMENT_TYPE> distinct() throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Sorts the stream according to natural order. May break and throw.
     *
     * @param <EXCEPTION_TYPE> The type of exception that might be raised.
     * @return The sequence of the new type.
     * @throws EXCEPTION_TYPE Upon error in the predicate.
     */
    default <EXCEPTION_TYPE extends Throwable>
    SeqSpecification<ELEMENT_TYPE> sorted() throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Sorts the stream using the given comparator.
     *
     * @param comparator       The comparator to use for sorting.
     * @param <EXCEPTION_TYPE> The type of exception that might be raised.
     * @return The sequence of the new type.
     * @throws EXCEPTION_TYPE Upon error in the predicate.
     */
    default <EXCEPTION_TYPE extends Throwable>
    SeqSpecification<ELEMENT_TYPE> sorted(final Comparator<? super ELEMENT_TYPE> comparator) throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Limits the number of entries in the sequence.
     *
     * @param maxSize The maximum size of the sequence.
     * @return The limited stream.
     */
    default SeqSpecification<ELEMENT_TYPE> limit(long maxSize) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Skips the n first elements of the sequence.
     *
     * @param maxSize The number of elements to skip.
     * @return The sequence of the new type.
     */
    default SeqSpecification<ELEMENT_TYPE> skip(long maxSize) {
        throw new UnsupportedOperationException("not implemented");
    }


    /**
     * Exports the given stream to a list.
     *
     * @return A list.
     */
    default ListSpecification<ELEMENT_TYPE> toList() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Exports the given stream to a set.
     *
     * @return A set.
     */
    default SetSpecification<ELEMENT_TYPE> toSet() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Exports the given stream to a map using two functions to extract the key
     * and value of each element.
     *
     * @param <EXCEPTION_TYPE> The type of exception that might be raised.
     * @param <KEY_TYPE>       The key type.
     * @param <VALUE_TYPE>     The value type.
     * @param keyFn            Key extraction function.
     * @param valueFn          Value extraction function.
     * @return A map.
     */
    default <KEY_TYPE, VALUE_TYPE, EXCEPTION_TYPE extends Throwable>
    MapSpecification<KEY_TYPE, VALUE_TYPE> toMap(final Fn1<ELEMENT_TYPE, KEY_TYPE, EXCEPTION_TYPE> keyFn,
                                                 final Fn1<ELEMENT_TYPE, VALUE_TYPE, EXCEPTION_TYPE> valueFn)
            throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Returns the element with the min value of the stream, according to the
     * given comparator.
     *
     * @param comparator The comparator used in order to detect the minimum.
     * @return The found value, wrapped in a {@link Maybe}.
     */
    default Maybe<ELEMENT_TYPE> min(Comparator<? super ELEMENT_TYPE> comparator) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Returns the element with the max value of the stream, according to the
     * given comparator.
     *
     * @param comparator The comparator used in order to detect the maximum.
     * @return The found value, wrapped in a {@link Maybe}.
     */
    default Maybe<ELEMENT_TYPE> max(Comparator<? super ELEMENT_TYPE> comparator) {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Counts the number of elements in the stream.
     *
     * @return The number of elements.
     */
    default long count() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Tests if any element matches the given predicate.
     *
     * @param predicate        The predicate to test against.
     * @param <EXCEPTION_TYPE> The potential type of exception.
     * @return {@code true}     If a matching element is found,
     * {@code false} otherwise.
     * @throws EXCEPTION_TYPE Upon error while testing the predicate.
     */
    default <EXCEPTION_TYPE extends Throwable>
    boolean anyMatch(Predicate<? super ELEMENT_TYPE, EXCEPTION_TYPE> predicate) throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Tests if all elements match the given predicate.
     *
     * @param predicate        The predicate to test against.
     * @param <EXCEPTION_TYPE> The potential type of exception.
     * @return {@code true}     If a matching element is found,
     * {@code false} otherwise.
     * @throws EXCEPTION_TYPE Upon error while testing the predicate.
     */
    default <EXCEPTION_TYPE extends Throwable>
    boolean allMatch(Predicate<? super ELEMENT_TYPE, EXCEPTION_TYPE> predicate) throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Tests if no element matches the given predicate.
     *
     * @param predicate        The predicate to test against.
     * @param <EXCEPTION_TYPE> The potential type of exception.
     * @return {@code true}     If a matching element is found,
     * {@code false} otherwise.
     * @throws EXCEPTION_TYPE Upon error while testing the predicate.
     */
    default <EXCEPTION_TYPE extends Throwable>
    boolean noneMatch(Predicate<? super ELEMENT_TYPE, EXCEPTION_TYPE> predicate) throws EXCEPTION_TYPE {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Finds the first element of the sequence.
     *
     * @return The first element as a {@link Maybe}.
     */
    default Maybe<ELEMENT_TYPE> findFirst() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Finds any element of the sequence.
     *
     * @return Any element as a {@link Maybe}.
     */
    default <EXCEPTION_TYPE extends Throwable>
    Maybe<ELEMENT_TYPE> findAny() {
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Filters elements of the sequence which are not instances of the given
     * class, and returns a sequence of its type.
     *
     * @param classToCastTo The class to cast to.
     * @param <NEW_TYPE>    The new type of the sequence.
     * @return The new sequence.
     */
    default <NEW_TYPE>
    SeqSpecification<NEW_TYPE> cast(final Class<NEW_TYPE> classToCastTo) {
        throw new UnsupportedOperationException("not implemented");
    }
}
