package com.epita.assistants.collections;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SetTest {
    private static Set<String> set;

    @BeforeClass
    public static void setUp() {
        set = Set.of("Rush", "Java");
    }

    @Test(timeout = 100)
    public void emptyTest() {
        Assert.assertFalse("Set is empty.", set.isEmpty());
    }

    @Test(timeout = 100)
    public void countTest() {
        Assert.assertEquals("Wrong element count.", 2, set.count());
    }

    @Test(timeout = 100)
    public void containsTest() {
        Assert.assertTrue("Value not found.", set.contains("Rush"));
    }

    @Test(timeout = 100)
    public void seqTest() {
        final var seq = set.seq();
        Assert.assertEquals("Seq was not correctly created", 2, seq.count());
    }
}
