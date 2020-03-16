package com.epita.assistants.files;

import com.epita.assistants.collections.List;
import com.epita.assistants.stream.Seq;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileSpecificationTest {
    @Rule
    public ExpectedException fileNotFound = ExpectedException.none();

    @BeforeClass
    public static void setupFileHierarchy() throws IOException {
        new java.io.File("./directory").mkdir();
        new java.io.File("./directory/file1.txt").createNewFile();
        new java.io.File("./directory/file2.txt").createNewFile();
        new java.io.File("./directory/file3.txt").createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter("./file.txt"));
        writer.write("Hello World!\n");
        writer.close();
    }

    @AfterClass
    public static void tearDownFileHierarchy() {
        new java.io.File("./file.txt").delete();
        new java.io.File("./directory").delete();
    }

    @Test(timeout = 100)
    public void loadExistingFileFromFileSystem() {
        File f = File.loadFromFileSystem("./file.txt");
        assertNotNull(f);
    }

    @Test(timeout = 100)
    public void loadNonExistantFileFromFileSystem() {
        fileNotFound.expect(FileError.class);
        fileNotFound.expectMessage("The file 'unknown.txt' was not found.");

        File.loadFromFileSystem("unknown.txt");
    }

    @Test(timeout = 100)
    public void loadExistingFromJar() {
        File f = File.loadFromJar("/file.txt");
        assertNotNull(f);
    }

    @Test(timeout = 100)
    public void loadNonExistantFromJar() {
        fileNotFound.expect(FileError.class);
        fileNotFound.expectMessage("The file '/unknown.txt' was not found.");

        File.loadFromJar("/unknown.txt");
    }

    @Test(timeout = 100)
    public void readBytes() {
        File f = File.loadFromJar("/file.txt");
        byte[] expected = "Hello World!\n".getBytes();

        byte[] content = f.readBytes();
        assertArrayEquals(expected, content);
    }

    @Test(timeout = 100)
    public void readString() {
        File f = File.loadFromJar("/file.txt");
        String expected = "Hello World!\n";

        String content = f.readString();
        assertEquals(expected, content);
    }

    @Test(timeout = 100)
    public void bytes_seq() {
        File f = File.loadFromJar("/file.txt");
        byte[] expected = "Hello World!\n".getBytes();

        Seq<Byte> seq = f.bytes.seq();
        List<Byte> content = seq.toList();

        final byte[] result = new byte[expected.length];
        for (int i = 0; i < expected.length; i++) {
            result[i] = content.get(i).value();
        }

        assertArrayEquals(expected, result);
    }

    @Test(timeout = 100)
    public void bytesSeqOrElseThrow() {
        throw new UnsupportedOperationException("Bonus test!");

        /*  File f = File.loadFromJar("/file.txt");
         *  byte[] expected = "Hello World!\n".getBytes();
         *
         *  Seq<Byte> seq = f.bytes.seq();
         *  List<Byte> content = seq.toList();
         *
         *  final byte[] result = new byte[expected.length];
         *  for (int i = 0; i < expected.length; i++) {
         *      result[i] = content.get(i).orElseThrow();
         *  }
         *
         *  assertArrayEquals(expected, result);
         */
    }

    @Test(timeout = 100)
    public void chars_seq() {
        File f = File.loadFromJar("/file.txt");

        List.Mutable<Character> expected = List.Mutable.of();
        for (Character c : "Hello World!\n".toCharArray()) {
            expected.add(c);
        }

        Seq<Character> seq = f.chars.seq();
        List<Character> content = seq.toList();

        assertEquals(expected, content);
    }

    @Test(timeout = 100)
    public void lines_seq() {
        File f = File.loadFromJar("/multi-line.txt");
        List<String> expected = List.of("Hello", "In", "Multi", "Line");

        Seq<String> seq = f.lines.seq();
        List<String> content = seq.toList();

        assertEquals(expected, content);
    }
}
