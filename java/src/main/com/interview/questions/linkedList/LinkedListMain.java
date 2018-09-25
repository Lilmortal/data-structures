package com.interview.questions.linkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedListImpl<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.add(4, 1);

        System.out.println(list.toString());
    }
}
