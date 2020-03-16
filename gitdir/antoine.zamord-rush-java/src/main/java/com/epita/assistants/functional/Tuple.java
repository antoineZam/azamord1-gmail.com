package com.epita.assistants.functional;

public class Tuple {

    static public <A_TYPE, B_TYPE>
    Tuple2<A_TYPE, B_TYPE> tuple(A_TYPE first, B_TYPE second) {
        return new Tuple2(first, second);
    }

    static public <A_TYPE, B_TYPE, C_TYPE>
    Tuple3<A_TYPE, B_TYPE, C_TYPE> tuple(A_TYPE first, B_TYPE second, C_TYPE third) {
        return new Tuple3(first, second, third);
    }
}
