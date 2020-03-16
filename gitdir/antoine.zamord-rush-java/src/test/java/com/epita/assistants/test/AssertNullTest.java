package com.epita.assistants.test;

import com.epita.assistants.test.AssertionError;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AssertNullTest {
    public com.epita.assistants.test.Assert assertInstance;

    @Rule
    public ExpectedException assertion = ExpectedException.none();

    @Before
    public void createAssertInstance() {
        this.assertInstance = new com.epita.assistants.test.Assert();
    }

    @Test
    public void isNullDoesNotThrowIfTheObjectIsNull() {
        Assert.assertNull(assertInstance.isNull(null));
    }

    @Test
    public void isNullThrowsIfTheObjectIsNotNull() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected null, got [0]");

        assertInstance.isNull(0);
    }

    @Test
    public void suppliedIsNullDoesNotThrowIfTheObjectIsNull() {
        Assert.assertNull(assertInstance.isNull(null, (given) -> new RuntimeException("Test failed")));
    }

    @Test
    public void suppliedIsNullThrowsTheGivenExceptionIfTheObjectIsNull() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        String value = "Test";

        assertInstance.isNull(value, (given) -> {
            Assert.assertEquals(value, given);

            return custom;
        });
    }

    @Test
    public void isNotNullReturnsTheGivenObjectIfItIsNotNull() {
        Integer i = 2;

        Assert.assertEquals(i, assertInstance.isNotNull(i));
    }

    @Test
    public void isNotNullThrowsIfTheObjectIsNull() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected not null, got [null]");

        assertInstance.isNotNull(null);
    }

    @Test
    public void suppliedIsNotNullReturnsTheGivenObjectIfItIsNotNull() {
        String value = "Returned value";

        Assert.assertEquals(value, assertInstance.isNotNull(value, (given) -> new RuntimeException("Test failed")));
    }

    @Test
    public void suppliedIsNotNullThrowsTheGivenExceptionIfTheObjectIsNull() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        assertInstance.isNotNull(null, (given) -> {
            Assert.assertEquals(null, given);

            return custom;
        });
    }
}
