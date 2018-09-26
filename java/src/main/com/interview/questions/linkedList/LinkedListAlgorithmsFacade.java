package com.interview.questions.linkedList;

import com.interview.questions.algorithms.AlgorithmsFacade;

import java.io.BufferedReader;

public class LinkedListAlgorithmsFacade extends AlgorithmsFacade {
    @Override
    public void run(BufferedReader br) {
        LinkedList<Integer> list = new LinkedListImpl<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.add(4, 1);

        System.out.println(list.toString());
    }
}
