package com.epita.assistants.functional;

public class Tuple2<A_TYPE, B_TYPE> implements Tuple2Specification<A_TYPE, B_TYPE> {

    private A_TYPE first;
    private B_TYPE second;

    public Tuple2(A_TYPE first, B_TYPE second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public A_TYPE first() {
        return this.first;
    }

    @Override
    public B_TYPE second() {
        return this.second;
    }

}
