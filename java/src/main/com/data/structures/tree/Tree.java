package com.data.structures.tree;

import com.data.structures.InvalidInputException;

public interface Tree {
    void insert(Double value) throws InvalidInputException;

    Double remove(Double value) throws InvalidInputException;

    Double first();

    Double last();

    int size();

    boolean isEmpty();

    String getName();
}
