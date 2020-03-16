package com.epita.assistants.files;

import java.io.*;
import java.net.URL;

public class File implements FileSpecification {
    private java.io.File file;

    public File(String path) {
        this.file = new java.io.File(path);
    }

    @Override
    public byte[] readBytes() throws FileNotFoundException {
        return readString().getBytes();
    }

    @Override
    public String readString() {
        var stringBuilder = new StringBuilder("");
        try (var br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }

        } catch (IOException ignored) {
        }
        return stringBuilder.toString();
    }

    @Override
    public String getName() {
        return file.getName();
    }

    static public File loadFromFileSystem(String path) {
        return new File(path);
    }

    static public File loadFromJar(String path) {
        URL url = File.class.getResource(path);
        return new File(url.toString());
    }


}
