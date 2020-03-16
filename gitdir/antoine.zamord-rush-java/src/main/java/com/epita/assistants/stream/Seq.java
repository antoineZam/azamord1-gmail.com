package com.epita.assistants.stream;

import com.epita.assistants.collections.List;
import com.epita.assistants.collections.Map;
import com.epita.assistants.collections.Set;
import com.epita.assistants.functional.*;

import java.util.*;
import java.util.stream.Stream;

@FunctionalInterface
public interface Seq<ELEMENT_TYPE> extends SeqSpecification<ELEMENT_TYPE>{

    public Stream<ELEMENT_TYPE> getDelegate();

    @Override
    default <EXCEPTION_TYPE extends Throwable>
    void forEach(final Consumer<ELEMENT_TYPE, EXCEPTION_TYPE> consumer) throws EXCEPTION_TYPE {
        getDelegate().forEach(x -> {
            try {
                consumer.apply(x);
            } catch (Throwable exception) {
                throw (RuntimeException) exception;
            }
        });
    }

    @Override
    default <RES_TYPE, EXCEPTION_TYPE extends Throwable>
    Seq<RES_TYPE> map(final Fn1<ELEMENT_TYPE, RES_TYPE, EXCEPTION_TYPE> mapFn) throws EXCEPTION_TYPE {
        Stream<RES_TYPE> tmp = getDelegate().map(x -> {
            try {
                return mapFn.apply(x);
            } catch (Throwable exception) {
                throw (RuntimeException) exception;
            }
        });
        return () -> tmp;
    }

    @Override
    default <EXCEPTION_TYPE extends Throwable>
    Seq<ELEMENT_TYPE> filter(final Predicate<? super ELEMENT_TYPE, EXCEPTION_TYPE> predicate) throws EXCEPTION_TYPE {
       Stream<ELEMENT_TYPE> tmp = getDelegate().filter(x -> {
            try {
                return predicate.test(x);
            } catch (Throwable exception) {
                throw (RuntimeException) exception;
            }
        });
        return () -> tmp;
    }

    @Override
    default <RES_TYPE, EXCEPTION_TYPE extends Throwable>
    Seq<RES_TYPE> flatMap(final Fn1<? super ELEMENT_TYPE, ? extends SeqSpecification<RES_TYPE>, EXCEPTION_TYPE> flatFn) throws EXCEPTION_TYPE {
        ArrayList<RES_TYPE> list = new ArrayList<>();
        var tmp = getDelegate().map(x -> {
            try {
                return flatFn.apply(x).map(y -> list.add(y));
            } catch (Throwable exception) {
                throw (RuntimeException) exception;
            }
        });
        return () -> list.stream();
    }

    @Override
    default <EXCEPTION_TYPE extends Throwable>
    Seq<ELEMENT_TYPE> distinct() throws EXCEPTION_TYPE {
        var tmp = this.getDelegate().distinct();
        return () -> tmp;
    }

    @Override
    default <EXCEPTION_TYPE extends Throwable>
    Seq<ELEMENT_TYPE> sorted() throws EXCEPTION_TYPE {
        var tmp = this.getDelegate().sorted();
        return () -> tmp;
    }

    @Override
    default <EXCEPTION_TYPE extends Throwable>
    Seq<ELEMENT_TYPE> sorted(final Comparator<? super ELEMENT_TYPE> comparator) throws EXCEPTION_TYPE {
        var tmp = this.getDelegate().sorted(comparator);
        return () -> tmp;
    }

    @Override
    default Seq<ELEMENT_TYPE> limit(long maxSize) {
        var tmp = this.getDelegate().limit(maxSize);
        return () -> tmp;
    }

    @Override
    default Seq<ELEMENT_TYPE> skip(long maxSize) {
        var tmp = this.getDelegate().skip(maxSize);
        return () -> tmp;
    }

    @Override
    default List<ELEMENT_TYPE> toList() {
        ArrayList<ELEMENT_TYPE> tmp = new ArrayList<>();
        this.getDelegate().forEach(x -> tmp.add(x));
        return new List<ELEMENT_TYPE>(tmp);
    }

    @Override
    default Set<ELEMENT_TYPE> toSet() {
        HashSet<ELEMENT_TYPE> tmp = new HashSet<>();
        this.getDelegate().forEach(x -> tmp.add(x));
        return new Set<>(tmp);
    }

