package com.epita.assistants.collections;

import com.epita.assistants.functional.Maybe;
import com.epita.assistants.functional.Tuple2;
import com.epita.assistants.functional.Tuple2Specification;
import com.epita.assistants.stream.SeqSpecification;

import java.util.HashMap;

public class Map<KEY_TYPE, VALUE_TYPE> implements MapSpecification<KEY_TYPE, VALUE_TYPE> {
    public HashMap<KEY_TYPE, VALUE_TYPE> map;

    public Maybe<VALUE_TYPE> get(KEY_TYPE key) {
        if (this.map.containsKey(key))
        {
            return new Maybe<VALUE_TYPE>(this.map.get(key));
        }
        return new Maybe<VALUE_TYPE>();
    }

    @Override
    public <ENTRY_TYPE extends Tuple2Specification<KEY_TYPE, VALUE_TYPE>> SeqSpecification<? extends Tuple2Specification<KEY_TYPE, VALUE_TYPE>> seq() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public int count() {
        return this.map.size();
    }


    static public class Mutable<KEY_TYPE, VALUE_TYPE> extends Map<KEY_TYPE, VALUE_TYPE> implements MapSpecification.Mutable<KEY_TYPE, VALUE_TYPE> {
        @Override
        public void add(KEY_TYPE key, VALUE_TYPE value) {
            this.map.put(key, value);
        }

        @Override
        public Maybe<VALUE_TYPE> remove(KEY_TYPE key) {
            var tmp = new Maybe<VALUE_TYPE>(this.map.get(key));
            this.map.remove(key);
            return tmp;
        }
        static public <KEY_TYPE, VALUE_TYPE>
        Map<KEY_TYPE, VALUE_TYPE> of(Tuple2<KEY_TYPE, VALUE_TYPE>...pair) {
            Map<KEY_TYPE, VALUE_TYPE> newMap =   new Map<KEY_TYPE, VALUE_TYPE>();
            for (var i : pair)
            {
            }
            return newMap;
        }
    }
}
