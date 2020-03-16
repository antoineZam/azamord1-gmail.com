package com.epita.assistants.collections;

import com.epita.assistants.functional.Maybe;
import com.epita.assistants.functional.MaybeSpecification;
import com.epita.assistants.stream.SeqSpecification;

import java.util.ArrayList;

public class List<ELEMENT_TYPE> implements ListSpecification<ELEMENT_TYPE> {
    public ArrayList<ELEMENT_TYPE> list;

    public List(ArrayList<ELEMENT_TYPE> list) {
        this.list = list;
    }

    @Override
    public MaybeSpecification get(int index) {
        if (index < 0 || index > this.list.size()) {
            return new Maybe();
        } else {
            return new Maybe(this.list.get(index));
        }
    }

    @Override
    public SeqSpecification seq() {
        return null;
    }

    static public class Mutable<ELEMENT_TYPE> extends List<ELEMENT_TYPE> implements ListSpecification.Mutable<ELEMENT_TYPE> {

        public Mutable(ArrayList<ELEMENT_TYPE> list) {
            super(list);
        }

        @Override
        public void add(ELEMENT_TYPE element) {
            this.list.add(element);
        }

        @Override
        public MaybeSpecification<ELEMENT_TYPE> remove(int index) {
            if (index < 0 || index >= this.list.size()) {
                return new Maybe();
            }
            var remove = this.list.get(index);
            this.list.remove(index);
            return new Maybe(remove);
        }

        static public <ELEMENT_TYPE>
        List<ELEMENT_TYPE> of(ELEMENT_TYPE... list) {
            var arrayList = new ArrayList<ELEMENT_TYPE>();
            for (var i : list) {
                arrayList.add(i);
            }
            return new List.Mutable<ELEMENT_TYPE>(arrayList);
        }
    }

    static public <ELEMENT_TYPE>
    List<ELEMENT_TYPE> of(ELEMENT_TYPE... list) {
        var arrayList = new ArrayList<ELEMENT_TYPE>();
        for (var i : list) {
            arrayList.add(i);
        }
        return new List<ELEMENT_TYPE>(arrayList);
    }
}

