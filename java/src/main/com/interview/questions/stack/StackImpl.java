package com.interview.questions.stack;

import com.interview.questions.InvalidInputException;

public class StackImpl<T> implements Stack<T> {
    // Resize capacity by this number if full
    private static final int CAPACITY_RESIZE = 2;

    private int capacity;
    private int head;
    private T[] stack;
    private StringBuilder stackUi;

    public StackImpl() {
        capacity = 1;
        head = -1;
        stack = (T[])new Object[capacity];
        stackUi = new StringBuilder(capacity);
    }

    @Override
    public synchronized T pop() throws InvalidInputException {
        if (isEmpty()) {
            throw new InvalidInputException("Nothing left to pop");
        }

        String obj = stack[head].toString();
        updateStackUiMessage("pop", obj);
        return stack[head--];
    }

    @Override
    public void push(T obj) {
        updateStackUiMessage("push", obj.toString());
        head++;
        doubleCapacityIfFull();
        stack[head] = obj;
    }


    @Override
    public synchronized T peek(int pos) {
        return stack[pos];
    }

    @Override
    public synchronized String getStackUi() {
        return stackUi.toString();
    }

    @Override
    public synchronized boolean isEmpty() {
        return head < 0;
    }

    private void doubleCapacityIfFull() {
        if (head >= capacity) {
            capacity *= CAPACITY_RESIZE;
            T[] tempStack = stack;
            stack = (T[])new Object[capacity];
            for (int i = 0; i < tempStack.length; i++) {
                stack[i] = tempStack[i];
            }
        }
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

    private void pushStackUiMessage(String obj) {
        if (isEmpty()) {
            stackUi.append("|");
        }

        stackUi.append(" " + obj + " |");
    }

    private void popStackUiMessage(String obj) {
        int objIndex = Math.abs(stackUi.indexOf(obj) - (head <= 0 ? 2 : 1));
        stackUi.replace(objIndex, objIndex + obj.length() + (head <= 0 ? 4 : 3), "");
    }


}




