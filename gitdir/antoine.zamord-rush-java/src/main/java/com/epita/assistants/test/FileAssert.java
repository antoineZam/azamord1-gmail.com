package com.epita.assistants.test;

import com.epita.assistants.functional.Fn1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;

public class FileAssert implements FileAssertSpecifications {
    @Override
    public Path exists(Path given) {
       if (given.toFile().exists())
       {
           return given;
       }
       throw new AssertionError("You to give me an existing file ...And what did I get !? I ", given);
    }

    @Override
    public <EXCEPTION_TYPE extends Throwable> Path exists(Path given, Fn1.Safe<Path, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
    if (given.toFile().exists())
       {
           return given;
       }
    throw exception.apply(given);
    }

    @Override
    public Path isDirectory(Path given) {
        if (given.toFile().isDirectory()) {
            return given;
        }
        throw new AssertionError("You to give me an existing directory...And what did I get !? I ", given);
    }

    @Override
    public <EXCEPTION_TYPE extends Throwable> Path isDirectory(Path given, Fn1.Safe<Path, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
        if (given.toFile().isDirectory())
       {
           return given;
       }
    throw exception.apply(given);
    }

    @Override
    public Path isFile(Path given) {
        if (given.toFile().isFile()) {
            return given;
        }
        throw new AssertionError("You to give me an existing file...And what did I get !? I ", given);
    }

    @Override
    public <EXCEPTION_TYPE extends Throwable> Path isFile(Path given, Fn1.Safe<Path, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
       if (given.toFile().isFile())
       {
           return given;
       }
    throw exception.apply(given);
    }

    @Override
    public Path isEmpty(Path given) {
        if (given.toFile().length() == 0)
        {
            return given;
        }
        throw new AssertionError("you to give me an EMPTY file!...not that...I ", given);
    }

    @Override
    public <EXCEPTION_TYPE extends Throwable> Path isEmpty(Path given, Fn1.Safe<Path, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
       if (given.toFile().length() == 0)
        {
            return given;
        }
        throw exception.apply(given);
    }

    @Override
    public Path isNotEmpty(Path given) {
       if (given.toFile().length() != 0)
        {
            return given;
        }
        throw new AssertionError("you NOT to give me an empty file!...not that...I ", given);
    }

    @Override
    public <EXCEPTION_TYPE extends Throwable> Path isNotEmpty(Path given, Fn1.Safe<Path, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
        if (given.toFile().length() != 0)
        {
            return given;
        }
        throw exception.apply(given);
    }
}
