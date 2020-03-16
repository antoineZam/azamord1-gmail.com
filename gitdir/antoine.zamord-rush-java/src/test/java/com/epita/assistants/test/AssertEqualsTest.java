package com.epita.assistants.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AssertEqualsTest {
    public com.epita.assistants.test.Assert assertInstance;

    @Rule
    public ExpectedException assertion = ExpectedException.none();

    @Before
    public void createAssertInstance() {
        this.assertInstance = new com.epita.assistants.test.Assert();
    }

    @Test
    public void isEqualDoesNotThrowIfTheObjectsAreEqual() {
        String s1 = new String("Hi");
        String s2 = new String("Hi");

        assertInstance.isEqual(s1, s2);
    }

    @Test
    public void isEqualThrowsIfTheObjectsAreDifferent() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected [Hi], got [Hello]");

        String s1 = new String("Hi");
        String s2 = new String("Hello");
        assertInstance.isEqual(s1, s2);
    }

    @Test
    public void suppliedIsEqualDoesNotThrowIfTheObjectsAreEqual() {
        Integer i1 = 1;
        Integer i2 = 1;
        assertInstance.isEqual(i1, i2, (given) -> new RuntimeException("Test failed"));
    }

    @Test
    public void suppliedIsEqualThrowsTheGivenExceptionIfTheObjectsAreDifferent() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        String s1 = "Test";
        String s2 = "Failed";

        assertInstance.isEqual(s1, s2, (given) -> {
            Assert.assertEquals(s2, given);

            return custom;
        });
    }

    @Test
    public void isNotEqualDoesNotThrowIfTheObjectsAreDifferent() {
        String s1 = new String("Hi");
        String s2 = new String("Hello");

        assertInstance.isNotEqual(s1, s2);
    }

    @Test
    public void isNotEqualThrowsIfTheObjectsAreEqual() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected a different value, got [Hi]");

        String s1 = new String("Hi");
        String s2 = new String("Hi");
        assertInstance.isNotEqual(s1, s2);
    }

    @Test
    public void suppliedIsNotEqualDoesNotThrowIfTheObjectsAreDifferent() {
        Integer i1 = 1;
        Integer i2 = 2;
        assertInstance.isNotEqual(i1, i2, (given) -> new RuntimeException("Test failed"));
    }

    @Test
    public void suppliedIsNotEqualThrowsTheGivenExceptionIfTheObjectsAreEqual() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        String s1 = "Test";
        String s2 = "Test";

        assertInstance.isNotEqual(s1, s2, (given) -> {
            Assert.assertEquals(s2, given);

            return custom;
        });
    }
}
