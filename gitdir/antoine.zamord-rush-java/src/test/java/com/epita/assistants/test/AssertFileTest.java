package com.epita.assistants.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class AssertFileTest {
    public com.epita.assistants.test.Assert assertInstance;

    @Rule
    public ExpectedException assertion = ExpectedException.none();

    @BeforeClass
    public static void setupFileHierarchy() throws IOException {
        new File("./directory").mkdir();
        new File("./directory/file1.txt").createNewFile();
        new File("./directory/file2.txt").createNewFile();
        new File("./directory/file3.txt").createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter("./file.txt"));
        writer.write("Hello World!\n");
        writer.close();
    }

    @Before
    public void createAssertInstance() {
        this.assertInstance = new com.epita.assistants.test.Assert();
    }

    @Test
    public void existsDoesNotThrowIfTheFileIsADirectory() {
        var path = Paths.get("./directory");
        Assert.assertEquals(path, assertInstance.file.exists(path));
    }

    @Test
    public void existsDoesNotThrowIfTheFileIsARegularFile() {
        var path = Paths.get("./file.txt");
        Assert.assertEquals(path, assertInstance.file.exists(path));
    }

    @Test
    public void existsThrowsIfTheFileDoesNotExist() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected an existing file, got not an existing file");

        var path = Paths.get("./unknown");
        assertInstance.file.exists(path);
    }

    @Test
    public void suppliedExistsDoesNotThrowIfTheFileIsADirectory() {
        var path = Paths.get("./directory");
        Assert.assertEquals(path, assertInstance.file.exists(path, (given) -> new RuntimeException("Test failed")));
    }

    @Test
    public void suppliedExistsDoesNotThrowIfTheFileIsARegularFile() {
        var path = Paths.get("./file.txt");
        Assert.assertEquals(path, assertInstance.file.exists(path, (given) -> new RuntimeException("Test failed")));
    }

    @Test
    public void suppliedExistsThrowsIfTheFileDoesNotExist() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        var path = Paths.get("./unknown");
        assertInstance.file.exists(path, given -> {
            Assert.assertEquals(path, given);

            return custom;
        });
    }

    @Test
    public void isFileDoesNotThrowIfTheFileIsARegularFile() {
        var path = Paths.get("./file.txt");
        Assert.assertEquals(path, assertInstance.file.isFile(path));
    }

    @Test
    public void isFileThrowsIfTheFileIsADirectory() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected a regular file, got not a regular file");

        var path = Paths.get("./directory");
        assertInstance.file.isFile(path);
    }

    @Test
    public void isFileThrowsIfTheFileDoesNotExist() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected a regular file, got not a regular file");

        var path = Paths.get("./unknown");
        assertInstance.file.isFile(path);
    }

    @Test
    public void suppliedIsFileDoesNotThrowIfTheFileIsARegularFile() {
        var path = Paths.get("./file.txt");
        Assert.assertEquals(path, assertInstance.file.isFile(path, (given) -> new RuntimeException("Test failed")));
    }

    @Test
    public void suppliedIsFileThrowsIfTheFileIsADirectory() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        var path = Paths.get("./directory");
        assertInstance.file.isFile(path, given -> {
            Assert.assertEquals(path, given);

            return custom;
        });
    }

    @Test
    public void suppliedIsFileThrowsIfTheFileDoesNotExist() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        var path = Paths.get("./unknown");
        assertInstance.file.isFile(path, given -> {
            Assert.assertEquals(path, given);

            return custom;
        });
    }

    @Test
    public void isDirectoryDoesNotThrowIfTheFileIsADirectory() {
        var path = Paths.get("./directory");
        Assert.assertEquals(path, assertInstance.file.isDirectory(path));
    }

    @Test
    public void isDirectoryThrowsIfTheFileIsARegularFile() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected a directory, got not a directory");

        var path = Paths.get("./file.txt");
        assertInstance.file.isDirectory(path);
    }

    @Test
    public void isDirectoryThrowsIfTheFileDoesNotExist() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected a directory, got not a directory");

        var path = Paths.get("./unknown");
        assertInstance.file.isDirectory(path);
    }

    @Test
    public void suppliedIsDirectoryDoesNotThrowIfTheFileIsADirectory() {
        var path = Paths.get("./directory");
        Assert.assertEquals(path, assertInstance.file.isDirectory(path, (given) -> new RuntimeException("Test failed")));
    }

    @Test
    public void suppliedIsDirectoryThrowsIfTheFileIsARegularFile() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        var path = Paths.get("./file.txt");
        assertInstance.file.isDirectory(path, given -> {
            Assert.assertEquals(path, given);

            return custom;
        });
    }

    @Test
    public void suppliedIsDirectoryThrowsIfTheFileDoesNotExist() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        var path = Paths.get("./unknown");
        assertInstance.file.isDirectory(path, given -> {
            Assert.assertEquals(path, given);

            return custom;
        });
    }

    @Test
    public void isEmptyDoesNotThrowIfTheFileIsEmpty() {
        var path = Paths.get("./directory/file1.txt");
        Assert.assertEquals(path, assertInstance.file.isEmpty(path));
    }

    @Test
    public void isEmptyThrowsIfTheFileIsNotEmpty() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected an empty file, got not an empty file");

        var path = Paths.get("./file.txt");
        assertInstance.file.isEmpty(path);
    }

    @Test
    public void suppliedIsEmptyDoesNotThrowIfTheFileIsEmpty() {
        var path = Paths.get("./directory/file1.txt");
        Assert.assertEquals(path, assertInstance.file.isEmpty(path, (given) -> new RuntimeException("Test failed")));
    }

    @Test
    public void suppliedIsEmptyThrowsIfTheFileIsNotEmpty() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        var path = Paths.get("./file.txt");
        assertInstance.file.isEmpty(path, given -> {
            Assert.assertEquals(path, given);

            return custom;
        });
    }

    @Test
    public void isNotEmptyDoesNotThrowIfTheFileIsNotEmpty() {
        var path = Paths.get("./file.txt");
        Assert.assertEquals(path, assertInstance.file.isNotEmpty(path));
    }

    @Test
    public void isNotEmptyThrowsIfTheFileIsEmpty() {
        assertion.expect(AssertionError.class);
        assertion.expectMessage("Expected not an empty file, got an empty file");

        var path = Paths.get("./directory/file1.txt");
        assertInstance.file.isNotEmpty(path);
    }

    @Test
    public void suppliedIsNotEmptyDoesNotThrowIfTheFileIsNotEmpty() {
        var path = Paths.get("./file.txt");
        Assert.assertEquals(path, assertInstance.file.isNotEmpty(path, (given) -> new RuntimeException("Test failed")));
    }

    @Test
    public void suppliedIsNotEmptyThrowsIfTheFileIsEmpty() throws Exception {
        Exception custom = new Exception("My Message");

        assertion.expect(Exception.class);
        assertion.expectMessage(custom.getMessage());

        var path = Paths.get("./directory/file1.txt");
        assertInstance.file.isNotEmpty(path, given -> {
            Assert.assertEquals(path, given);

            return custom;
        });
    }
}
