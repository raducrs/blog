package com.apptozee.blogpages.services.discovery;

public class Tuple2<Key,Value> {
    private final Key k;
    private final Value v;

    public Tuple2(Key k, Value v) {
        this.k = k;
        this.v = v;
    }

    public Key getKey() {
        return k;
    }

    public Value getValue() {
        return v;
    }
}
