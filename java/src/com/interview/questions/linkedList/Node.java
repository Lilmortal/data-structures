package com.interview.questions.linkedList;

import java.util.Objects;

public class Node<T> {
    private Node previous;

    private Node next;

    private T value;

    public Node(T value) {
        this.value = value;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(getPrevious(), node.getPrevious()) &&
                Objects.equals(getNext(), node.getNext()) &&
                Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPrevious(), getNext(), value);
    }
}
