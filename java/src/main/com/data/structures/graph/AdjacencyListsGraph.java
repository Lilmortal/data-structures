package com.data.structures.graph;

import com.data.structures.InvalidInputException;
import com.data.structures.linkedList.LinkedList;
import com.data.structures.linkedList.LinkedListImpl;
import com.data.structures.linkedList.LinkedListNode;
import com.data.structures.queue.Queue;
import com.data.structures.queue.QueueImpl;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListsGraph implements Graph<Integer> {
    private int capacity = 10;

    private LinkedList<Integer>[] linkedList = new LinkedList[capacity];

    @Override
    public boolean contains(Integer item) {
        return false;
    }

    @Override
    public void addVertex(Integer vertex) {
        if (vertex >= capacity) {
            capacity = vertex + 1;
            resizeLinkedList(capacity);
        }

        if (linkedList[vertex] == null) {
            linkedList[vertex] = new LinkedListImpl<>();
        }
    }

    @Override
    public void removeVertex(Integer vertex) {
        linkedList[vertex] = null;
    }

    @Override
    public void addEdge(Integer from, Integer to, Integer weight) {
        if (from > capacity || linkedList[from] == null) {
            addVertex(from);
        }

        linkedList[from].add(to);
    }

    @Override
    public void removeEdge(Integer from, Integer to) {
        while (linkedList[from].get(to) != null) {
            linkedList[from].remove(to);
        }
    }

    @Override
    public void depthFirstSearch(Integer start) {
        List<Integer> visitedVertices = new ArrayList<>();

        depthFirstSearch(start, visitedVertices);
    }

    @Override
    public void breadthFirstSearch(Integer start) throws InvalidInputException {
        Queue<Integer> queue = new QueueImpl<>(capacity);
        List<Integer> visitedVertices = new ArrayList<>();

        if (linkedList[start] == null) {
            return;
        }

        queue.add(start);

        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            System.out.println(vertex);

            if (linkedList[vertex] != null) {
                LinkedListNode currentNode = linkedList[vertex].getFirstNode();
                if (!visitedVertices.contains(currentNode.getValue())) {
                    queue.add((Integer) currentNode.getValue());
                    visitedVertices.add((Integer) currentNode.getValue());
                }

                while (currentNode.hasNext()) {
                    currentNode = currentNode.getNext();
                    if (!visitedVertices.contains(currentNode.getValue())) {
                        queue.add((Integer) currentNode.getValue());
                        visitedVertices.add((Integer) currentNode.getValue());
                    }
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Adjacency Lists";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < linkedList.length; i++) {
            if (linkedList[i] == null) {
                continue;
            }

            sb.append(i + " -> ");
            LinkedListNode currentNode = linkedList[i].getFirstNode();
            sb.append("[ " + currentNode.getValue() + " ] ");

            while (currentNode.hasNext()) {
                currentNode = currentNode.getNext();
                sb.append("[ " + currentNode.getValue() + " ] ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void resizeLinkedList(Integer vertex) {
        LinkedList<Integer>[] temp = this.linkedList;

        this.linkedList = new LinkedListImpl[vertex];
        for (int i = 0; i < temp.length; i++) {
            this.linkedList[i] = temp[i];
        }
    }

    private void depthFirstSearch(Integer start, List<Integer> visitedVertices) {
        // TODO: Visited vertices stopping this
        if (linkedList[start] == null || visitedVertices.contains(start)) {
            return;
        }

        LinkedListNode currentNode = linkedList[start].getFirstNode();
        Integer currentValue = (Integer) currentNode.getValue();
        System.out.println(currentValue);
        depthFirstSearch(currentValue, visitedVertices);
        visitedVertices.add(currentValue);

        if (currentNode.hasNext()) {
            currentNode = currentNode.getNext();
            currentValue = (Integer) currentNode.getValue();
            System.out.println(currentValue);
            depthFirstSearch(currentValue, visitedVertices);
            visitedVertices.add(currentValue);
        }
    }
}
