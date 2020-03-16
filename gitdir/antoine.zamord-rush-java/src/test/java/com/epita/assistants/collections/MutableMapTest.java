package com.epita.assistants.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.epita.assistants.functional.Tuple.tuple;


public class MutableMapTest {
    private Map.Mutable<Float, String> map;

    @Before
    public void setUp() {
        map = Map.Mutable.of(tuple(1.5f, "Feel"),
                tuple(2.5f, "entertained"),
                tuple(3.5f, "Yet?"));
    }

    @Test(timeout = 100)
    public void copyConstructorCountTest() {
        final var newMap = Map.Mutable.ofMap(map, tuple(4.5f, "Bazooka"));
        Assert.assertEquals("Wrong length after copy and append.", 4, newMap.count());
    }

    @Test(timeout = 100)
    public void copyConstructorWithPair() {
        throw new UnsupportedOperationException("Bonus test!");
        /*  final var newMap = Map.Mutable.ofMap(map, pair(4.5f, "Core"), pair(5.5f, "War"));
         *  Assert.assertEquals("Wrong length after copy constructor.", 5, newMap.count());
         */
    }

    @Test(timeout = 100)
    public void countAfterInsertTest() {
        map.add(4.5f, "Tabouret");
        Assert.assertEquals("Count not updated after insertion", 4, map.count());
    }

    @Test(timeout = 100)
    public void getAfterInsertTest() {
        map.add(4.5f, "La coupe à la maison");
        final var maybe = map.get(4.5f);
        Assert.assertFalse("No element found after insertion.", maybe.isNothing());
        Assert.assertEquals("Wrong element found after insertion.", "La coupe à la maison", maybe.value());
    }

    @Test(timeout = 100)
    public void updateByInsertTest() {
        map.add(2.5f, "tired");
        final var maybe = map.get(2.5f);
        Assert.assertFalse("No element found after insertion.", maybe.isNothing());
        Assert.assertEquals("Value not updated correctly", "tired", maybe.value());
    }

    @Test(timeout = 100)
    public void countAfterRemoveTest() {
        map.remove(3.5f);
        Assert.assertEquals("Count not updated after removal.", 2, map.count());
    }

    @Test(timeout = 100)
    public void getRemovedElement() {
        final var removedElm = map.remove(3.5f);
        Assert.assertFalse("Unstored removed element.", removedElm.isNothing());
        Assert.assertEquals("Invalid returned element", "Yet?", removedElm.value());
    }

    @Test(timeout = 100)
    public void getAfterRemoveTest() {
        map.remove(3.5f);
        final var emptyElement = map.get(3.5f);
        Assert.assertTrue("Got a value after removal.", emptyElement.isNothing());
    }
}
