package com.epita.assistants.test;

import com.epita.assistants.collections.CollectionSpecification;
import com.epita.assistants.functional.Fn1;

public class Assert implements AssertSpecifications {


    @Override
    public <VALUE_TYPE> VALUE_TYPE isNull(VALUE_TYPE given) {
        if (given == null)
            return null;
        throw new AssertionError(null, given);
    }

    @Override
    public <VALUE_TYPE, EXCEPTION_TYPE extends Throwable> VALUE_TYPE isNull(VALUE_TYPE given, Fn1.Safe<VALUE_TYPE, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
        if (given == null)
        {
            return null;
        }
        throw exception.apply(given);
    }

    @Override
    public <VALUE_TYPE> VALUE_TYPE isNotNull(VALUE_TYPE given) {
        if (given != null)
            return given;
        throw new AssertionError("Anything, anything but that...", null);
    }

    @Override
    public <VALUE_TYPE, EXCEPTION_TYPE extends Throwable> VALUE_TYPE isNotNull(VALUE_TYPE given, Fn1.Safe<VALUE_TYPE, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
        if (given != null)
            return given;
        throw exception.apply(null);
    }

    @Override
    public <VALUE_TYPE> VALUE_TYPE isEqual(Object expected, VALUE_TYPE given) {
        if (expected.equals(given) == true) {
            return given;
        }
        throw new AssertionError(expected, given);
    }

    @Override
    public <VALUE_TYPE, EXCEPTION_TYPE extends Throwable> VALUE_TYPE isEqual(Object expected, VALUE_TYPE given, Fn1.Safe<VALUE_TYPE, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
        if (expected.equals(given) == true) {
            return given;
        }
        throw exception.apply(given);
    }

    @Override
    public <VALUE_TYPE> VALUE_TYPE isNotEqual(Object expected, VALUE_TYPE given) {
            if (expected.equals(given) != true) {
            return given;
        }
        throw new AssertionError(expected, given);
    }

    @Override
    public <VALUE_TYPE, EXCEPTION_TYPE extends Throwable> VALUE_TYPE isNotEqual(Object expected, VALUE_TYPE given, Fn1.Safe<VALUE_TYPE, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
        if (expected.equals(given) != true) {
            return given;
        }
        throw exception.apply(given);
    }

    @Override
    public boolean isTrue(boolean given) {
        if (given)
        {
            return true;
        }
        throw new AssertionError(true, false);
    }

    @Override
    public <EXCEPTION_TYPE extends Throwable> boolean isTrue(boolean given, Fn1.Safe<Boolean, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
        if (given)
        {
            return true;
        }
        throw exception.apply(false);
    }

    @Override
    public boolean isFalse(boolean given) {
        if (!given)
        {
            return true;
        }
        throw new AssertionError(false, true);
    }

    @Override
    public <EXCEPTION_TYPE extends Throwable> boolean isFalse(boolean given, Fn1.Safe<Boolean, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
        if (!given)
        {
            return true;
        }
        throw exception.apply(true);
    }

    @Override
    public <VALUE_TYPE extends CollectionSpecification> VALUE_TYPE isEmpty(VALUE_TYPE given) {
        if (given.isEmpty())
        {
            return given;
        }
        throw new AssertionError("you to be able to give me something empty... and I ", given);
    }

    @Override
    public <VALUE_TYPE extends CollectionSpecification, EXCEPTION_TYPE extends Throwable> VALUE_TYPE isEmpty(VALUE_TYPE given, Fn1.Safe<VALUE_TYPE, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
        if (given.isEmpty()) {
            return given;
        }
        throw exception.apply(given);
    }

    @Override
    public <VALUE_TYPE extends CollectionSpecification> VALUE_TYPE isNotEmpty(VALUE_TYPE given) {
        if (!given.isEmpty())
        {
            return given;
        }
        throw new AssertionError("you to be able to give me something NOT empty... and I ", given);
    }

    @Override
    public <VALUE_TYPE extends CollectionSpecification, EXCEPTION_TYPE extends Throwable> VALUE_TYPE isNotEmpty(VALUE_TYPE given, Fn1.Safe<VALUE_TYPE, EXCEPTION_TYPE> exception) throws EXCEPTION_TYPE {
        if (!given.isEmpty()) {
            return given;
        }
        throw exception.apply(given);
    }
}
