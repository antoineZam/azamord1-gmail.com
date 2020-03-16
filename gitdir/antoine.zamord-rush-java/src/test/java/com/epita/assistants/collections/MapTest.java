package com.epita.assistants.collections;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.epita.assistants.functional.Tuple.tuple;


public class MapTest {
    private static Map<String, String> map;

    @BeforeClass
    public static void setUp() {
        map = Map.of(tuple("Wesh", "alors!"), tuple("Votai", "Test."));
    }

    @Test(timeout = 100)
    public void emptyTest() {
        Assert.assertFalse("Map is empty.", map.isEmpty());
    }

    @Test(timeout = 100)
    public void countTest() {
        Assert.assertEquals("Wrong entry count.", 2, map.count());
    }

    @Test(timeout = 100)
    public void copyConstructorCountTest() {
        final var newMap = Map.ofMap(map, tuple("Oui", "Non"), tuple("Code", "Lyoko"));
        Assert.assertEquals("Wrong length after copy constructor.", 4, newMap.count());
    }

    @Test(timeout = 100)
    public void copyConstructorWithPair() {
        throw new UnsupportedOperationException("Bonus test!");
        /*  final var newMap = Map.ofMap(map, pair("Tuple", "Pair"), pair("Civil", "War"));
         *  Assert.assertEquals("Wrong length after copy constructor.", 4, newMap.count());
         */
    }

    @Test(timeout = 100)
    public void getExistingElmTest() {
        final var callMeMaybe = map.get("Wesh");
        Assert.assertFalse("No value found.", callMeMaybe.isNothing());
        Assert.assertEquals("Wrong value found.", "alors!", callMeMaybe.value());
    }

    @Test(timeout = 100)
    public void getNonExistingElmTest() {
        final var empty = map.get("Patatras!");
        Assert.assertTrue("Value found.", empty.isNothing());
    }

    @Test(timeout = 100)
    public void seqTest() {
        final var seq = map.seq();
        Assert.assertEquals("Seq was not correctly created.", 2, seq.count());
    }
}
