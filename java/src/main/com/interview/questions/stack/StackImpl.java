package com.interview.questions.stack;

public class StackImpl<T> implements Stack<T> {
    // Resize capacity by this number if full
    private static final int CAPACITY_RESIZER = 2;

    private int capacity;
    private int head;
    private T[] stack;


    public StackImpl() {
        capacity = 1;
        head = -1;
        stack = (T[])new Object[capacity];
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NullPointerException();
        }

        return stack[head--];
    }

    @Override
    public void push(T obj) {
        head++;

        doubleCapacityIfFull();

        stack[head] = obj;
    }


    @Override
    public T peek(int pos) {
        return stack[pos];
    }

    @Override
    public boolean isEmpty() {
        return head < 0;
    }

    private void doubleCapacityIfFull() {
        if (head >= capacity) {
            capacity *= CAPACITY_RESIZER;
            T[] tempStack = stack;
            stack = (T[])new Object[capacity];
            for (int i = 0; i < tempStack.length; i++) {
                stack[i] = tempStack[i];
            }
        }
    }
}