    @Override
    default <KEY_TYPE, VALUE_TYPE, EXCEPTION_TYPE extends Throwable>
    Map<KEY_TYPE, VALUE_TYPE> toMap(final Fn1<ELEMENT_TYPE, KEY_TYPE, EXCEPTION_TYPE> keyFn, final Fn1<ELEMENT_TYPE, VALUE_TYPE, EXCEPTION_TYPE> valueFn) throws EXCEPTION_TYPE {
        HashMap<KEY_TYPE, VALUE_TYPE> tmp = new HashMap<>();
        this.getDelegate().forEach(x -> {
            try {
                tmp.put(keyFn.apply(x), valueFn.apply(x));
            } catch (Throwable exception) {
                throw (RuntimeException) exception;
            }
        });
        return new Map<>(tmp);
    }

    @Override
    default Maybe<ELEMENT_TYPE> min(Comparator<? super ELEMENT_TYPE> comparator) {
        Optional<ELEMENT_TYPE> tmp = this.getDelegate().min(comparator);
        if (tmp.isEmpty())
            return new Maybe<ELEMENT_TYPE>(null);
        return new Maybe<ELEMENT_TYPE>(tmp.get());
    }

    @Override
    default Maybe<ELEMENT_TYPE> max(Comparator<? super ELEMENT_TYPE> comparator) {
        Optional<ELEMENT_TYPE> tmp = this.getDelegate().max(comparator);
        if (tmp.isEmpty())
            return new Maybe<ELEMENT_TYPE>(null);
        return new Maybe<ELEMENT_TYPE>(tmp.get());
    }

    @Override
    default long count() {
        long tmp = this.getDelegate().count();
        return tmp;
    }

    @Override
    default <EXCEPTION_TYPE extends Throwable>
    boolean anyMatch(Predicate<? super ELEMENT_TYPE, EXCEPTION_TYPE> predicate) throws EXCEPTION_TYPE {
        boolean tmp = this.getDelegate().anyMatch(x -> {
            try {
                return predicate.test(x);
            } catch (Throwable exception) {
                throw (RuntimeException) exception;
            }
        });
        return tmp;
    }

    @Override
    default <EXCEPTION_TYPE extends Throwable>
    boolean allMatch(Predicate<? super ELEMENT_TYPE, EXCEPTION_TYPE> predicate) throws EXCEPTION_TYPE {
        boolean tmp = this.getDelegate().allMatch(x -> {
            try {
                return predicate.test(x);
            } catch (Throwable exception) {
                throw (RuntimeException) exception;
            }
        });
        return tmp;
    }

    @Override
    default <EXCEPTION_TYPE extends Throwable>
    boolean noneMatch(Predicate<? super ELEMENT_TYPE, EXCEPTION_TYPE> predicate) throws EXCEPTION_TYPE {
        boolean tmp = this.getDelegate().noneMatch(x -> {
            try {
                return predicate.test(x);
            } catch (Throwable exception) {
                throw (RuntimeException) exception;
            }
        });
        return tmp;
    }

    @Override
    default Maybe<ELEMENT_TYPE> findFirst() {
        Optional<ELEMENT_TYPE> tmp = this.getDelegate().findFirst();
        if (tmp.isEmpty())
            return new Maybe<ELEMENT_TYPE>(null);
        return new Maybe<ELEMENT_TYPE>(tmp.get());
    }

    @Override
    default <EXCEPTION_TYPE extends Throwable> Maybe<ELEMENT_TYPE> findAny() {
        Optional<ELEMENT_TYPE> tmp = this.getDelegate().findAny();
        if (tmp.isEmpty())
            return new Maybe<ELEMENT_TYPE>(null);
        return new Maybe<ELEMENT_TYPE>(tmp.get());
    }

    @Override
    default <NEW_TYPE>
    Seq<NEW_TYPE> cast(final Class<NEW_TYPE> classToCastTo) {
        var tmp = this.getDelegate().filter(x -> {
            return (classToCastTo.isInstance(x));
        }).map(x -> classToCastTo.cast(x));
        return () -> tmp;
    }

    static public <ELEMENT_TYPE>
    Seq<ELEMENT_TYPE> of(ELEMENT_TYPE... elements) {
        return () -> Arrays.stream(elements);
    }

}
