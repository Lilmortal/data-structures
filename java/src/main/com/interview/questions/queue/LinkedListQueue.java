package com.interview.questions.queue;

import com.interview.questions.linkedList.LinkedList;
import com.interview.questions.linkedList.LinkedListImpl;
import com.interview.questions.linkedList.Node;

public class LinkedListQueue<T> implements Queue<T> {
    private LinkedList<T> list;

    public LinkedListQueue() {
        list = new LinkedListImpl<>();
    }


    @Override
    public T remove() {
        Node firstNode = this.list.getFirstNode();
        this.list.remove((T) firstNode.getValue());
        return (T) firstNode.getValue();
    }

    @Override
    public void add(T obj) {
        this.list.add(obj);
    }

    @Override
    public boolean isEmpty() {
        return this.list.getSize() == 0;
    }

    @Override
    public T peek(int pos) {
        Node currentNode = this.list.getFirstNode();
        for (int i = 0; i < pos; i++) {
            currentNode = currentNode.getNext();
        }
        return (T) currentNode.getValue();
    }
}
