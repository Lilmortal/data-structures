package com.data.structures.tree;

import com.data.structures.InvalidInputException;

public interface Tree {
    void insert(Double value) throws InvalidInputException;

    void remove(Double value) throws InvalidInputException;

    Double get(int pos);

    Double first();

    Double last();

    int size();

    boolean isEmpty();

    String getName();
}
