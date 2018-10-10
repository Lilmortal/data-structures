package com.data.structures.stack;

import com.data.structures.InvalidInputException;
import com.data.structures.linkedList.LinkedList;
import com.data.structures.linkedList.LinkedListImpl;
import com.data.structures.linkedList.LinkedListNode;

public class StackLinkedListImpl<T> implements Stack<T> {
    private LinkedList<T> list;
    private StringBuilder stackUi;

    public StackLinkedListImpl() {
        this.list = new LinkedListImpl();
        stackUi = new StringBuilder();
    }

    @Override
    public T pop() throws InvalidInputException {
        if (this.list.size() == 0) {
            throw new InvalidInputException("Nothing left to pop in linked list stack");
        }

        T lastValue = (T) this.list.getLastNode().getValue();
        this.list.remove(lastValue);

        updateStackUiMessage("pop", lastValue.toString());
        return lastValue;
    }

    @Override
    public void push(T obj) {
        updateStackUiMessage("push", obj.toString());

        this.list.add(obj);
    }

    @Override
    public T peek(int pos) {
        LinkedListNode currentLinkedListNode = this.list.getFirstNode();
        for (int i = 0; i < pos; i++) {
            currentLinkedListNode = currentLinkedListNode.getNext();
        }
        return (T) currentLinkedListNode.getValue();
    }

    @Override
    public String getStackUi() {
        return stackUi.toString();
    }

    @Override
    public boolean isEmpty() {
        return this.list.size() <= 0;
    }

    private void updateStackUiMessage(String msg, String obj) {
        switch (msg) {
            case "pop":
                popStackUiMessage(obj);
                break;
            case "push":
                pushStackUiMessage(obj);
                break;
        }
    }

    private void popStackUiMessage(String obj) {
        int objIndex = Math.abs(stackUi.indexOf(obj) - (isEmpty() ? 2 : 6));

        stackUi.replace(objIndex, objIndex + obj.length() + (isEmpty() ? 4 : 8), "");
    }

    private void pushStackUiMessage(String obj) {
        if (!isEmpty()) {
            stackUi.append(" -> ");
        }

        stackUi.append("( " + obj + " )");
    }
}
