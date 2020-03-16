package com.epita.assistants.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AssertBooleanTest {
    public com.epita.assistants.test.Assert assertInstance;

    @Rule
    public ExpectedException assertion = ExpectedException.none();

    @Before
    public void createAssertInstance() {
        this.assertInstance = new com.epita.assistants.test.Assert();
    }

    @Test
    public void isTrueDoesNotThrowIfTheBooleanIsTrue() {
        Assert.assertTrue(assertInstance.isTrue(true));
    }

    @Test
    public void isTrueThrowsIfTheBooleanIsFalse() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected [true], got [false]");

        assertInstance.isTrue(false);
    }

    @Test
    public void suppliedIsTrueDoesNotThrowIfTheBooleanIsTrue() {
        Assert.assertTrue(assertInstance.isTrue(true, (given) -> new RuntimeException("Test failed")));
    }

    @Test
    public void suppliedIsTrueThrowsTheGivenExceptionIfTheBooleanIsFalse() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        assertInstance.isTrue(false, (given) -> {
            Assert.assertEquals(false, given);

            return custom;
        });
    }

    @Test
    public void isFalseDoesNotThrowIfTheBooleanIsFalse() {
        Assert.assertFalse(assertInstance.isFalse(false));
    }

    @Test
    public void isFalseThrowsIfTheBooleanIsTrue() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected [false], got [true]");

        assertInstance.isFalse(true);
    }

    @Test
    public void suppliedIsFalseDoesNotThrowIfTheBooleanIsFalse() {
        Assert.assertFalse(assertInstance.isFalse(false, (given) -> new RuntimeException("Test failed")));
    }

    @Test
    public void suppliedIsFalseThrowsTheGivenExceptionIfTheBooleanIsTrue() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        assertInstance.isFalse(true, (given) -> {
            Assert.assertEquals(true, given);

            return custom;
        });
    }
}
