package com.epita.assistants.test;

import com.epita.assistants.collections.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AssertEmptyTest {
    public com.epita.assistants.test.Assert assertInstance;

    @Rule
    public ExpectedException assertion = ExpectedException.none();

    @Before
    public void createAssertInstance() {
        this.assertInstance = new com.epita.assistants.test.Assert();
    }

    @Test
    public void isEmptyDoesNotThrowIfTheCollectionIsEmpty() {
        assertInstance.isEmpty(List.of());
    }

    @Test
    public void isEmptyThrowsIfTheCollectionIsNotEmpty() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected empty, got not empty");

        assertInstance.isEmpty(List.of(1));
    }

    @Test
    public void suppliedIsEmptyDoesNotThrowIfTheCollectionIsEmpty() {
        assertInstance.isEmpty(List.of(), (given) -> new RuntimeException("Test failed"));
    }

    @Test
    public void suppliedIsEmptyThrowsTheGivenExceptionIfTheCollectionIsNotEmpty() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        var list = List.of("Hello");
        assertInstance.isEmpty(list, (given) -> {
            Assert.assertEquals(list, given);

            return custom;
        });
    }

    @Test
    public void isNotEmptyDoesNotThrowIfTheCollectionIsNotEmpty() {
        assertInstance.isNotEmpty(List.of(1));
    }

    @Test
    public void isNotEmptyThrowsIfTheCollectionIsEmpty() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected not empty, got empty");

        assertInstance.isNotEmpty(List.of());
    }

    @Test
    public void suppliedIsNotEmptyDoesNotThrowIfTheCollectionIsNotEmpty() {
        assertInstance.isNotEmpty(List.of("Test"), (given) -> new RuntimeException("Test failed"));
    }

    @Test
    public void suppliedIsNotEmptyThrowsTheGivenExceptionIfTheCollectionIsEmpty() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        var list = List.of();
        assertInstance.isNotEmpty(list, (given) -> {
            Assert.assertEquals(list, given);

            return custom;
        });
    }
}
