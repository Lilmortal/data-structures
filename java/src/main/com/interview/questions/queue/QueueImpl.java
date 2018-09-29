package com.interview.questions.queue;

import java.util.Objects;

// Implemention of the circular queue
public class QueueImpl<T> implements Queue<T> {
    private int maxSize;
    private int head;
    private int tail;
    private int currentSize;
    private T[] queue;
    private StringBuilder queueUi;

    public QueueImpl() {
        maxSize = 5;
        head = -1;
        tail = -1;
        currentSize = 0;
        queue = (T[]) new Object[maxSize];
        queueUi = new StringBuilder(maxSize);
    }

    @Override
    public synchronized T remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }

        tail = (tail + 1) % maxSize;
        currentSize--;

        if (!Objects.isNull(queue[tail])) {
            updateQueueUiMessage("remove", queue[tail].toString());
        }
        return queue[tail];
    }

    @Override
    public void add(T obj) {
        if (isFull()) {
            System.out.println("Queue is full.");
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
