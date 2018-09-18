package com.interview.questions.linkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedListImpl<>();

        list.add(1);
        list.add(2);

        list.getSize();

        list.remove(2);

        System.out.println(list.getSize() + " " + list.contains(2));

        list.add(3);

        System.out.println(list.getSize() + " " + list.contains(2));
    }
}
