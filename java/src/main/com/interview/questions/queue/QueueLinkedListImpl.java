package com.interview.questions.queue;

import com.interview.questions.InvalidInputException;
import com.interview.questions.linkedList.LinkedList;
import com.interview.questions.linkedList.LinkedListImpl;
import com.interview.questions.linkedList.LinkedListNode;

import java.util.Objects;

public class QueueLinkedListImpl<T> implements Queue<T> {
    private LinkedList<T> list;
    private StringBuilder queueUi;

    public QueueLinkedListImpl() {
        list = new LinkedListImpl<>();
        queueUi = new StringBuilder();
    }

    @Override
    public T remove() throws InvalidInputException {
        if (Objects.isNull(this.list.getFirstNode())) {
            throw new InvalidInputException("Linked list queue is empty");
        }

        T firstNodeValue = (T) this.list.getFirstNode().getValue();
        this.list.remove(firstNodeValue);

        String obj = firstNodeValue.toString();
        updateQueueUiMessage("remove", obj);
        return firstNodeValue;
    }

    @Override
    public void add(T obj) {
        updateQueueUiMessage("add", obj.toString());
        this.list.add(obj);
    }

    @Override
    public boolean isEmpty() {
        return this.list.size() <= 0;
    }

    @Override
    public String getQueueUi() {
        return queueUi.toString();
    }

    @Override
    public T peek(int pos) {
        LinkedListNode currentLinkedListNode = this.list.getFirstNode();
        for (int i = 0; i < pos; i++) {
            currentLinkedListNode = currentLinkedListNode.getNext();
        }
        return (T) currentLinkedListNode.getValue();
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
        if (!isEmpty()) {
            queueUi.insert(0," -> ");
        }

        queueUi.insert(0, "( " + obj.toString() + " )");


    }

    private void removeQueueUiMessage(String obj) {
        int objIndex = Math.abs(queueUi.indexOf(obj) - (isEmpty() ? 2 : 6));

        queueUi.replace(objIndex, objIndex + obj.length() + (isEmpty() ? 4 : 8), "");
    }
}
