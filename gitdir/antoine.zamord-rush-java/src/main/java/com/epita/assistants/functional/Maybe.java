package com.epita.assistants.functional;

public class Maybe<VALUE_TYPE> implements MaybeSpecification<VALUE_TYPE> {
    private VALUE_TYPE value;
    private boolean just;

    public Maybe(VALUE_TYPE value) {
        if (this.value == null)
        {
            this.just = false;
        }
        else {
            this.just = true;
        }
    }

    public Maybe() {
        this.just = false;
    }


    @Override
    public <RETURN_TYPE, EXCEPTION_TYPE extends Throwable> RETURN_TYPE match(Fn1<VALUE_TYPE, RETURN_TYPE, EXCEPTION_TYPE> fn1, Fn0<RETURN_TYPE, EXCEPTION_TYPE> fn0) throws EXCEPTION_TYPE {
        if (this.isNothing()) {
            return fn0.get();
        }
        else
        {
            return fn1.apply(this.value());
        }
    }

    @Override
    public <RETURN_TYPE, EXCEPTION_TYPE extends Throwable> MaybeSpecification<RETURN_TYPE> map(Fn1<VALUE_TYPE, RETURN_TYPE, EXCEPTION_TYPE> fn) throws EXCEPTION_TYPE { ;
        if (this.isNothing())
        {
            return new Maybe<RETURN_TYPE>();
        }
        return new Maybe<RETURN_TYPE>(fn.apply(this.value()));
    }

    @Override
    public <EXCEPTION_TYPE extends Throwable> VALUE_TYPE orElseGet(Fn0<VALUE_TYPE, EXCEPTION_TYPE> fnOther) throws EXCEPTION_TYPE {
        return this.isJust() ? this.value() : fnOther.get();
    }

    @Override
    public VALUE_TYPE orElse(VALUE_TYPE other) {
        return this.isJust() ? this.value() : other;
    }

    @Override
    public boolean isNothing() {
        return !this.just;
    }

    @Override
    public boolean isJust() {
        return !this.isNothing();
    }

    @Override
    public VALUE_TYPE value() throws NullPointerException {
        return this.value;
    }


    static public
    Maybe<Integer> maybe(Integer value) {
        return  new Maybe<Integer>(value);
    }

    static public
    Maybe<Integer> just (Integer value) throws NullPointerException {
        if (value == null) {
            throw new NullPointerException();
        }
        return new Maybe<Integer>(value);
    }

    static public
    Maybe<Integer> nothing() {
        return new Maybe<Integer>();
    }
}
