package com.data.structures.graph;

import com.data.structures.InvalidInputException;
import com.data.structures.queue.Queue;
import com.data.structures.queue.QueueImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph<Integer> {
    private int capacity = 10;

    private int[][] matrix = new int[capacity][capacity];

    @Override
    public boolean contains(Integer item) {
        return false;
    }

    @Override
    public void addVertex(Integer vertex) {
        if (vertex >= capacity) {
            this.capacity = vertex + 1;
            resizeMatrix(this.capacity);
        }
        matrix[vertex][vertex] = 0;
    }

    @Override
    public boolean areAdjacent(Integer a, Integer b) {
        if (matrix[a][b] > 0 || matrix[b][a] > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void removeVertex(Integer vertex) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == vertex || j == vertex) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    @Override
    public void addEdge(Integer from, Integer to, Integer weight) {
        if (from >= capacity || to >= capacity) {
            addVertex(from > to ? from : to);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == from && j == to) {
                    matrix[i][j] = weight;
                    return;
                }
            }
        }
    }

    @Override
    public void removeEdge(Integer from, Integer to) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == from && j == to) {
                    matrix[i][j] = 0;
                    return;
                }
            }
        }
    }

    @Override
    public Collection<Integer> getNeighboursForT(Integer vertex) {
        return null;
    }

    @Override
    public void depthFirstSearch(Integer start) {
        List<Integer> visitedVertices = new ArrayList<>();

        depthFirstSearch(start, visitedVertices);
    }

    @Override
    public void breadthFirstSearch(Integer start) throws InvalidInputException {
        Queue<Integer> queue = new QueueImpl<>(matrix.length * matrix[0].length);
        List<Integer> visitedVertices = new ArrayList<>();

        queue.add(start);
        visitedVertices.add(start);

        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            System.out.println(vertex);
            for (int i = 0; i < matrix[vertex].length; i++) {
                if (matrix[vertex][i] > 0 && !visitedVertices.contains(i)) {
                    queue.add(i);
                    visitedVertices.add(i);
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Adjacency matrix";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sb.append("[ " + matrix[i][j] + " ] ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void resizeMatrix(int capacity) {
        int[][] tempMatrix = this.matrix;
        this.matrix = new int[capacity][capacity];

        for (int i = 0; i < tempMatrix.length; i++) {
            for (int j = 0; j < tempMatrix.length; j++) {
                matrix[i][j] = tempMatrix[i][j];
            }
        }
    }

    private void depthFirstSearch(Integer start, List<Integer> visitedVertices) {
        System.out.println(start);
        for (int i = 0; i < matrix[start].length; i++) {
            if (matrix[start][i] > 0 && !visitedVertices.contains(i)) {
                visitedVertices.add(i);
                depthFirstSearch(i, visitedVertices);
            }
        }
    }
}
