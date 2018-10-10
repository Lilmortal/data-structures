package com.data.structures.linkedList;

import java.util.Objects;

public class LinkedListNode<T> {
    private LinkedListNode previous;

    private LinkedListNode next;

    private T value;

    public LinkedListNode(T value) {
        this.value = value;
    }

    public LinkedListNode getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedListNode previous) {
        this.previous = previous;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public boolean hasNext() {
        return Objects.nonNull(next);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


}
