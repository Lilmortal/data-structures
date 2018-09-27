package com.interview.questions.linkedList;

import com.interview.questions.ExitException;
import com.interview.questions.algorithm.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;

public class LinkedListAlgorithm extends Algorithm {
    private static final String ADD = "a";

    private static final String REMOVE = "r";

    private static final char SPACE = ' ';

    private LinkedList linkedList = new LinkedListImpl();

    @Override
    protected void printInstructions() {
        System.out.println("Press 'a' followed by a space and a string to add that to the linked list.");
        System.out.println("Press 'a' followed by a number, then a space and a string to add that to the linked list in that position.");
        System.out.println("Press 'r' followed by a space and a string to remove that string from the linked list.");
        System.out.println("Press 'r' followed by a number to remove the item from that position.");
    }

    @Override
    public void execute(String input, BufferedReader br) throws ExitException, IOException {
        if (String.valueOf(input.charAt(0)).equals(ADD)) {
            if (input.length() <= 2) {
                System.out.println("-- Press enter a string or position to add into the linked list. --");
                return;
            }

            if (input.indexOf(SPACE) == -1) {
                System.out.println("-- Please enter a space. --");
                return;
            }

            String position = input.substring(1, input.indexOf(SPACE));
            String obj = input.substring(input.indexOf(SPACE) + 1);

            try {
                int positionNum = Integer.parseInt(position);
                linkedList.add(obj, positionNum);
            } catch (NumberFormatException | NullPointerException e) {
                if (obj.length() == 0) {
                    System.out.println("-- Please enter a string that you want added to the linked list. --");
                } else {
                    linkedList.add(obj);
                }
            }
        } else if (String.valueOf(input.charAt(0)).equals(REMOVE)) {
            if (input.length() < 2) {
                System.out.println("-- Press enter an position or a string that will be removed from the linked list. --");
                return;
            }

            String position = input.substring(1);
            String obj = input.substring(input.indexOf(SPACE) + 1);

            try {
                int positionNum = Integer.parseInt(position);

                if (positionNum > linkedList.getSize()) {
                    System.out.println("-- The position number you entered is larger than the size of the list. --");
                } else {
                    linkedList.remove(positionNum);
                }
            } catch (NumberFormatException | NullPointerException e) {
                if (input.indexOf(SPACE) == -1) {
                    System.out.println("-- Please enter a space.");
                } else if (obj.length() == 0) {
                    System.out.println("-- Please enter a string that you want removed from the linked list. --");
                } else {
                    linkedList.remove(obj);
                }
            }
        } else {
            System.out.println();
            System.out.println("-- Please enter a valid input. --");
        }

        System.out.println();
        System.out.println("Linked List:");
        System.out.println(linkedList.getLinkedListUi());
        System.out.println();
    }
}