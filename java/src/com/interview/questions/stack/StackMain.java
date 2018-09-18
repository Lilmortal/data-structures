package com.interview.questions.stack;

public class StackMain {
    public static void main(String[] args) {
        System.out.println("STACK");
        testStack();
        System.out.println("LINKED LIST");
        testLinkedListStack();

    }

    private static void testStack() {
        Stack<Integer> stack = new StackImpl();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek(1));
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static void testLinkedListStack() {
        Stack<Integer> stack = new LinkedListStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek(1));
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
