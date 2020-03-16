package com.epita.assistants.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MutableSetTest {
    private Set.Mutable<Integer> set;

    @Before
    public void setUp() {
        set = Set.Mutable.of(1, 2, 3);
    }

    @Test (timeout = 100)
    public void countAfterInsertTest() {
        final var addRes = set.add(4);
        Assert.assertTrue("Element could not be inserted.", addRes);
        Assert.assertEquals("Count not updated after add.", 4, set.count());
    }

    @Test (timeout = 100)
    public void countAfterFailedInsertTest() {
        final var addRes = set.add(3);
        Assert.assertFalse("Element should not have been inserted.", addRes);
        Assert.assertEquals("Count was updated despite failed insert", 3, set.count());
    }

    @Test (timeout = 100)
    public void containsAfterInsertTest() {
        final var addRes = set.add(4);
        Assert.assertTrue("Element could not be inserted.", addRes);
        Assert.assertTrue("Inserted element could not be found.", set.contains(4));
    }

    @Test (timeout = 100)
    public void countAfterRemovalTest() {
        set.remove(3);
        Assert.assertEquals("Count not updated after removal.", 2, set.count());
    }

    @Test (timeout = 100)
    public void containsAfterRemovalTest() {
        set.remove(3);
        Assert.assertFalse("Element was not deleted.", set.contains(3));
    }
}
