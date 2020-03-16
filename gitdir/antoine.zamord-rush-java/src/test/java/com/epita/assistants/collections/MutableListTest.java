package com.epita.assistants.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MutableListTest {
    private List.Mutable<Integer> list;

    @Before
    public void setUp() {
        list = List.Mutable.of(1, 2, 3);
    }

    @Test (timeout = 100)
    public void copyConstructorCountTest() {
        final var newList = List.Mutable.of(list, 4, 5);
        Assert.assertEquals("Wrong length after copy and append.", 5, newList.count());
    }

    @Test (timeout = 100)
    public void countAfterInsertTest() {
        list.add(4);
        Assert.assertEquals("Count not updated after add.", 4, list.count());
    }

    @Test (timeout = 100)
    public void getAfterInsertTest() {
        list.add(4);
        final var fourthElement = list.get(3);
        Assert.assertFalse("Got null on get after insertion.", fourthElement.isNothing());
        Assert.assertEquals("Got wrong value after insertion.", Integer.valueOf(4), fourthElement.value());
    }

    @Test (timeout = 100)
    public void countAfterRemoveTest() {
        list.remove(2);
        Assert.assertEquals("Count not updated after removal.", 2, list.count());
    }

    @Test (timeout = 100)
    public void getRemovedElement() {
        final var removedElm = list.remove(2);
        Assert.assertFalse("Unstored removed element.", removedElm.isNothing());
        Assert.assertEquals("Invalid returned element", Integer.valueOf(3), removedElm.value());
    }

    @Test (timeout = 100)
    public void getAfterRemoveTest() {
        list.remove(2);
        final var emptyElement = list.get(2);
        Assert.assertTrue("Got a value after removal.", emptyElement.isNothing());
    }
}