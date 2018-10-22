package com.data.structures.linkedList;

import com.data.structures.InvalidInputException;

import java.util.*;

public class LinkedListImpl<T extends Object> implements LinkedList<T> {
    private LinkedListNode head;
    private LinkedListNode tail;
    private int size;
    private List<String> linkedListUi = new ArrayList<>();

    public LinkedListImpl() {
        size = 0;
    }

    public LinkedListImpl(T value) {
        if (Objects.nonNull(value)) {
            LinkedListNode linkedListNode = new LinkedListNode(value);
            this.head = linkedListNode;
            this.tail = linkedListNode;
            size = 1;
        } else {
            size = 0;
        }
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
    public void add(T value, int pos) throws InvalidInputException {
        LinkedListNode linkedListNode = new LinkedListNode(value);
        if (Objects.isNull(this.head)) {
            this.head = linkedListNode;
            this.tail = linkedListNode;
        } else {
            if (pos > size()) {
                throw new InvalidInputException("Position " + pos + " is greater than current size which is " + size());
            }

            if (pos == size() - 1) {
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
        while(Objects.nonNull(currentLinkedListNode)) {
            if (currentLinkedListNode.getValue().equals(value)) {
                removeNode(currentLinkedListNode);

                linkedListUi.remove(value.toString());
                return true;
            }

            currentLinkedListNode = currentLinkedListNode.getNext();
        }
        return false;
    }

    // TODO: implement
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    // TODO: implement
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    // TODO: implement
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    // TODO: implement
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
            if (Objects.isNull(currentLinkedListNode)) {
                return null;
            }
        }
        return (T) currentLinkedListNode.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public boolean contains(Object value) {
        LinkedListNode currentLinkedListNode = this.head;
        while(Objects.nonNull(currentLinkedListNode)) {
            if (currentLinkedListNode.getValue().equals(value)) {
                return true;
            }
            currentLinkedListNode = currentLinkedListNode.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        LinkedListNode ss = this.head;
        return new Iterator<T>() {
            private LinkedListNode currentNode = ss;

            @Override
            public boolean hasNext() {
                return currentNode != null ? currentNode.getValue() != null || currentNode.hasNext() : false;
            }

            @Override
            public T next() {
                T value = (T) (currentNode.getValue());
                currentNode = currentNode.getNext();
                return value;
            }
        };
    }

    // TODO: implement
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    // TODO: implement
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
    public String getLinkedListUi() {
        return linkedListUi.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedListImpl<?> that = (LinkedListImpl<?>) o;

        if (size != that.size) return false;
        if (head != null ? !head.equals(that.head) : that.head != null) return false;
        if (tail != null ? !tail.equals(that.tail) : that.tail != null) return false;
        return linkedListUi != null ? linkedListUi.equals(that.linkedListUi) : that.linkedListUi == null;
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + (tail != null ? tail.hashCode() : 0);
        result = 31 * result + size;
        result = 31 * result + (linkedListUi != null ? linkedListUi.hashCode() : 0);
        return result;
    }

    private void removeNode(LinkedListNode linkedListNode) {
        LinkedListNode previousLinkedListNode = linkedListNode.getPrevious();
        LinkedListNode nextLinkedListNode = linkedListNode.getNext();

        if (Objects.nonNull(previousLinkedListNode)) {
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
