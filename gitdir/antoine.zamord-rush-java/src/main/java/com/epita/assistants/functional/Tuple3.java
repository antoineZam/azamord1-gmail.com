package com.epita.assistants.functional;

public class Tuple3<A_TYPE, B_TYPE, C_TYPE> implements Tuple3Specification<A_TYPE, B_TYPE, C_TYPE> {
    private A_TYPE first;
    private B_TYPE second;
    private C_TYPE third;

    public Tuple3(A_TYPE first, B_TYPE second, C_TYPE third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public A_TYPE first() {
        return this.first;
    }

    @Override
    public B_TYPE second() {
        return this.second;
    }

    @Override
    public C_TYPE third() {
        return this.third;
    }
}
