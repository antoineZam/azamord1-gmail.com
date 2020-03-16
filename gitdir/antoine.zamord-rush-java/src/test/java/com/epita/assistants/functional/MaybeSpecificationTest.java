package com.epita.assistants.functional;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaybeSpecificationTest {
    @Test
    public void maybeBuild() {
        Maybe<Integer> a = Maybe.maybe(4);
        assertTrue(a.isJust());

        Maybe<Integer> b = Maybe.maybe(null);
        assertTrue(b.isNothing());
    }

    @Test
    public void nothing() {
        Maybe<Integer> a = Maybe.nothing();
        assertTrue(a.isNothing());
    }

    @Test(expected = NullPointerException.class)
    public void justFromNull() {
        Maybe<Integer> m = Maybe.just(null);
    }

    @Test
    public void valueOfJust() {
        Maybe<Integer> a = Maybe.just(42);
        assertEquals(a.value(), Integer.valueOf(42));
    }

    @Test(expected = NullPointerException.class)
    public void valueOfNothing() {
        Maybe<Integer> a = Maybe.nothing();
        assertEquals(a.value(), Integer.valueOf(42));
    }

    @Test
    public void matchJust() {
        Maybe<Integer> a = Maybe.just(21);
        Integer res = a.match(x -> x * 2, () -> 1337);
        assertEquals(res, Integer.valueOf(42));
    }

    @Test
    public void matchNothing() {
        Maybe<Integer> a = Maybe.nothing();
        assertEquals(a.match(x -> x * 2, () -> 1337), Integer.valueOf(1337));
    }

    @Test
    public void mapJust() {
        Maybe<Integer> a = Maybe.just(21);
        assertEquals(a.map(x -> x * 2), Maybe.just(42));
    }

    @Test
    public void mapNothing() {
        Maybe<Integer> a = Maybe.nothing();
        assertEquals(a.map(x -> x * 2), Maybe.nothing());
    }

    @Test
    public void orElseGetJust() {
        Maybe<Integer> a = Maybe.just(21);
        assertEquals(a.orElseGet(() -> 42), Integer.valueOf(21));
    }

    @Test
    public void orElseGetNothing() {
        Maybe<Integer> a = Maybe.nothing();
        assertEquals(a.orElseGet(() -> 42), Integer.valueOf(42));
    }

    @Test
    public void orElseJust() {
        Maybe<Integer> a = Maybe.just(21);
        assertEquals(a.orElse(42), Integer.valueOf(21));
    }

    @Test
    public void orElseNothing() {
        Maybe<Integer> a = Maybe.nothing();
        assertEquals(a.orElse(42), Integer.valueOf(42));
    }

    @Test
    public void equals() {
        // `Maybe` should override equals() so that these tests pass:

        Maybe<Integer> a = Maybe.just(42);
        Maybe<Integer> b = Maybe.just(21);
        assertNotEquals(a, b);

        a = Maybe.just(42);
        b = Maybe.just(42);
        assertEquals(a, b);

        a = Maybe.nothing();
        b = Maybe.just(42);
        assertNotEquals(a, b);

        a = Maybe.nothing();
        b = Maybe.nothing();
        assertEquals(a, b);
    }
}