package com.company;

public interface Iterator<T> {
    boolean hasNext();
    T current();
    void next();
}
