package com.data.structures.graph;

import java.util.Collection;

public class AdjacencyMatrixGraph<T> implements Graph<T> {
    private int[][] matrix = new int[10][10];

    @Override
    public boolean contains(T item) {
        // 
        return false;
    }

    @Override
    public void addVertex(T vertex) {
        // add vertex at end of matrix for both column and row
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
