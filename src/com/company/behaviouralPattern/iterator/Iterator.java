package com.company.behaviouralPattern.iterator;

public interface Iterator<T> {
    boolean hasNext();
    T current();
    void next();
}
