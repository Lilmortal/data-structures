package com.data.structures.queue;

import com.data.structures.InvalidInputException;

import java.util.Objects;

// Implemention of the circular queue
public class QueueImpl<T> implements Queue<T> {
    private int maxSize;
    private int head;
    private int tail;
    private int currentSize;
    private T[] queue;
    private StringBuilder queueUi;

    public QueueImpl(int maxSize) {
        this.maxSize = maxSize;
        head = -1;
        tail = -1;
        currentSize = 0;
        queue = (T[]) new Object[maxSize];
        queueUi = new StringBuilder(maxSize);
    }

    @Override
    public synchronized T remove() throws InvalidInputException {
        if (isEmpty()) {
            throw new InvalidInputException("Queue is empty");
        }

        tail = (tail + 1) % maxSize;
        currentSize--;

        if (Objects.nonNull(queue[tail])) {
            updateQueueUiMessage("remove", queue[tail].toString());
        }
        return queue[tail];
    }

    @Override
    public void add(T obj) throws InvalidInputException {
        if (isFull()) {
            throw new InvalidInputException("Queue is full");
        }

        updateQueueUiMessage("add", obj.toString());
        head = (head + 1) % maxSize;
        currentSize++;
        queue[head] = obj;
    }

    @Override
    public synchronized boolean isEmpty() {
        return currentSize <= 0;
    }

    @Override
    public synchronized T peek(int pos) {
        return queue[pos];
    }

    @Override
    public synchronized String getQueueUi() {
        return queueUi.toString();}

    private boolean isFull() {
        return currentSize >= maxSize;
    }

    private void updateQueueUiMessage(String msg, String obj) {
        switch (msg) {
            case "remove":
                removeQueueUiMessage(obj);
                break;
            case "add":
                addQueueUiMessage(obj);
                break;
        }
    }

    private void addQueueUiMessage(String obj) {
        if (isEmpty()) {
            queueUi.append("|");
        }

        queueUi.insert(0, "| " + obj + " ");
    }

    private void removeQueueUiMessage(String obj) {
        int objIndex = Math.abs(queueUi.indexOf(obj) - (isEmpty() ? 2 : 1));

        queueUi.replace(objIndex, objIndex + obj.length() + (isEmpty() ? 4 : 3), "");
    }
}
