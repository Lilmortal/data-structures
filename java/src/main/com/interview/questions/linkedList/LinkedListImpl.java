package com.interview.questions.linkedList;

import java.util.*;
import java.util.function.Predicate;

public class LinkedListImpl<T extends Object> implements LinkedList<T> {
    private LinkedListNode head;
    private LinkedListNode tail;
    private int size;
    private List<String> linkedListUi = new ArrayList<>();

    public LinkedListImpl() {
        size = 0;
    }

    public LinkedListImpl(T value) {
        if (!Objects.isNull(value)) {
            LinkedListNode linkedListNode = new LinkedListNode(value);
            this.head = linkedListNode;
            this.tail = linkedListNode;
            size = 1;
        } else {
            size = 0;
        }
    }

    @Override
    public List<T> getAllValues() {
        return null;
    }

    @Override
    public boolean add(T value) {
        LinkedListNode linkedListNode = new LinkedListNode(value);
        if (Objects.isNull(this.head)) {
            this.head = linkedListNode;
            this.tail = linkedListNode;
        } else {
            linkedListNode.setPrevious(this.tail);
            this.tail.setNext(linkedListNode);
            this.tail = linkedListNode;
        }

        linkedListUi.add(value.toString());
        size++;
        return true;
    }

    @Override
    public void add(T value, int pos) {
        LinkedListNode linkedListNode = new LinkedListNode(value);
        if (Objects.isNull(this.head)) {
            this.head = linkedListNode;
            this.tail = linkedListNode;
        } else {
            if (pos > getSize()) {
                System.out.println("-- Position " + pos + " is greater than current size which is " + getSize() + " --");
                return;
            }

            if (pos == getSize() - 1) {
                this.tail = linkedListNode;
            }

            LinkedListNode currentLinkedListNode = this.head;
            for (int i = 0; i < pos; i++) {
                currentLinkedListNode = currentLinkedListNode.getNext();
            }

            linkedListNode.setPrevious(currentLinkedListNode.getPrevious());
            linkedListNode.setNext(currentLinkedListNode);
            currentLinkedListNode.getPrevious().setNext(linkedListNode);
            currentLinkedListNode.setPrevious(linkedListNode);

            linkedListUi.add(pos, value.toString());
            size++;
        }
    }

    @Override
    public boolean remove(Object value) {
        LinkedListNode currentLinkedListNode = this.head;
        while(!Objects.isNull(currentLinkedListNode)) {
            if (currentLinkedListNode.getValue().equals(value)) {
                removeNode(currentLinkedListNode);

                linkedListUi.remove(value.toString());
                return true;
            }

            currentLinkedListNode = currentLinkedListNode.getNext();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void remove(int pos) {
        LinkedListNode currentLinkedListNode = this.head;

        for (int i = 0; i < pos; i++) {
            currentLinkedListNode = currentLinkedListNode.getNext();
        }
        removeNode(currentLinkedListNode);
        linkedListUi.remove(pos);
    }

    @Override
    public void clear() {
        LinkedListNode currentLinkedListNode = this.head;
        currentLinkedListNode.setPrevious(null);
        currentLinkedListNode.setNext(null);
        currentLinkedListNode.setValue(null);
    }

    @Override
    public T get(int pos) {
        LinkedListNode currentLinkedListNode = this.head;
        for (int i = 0; i < pos; i++) {
            currentLinkedListNode = currentLinkedListNode.getNext();
        }
        return (T) currentLinkedListNode.getValue();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object value) {
        LinkedListNode currentLinkedListNode = this.head;
        while(!Objects.isNull(currentLinkedListNode)) {
            if (currentLinkedListNode.getValue().equals(value)) {
                return true;
            }
            currentLinkedListNode = currentLinkedListNode.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public LinkedListNode getFirstNode() {
        return this.head;
    }

    @Override
    public LinkedListNode getLastNode() {
        return this.tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getLinkedListUi() {
        return linkedListUi.toString();
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

    private void removeNode(LinkedListNode linkedListNode) {
        LinkedListNode previousLinkedListNode = linkedListNode.getPrevious();
        LinkedListNode nextLinkedListNode = linkedListNode.getNext();

        if (!Objects.isNull(previousLinkedListNode)) {
            previousLinkedListNode.setNext(nextLinkedListNode);
        }

        if (linkedListNode.equals(this.head)) {
            this.head = nextLinkedListNode;
        }

        if (this.tail.equals(linkedListNode)) {
            this.tail = previousLinkedListNode;
        }
        size--;
    }
}
