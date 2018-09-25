package com.interview.questions.linkedList;

import java.util.Objects;

public class LinkedListImpl<T> implements LinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    public LinkedListImpl() {
        size = 0;
    }

    public LinkedListImpl(T value) {
        if (value != null) {
            Node node = new Node(value);
            this.head = node;
            this.tail = node;
            size = 1;
        } else {
            size = 0;
        }
    }


    @Override
    public void add(T value) {
        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.setPrevious(this.tail);
            this.tail.setNext(node);
            this.tail = node;
        }

        size++;
    }

    @Override
    public void add(T value, int pos) {
        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            if (pos > getSize()) {
                System.out.println("Position " + pos + " is greater than current size which is " + getSize());
                return;
            }

            if (pos == getSize() - 1) {
                this.tail = node;
            }

            Node currentNode = this.head;
            for (int i = 0; i < pos; i++) {
                currentNode = currentNode.getNext();
            }

            node.setPrevious(currentNode.getPrevious());
            node.setNext(currentNode);
            currentNode.getPrevious().setNext(node);
            currentNode.setPrevious(node);

            size++;
        }
    }

    @Override
    public void remove(T value) {
        Node currentNode = this.head;
        while(currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                Node previousNode = currentNode.getPrevious();
                Node nextNode = currentNode.getNext();

                if (previousNode != null) {
                    previousNode.setNext(nextNode);
                }

                if (currentNode.equals(this.head)) {
                    this.head = nextNode;
                }

                if (this.tail.equals(currentNode)) {
                    this.tail = previousNode;
                }
                size--;
                break;
            }

            currentNode = currentNode.getNext();
        }
    }

    @Override
    public boolean contains(T value) {
        Node currentNode = this.head;
        while(currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public Node getFirstNode() {
        return this.head;
    }

    @Override
    public Node getLastNode() {
        return this.tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedListImpl)) return false;
        LinkedListImpl<?> that = (LinkedListImpl<?>) o;
        return getSize() == that.getSize() &&
                Objects.equals(head, that.head) &&
                Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {

        return Objects.hash(head, tail, getSize());
    }
}
