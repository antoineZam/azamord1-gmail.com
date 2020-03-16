package com.epita.assistants.functional;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Tuple2SpecificationTest {
    @Test
    public void tuple() {
        var t = Tuple.tuple(1, "toto");

        assertEquals(t.first(), Integer.valueOf(1));
        assertEquals(t.second(), "toto");
    }

    @Test
    public void tupleWithNull() {
        var t = Tuple.tuple(1, null);
        assertEquals(t.first(), Integer.valueOf(1));
        assertNull(t.second());
    }
}