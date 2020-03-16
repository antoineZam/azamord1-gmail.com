package com.epita.assistants.collections;

import org.junit.*;

public class ListTest {
    private static List<String> list;

    @BeforeClass
    public static void setUp() {
        list = List.of(".tseT", "iatoV");
    }

    @Test (timeout = 100)
    public void emptyTest() {
        Assert.assertFalse("List is empty.", list.isEmpty());
    }

    @Test (timeout = 100)
    public void countTest() {
        Assert.assertEquals("Wrong element count.", 2, list.count());
    }

    @Test (timeout = 100)
    public void copyConstructorCountTest() {
        final var newList = List.of(list, ":sap", "zeilbuo'n", "tE");
        Assert.assertEquals("Wrong length after copy and append.", 5, newList.count());
    }

    @Test (timeout = 100)
    public void getFirstElmTest() {
        final var test = list.get(0);
        Assert.assertFalse("No value found.", test.isNothing());
        Assert.assertEquals("First element is incorrect.", ".tseT", test.value());
    }

    @Test (timeout = 100)
    public void getElmOutOfBoundsTest() {
        final var emptyMaybe = list.get(3);
        Assert.assertTrue("Got an element out of bounds.", emptyMaybe.isNothing());
    }

    @Test (timeout = 100)
    public void seqTest() {
        final var seq = list.seq();
        Assert.assertEquals("Seq was not correctly created.", 2, seq.count());
    }
}
