package com.interview.questions.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackMain {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    public static void main(String[] args) {
        Stack<String> stack = new StackImpl<>();
        Stack<String> linkedListStack = new LinkedListStack<>();

        java.util.Stack stackJava = new java.util.Stack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        try {
            System.out.println("Press 'a' followed by a string to add that to the queue.");
            System.out.println("Press 'r' to remove one item from the queue.");

            while (true) {
                input = br.readLine();

                if (!input.isEmpty()) {
                    if (String.valueOf(input.charAt(0)).equals(ADD)) {
                        if (input.length() <= 1) {
                            System.out.println("Press enter a string to add into the stack.");
                            continue;
                        }
                        stack.push(input.substring(1));
                        linkedListStack.push(input.substring(1));

                        System.out.println("Stack:");
                        System.out.println(stack.getStackUi());

                        System.out.println("Linked List Stack:");
                        System.out.println(linkedListStack.getStackUi());
                    }

                    if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
                        stack.pop();
                        linkedListStack.pop();

                        System.out.println("Stack:");
                        System.out.println(stack.getStackUi());

                        System.out.println("Linked List Stack:");
                        System.out.println(linkedListStack.getStackUi());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
