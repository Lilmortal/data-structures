package com.interview.questions.stack;

import com.interview.questions.linkedList.LinkedList;
import com.interview.questions.linkedList.LinkedListImpl;
import com.interview.questions.linkedList.Node;

public class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> list;

    public LinkedListStack() {
        this.list = new LinkedListImpl();
    }

    @Override
    public T pop() {
        T lastValue = (T) this.list.getLastNode().getValue();
        this.list.remove(lastValue);
        return lastValue;
    }

    @Override
    public void push(T obj) {
        this.list.add(obj);
    }

    @Override
    public T peek(int pos) {
        Node currentNode = this.list.getFirstNode();
        for (int i = 0; i < pos; i++) {
            currentNode = currentNode.getNext();
        }
        return (T) currentNode.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.list.getSize() == 0;
    }
}
