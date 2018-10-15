package com.data.structures.graph;

import java.util.Collection;

public class AdjacencyListsGraph<T> implements Graph<T> {
    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public void addVertex(T vertex) {

    }

    @Override
    public boolean areAdjacent(T a, T b) {
        return false;
    }

    @Override
    public void removeVertex(T vertex) {

    }

    @Override
    public void addEdge(T from, T to, int weight) {

    }

    @Override
    public void removeEdge(T from, T to) {

    }

    @Override
    public Collection<T> getNeighboursForT(T vertex) {
        return null;
    }

    @Override
    public void depthSearch(T start) {

    }

    @Override
    public void breathSearch(T start) {

    }

    @Override
    public String getName() {
        return null;
    }
}
