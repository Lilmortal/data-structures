package com.data.structures.heap;

import com.data.structures.InvalidInputException;

public interface Heap {
    void insert(Double value) throws InvalidInputException;

    // only remove the root
    Double remove() throws InvalidInputException;

    Double first();

    Double last();

    int size();

    boolean isEmpty();

    String getName();
}
