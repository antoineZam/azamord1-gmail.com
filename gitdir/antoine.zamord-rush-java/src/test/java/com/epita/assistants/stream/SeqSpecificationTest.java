package com.epita.assistants.stream;

import com.epita.assistants.collections.List;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class SeqSpecificationTest {

    @Test
    public void testInitializationInline() {
        Assert.assertEquals(Seq.of(1, 2, 4).toList(), List.of(1, 2, 4));
    }

    @Test
    public void forEach() {
        final AtomicInteger i = new AtomicInteger();
        Seq.of(1, 2, 3, 4).forEach(i::addAndGet);
        Assert.assertEquals(10, i.get());
    }

    @Test
    public void map() {
        var list = Seq.of(1, 2, 3, 4).map(i -> i * i).toList();
        Assert.assertEquals(List.of(1, 4, 9, 16), list);
    }

    @Test
    public void filter() {
        var list = Seq.of(1, 2, 3, 4).filter(i -> i % 2 == 0).toList();
        Assert.assertEquals(List.of(2, 4), list);
    }

    @Test
    public void flatMap() {
        var testedList = Seq.of(List.of(1, 2, 3), List.of(4, 5, 6)).flatMap(elmList -> { return elmList.seq(); }).toList();
        var expectedList = List.of(1, 2, 3, 4, 5, 6);
        Assert.assertEquals("FlatMap did not map... flatly?", expectedList, testedList);
    }

    @Test
    public void distinct() {
        var list = Seq.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4).distinct().toList();
        Assert.assertEquals(List.of(1, 2, 3, 4), list);
    }

    @Test
    public void sorted() {
        var array = Seq.of("4", "2", "1", "33");
        var a2 = array.sorted();
        var list = a2.toList();
        Assert.assertNotEquals(List.of("1", "2", "4", "33"), list);
        Assert.assertEquals(List.of("1", "2", "33", "4"), list);
    }

    @Test
    public void limit() {
        var list = Seq.of(1, 2, 3, 4, 5, 6, 7, 8, 9).limit(4).toList();
        Assert.assertEquals(List.of(1, 2, 3, 4), list);
    }

    @Test
    public void skip() {
        var list = Seq.of(1, 2, 3, 4, 5, 6, 7, 8, 9).skip(4).toList();
        Assert.assertEquals(List.of(5, 6, 7, 8, 9), list);
    }

    @Test
    public void toList() {
        var list = Seq.of(1, 2, 3).toList();
        Assert.assertEquals(Integer.valueOf(1), list.get(0).orElse(-42));
        Assert.assertEquals(Integer.valueOf(2), list.get(1).orElse(-42));
        Assert.assertEquals(Integer.valueOf(3), list.get(2).orElse(-42));
        Assert.assertEquals(Integer.valueOf(-42), list.get(42).orElse(-42));
    }

    @Test
    public void toSet() {

        var set = Seq.of(1, 2, 3).toSet();
        Assert.assertFalse(set.contains(0));
        Assert.assertFalse(set.contains(42));
        Assert.assertTrue(set.contains(1));
        Assert.assertTrue(set.contains(2));
    }

    @Test
    public void toMap() {
        var map = Seq.of(1, 2, 3).toMap(i -> i, i -> i * i);
        Assert.assertEquals(Integer.valueOf(1), map.get(1).value());
        Assert.assertEquals(Integer.valueOf(4), map.get(2).value());
    }



    @Test
    public void min() {
        Assert.assertEquals(Integer.valueOf(-21), Seq.of(-21, 12, 13).min(Comparator.comparingInt(i -> i)).orElse(-42));
        Assert.assertEquals(Integer.valueOf(-42), Seq.<Integer>of().min(Comparator.comparingInt(i -> i)).orElse(-42));
    }

    @Test(expected = NullPointerException.class)
    public void minThrowing() {
        Assert.assertEquals(Integer.valueOf(-21), Seq.of(-21, null).min(Comparator.comparingInt(i -> i)).orElse(-42));
    }


    @Test
    public void max() {
        Assert.assertEquals(Integer.valueOf(13), Seq.of(-21, 12, 13).max(Comparator.comparingInt(i -> i)).orElse(-42));
        Assert.assertEquals(Integer.valueOf(-42), Seq.<Integer>of().max(Comparator.comparingInt(i -> i)).orElse(-42));
    }

    @Test(expected = NullPointerException.class)
    public void maxThrowing() {
        Assert.assertEquals(Integer.valueOf(-21), Seq.of(-21, null).max(Comparator.comparingInt(i -> i)).orElse(-42));
    }

    @Test
    public void count() {
        Assert.assertEquals(3, Seq.of(-21, 12, 13).count());
        Assert.assertEquals(0, Seq.of().count());
        Assert.assertEquals(2, Seq.of(-21, null).count());
    }

    @Test
    public void anyMatch() {
        Assert.assertFalse(Seq.of(-21, 12).anyMatch(Objects::isNull));
        Assert.assertTrue(Seq.of(-21, 12).anyMatch(Objects::nonNull));
        Assert.assertTrue(Seq.of(-21, null).anyMatch(Objects::nonNull));
    }

    @Test
    public void allMatch() {
        Assert.assertFalse(Seq.of(-21, 12).allMatch(Objects::isNull));
        Assert.assertTrue(Seq.of(-21, 12).allMatch(Objects::nonNull));
        Assert.assertFalse(Seq.of(-21, null).allMatch(Objects::nonNull));
    }

    @Test
    public void noneMatch() {

        Assert.assertTrue(Seq.of(-21, 12).noneMatch(Objects::isNull));
        Assert.assertFalse(Seq.of(-21, 12).noneMatch(Objects::nonNull));
        Assert.assertFalse(Seq.of(-21, null).noneMatch(Objects::nonNull));
    }

    @Test
    public void findFirst() {

        SeqSpecification<Number> numbers = Seq.of(-21, 12);
        Assert.assertEquals(-21, numbers.findAny().orElse(-42));

        Assert.assertTrue(Seq.of().findAny().isNothing());

    }

    @Test
    public void findAny() {

        SeqSpecification<Number> numbers = Seq.of(-21.0, 12);
        Assert.assertTrue(numbers.findAny().isJust());

        Assert.assertTrue(Seq.of().findAny().isNothing());
    }

    @Test
    public void cast() {
        Assert.assertEquals(1, Seq.of(-21.0, 12).cast(Integer.class).count());
        Assert.assertEquals(0, Seq.of().cast(Integer.class).count());
        Assert.assertEquals(0, Seq.of("pouet").cast(Integer.class).count());
    }
}