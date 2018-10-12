package com.data.structures.graph;

import java.util.Collection;

public interface Graph<T> {
    boolean contains(T item);

    void addVertex(T vertex);

    boolean areAdjacent(T a, T b);

    void removeVertex(T vertex);

    void addEdge(T from, T to, int weight);

    void removeEdge(T from, T to);

    Collection<T> getNeighboursForT(T vertex);

    void depthSearch(T start);

    void breathSearch(T start);
    
    String getName();
}
