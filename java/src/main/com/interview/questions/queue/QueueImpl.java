package com.interview.questions.queue;

// Implemention of the circular queue
public class QueueImpl<T> implements Queue<T> {
    private int maxSize;
    private int head;
    private int tail;
    private int currentSize;
    private T[] queue;

    public QueueImpl() {
        maxSize = 5;
        head = -1;
        tail = -1;
        currentSize = 0;
        queue = (T[]) new Object[maxSize];
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NullPointerException();
        }

        tail = (tail + 1) % maxSize;
        currentSize--;

        return queue[tail];
    }

    @Override
    public void add(T obj) {
        if (isFull()) {
            throw new RuntimeException("Queue is full.");
        }

        head = (head + 1) % maxSize;
        currentSize++;
        queue[head] = obj;
    }

    @Override
    public boolean isEmpty() {
        return head < 0;
    }

    @Override
    public T peek(int pos) {
        return queue[pos];
    }

    private boolean isFull() {
        return currentSize >= maxSize;
    }
}
