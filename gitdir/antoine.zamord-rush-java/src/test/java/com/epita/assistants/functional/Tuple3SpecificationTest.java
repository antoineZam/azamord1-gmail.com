package com.epita.assistants.functional;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tuple3SpecificationTest {
    @Test
    public void tuple() {
        var t = Tuple.tuple(1, 2, "toto");
        assertEquals(t.first(), Integer.valueOf(1));
        assertEquals(t.second(), Integer.valueOf(2));
        assertEquals(t.third(), "toto");
    }
}