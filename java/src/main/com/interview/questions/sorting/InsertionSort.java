package com.interview.questions.sorting;

public class InsertionSort implements Sort {
    private int[] list;

    public InsertionSort(int[] list) {
        this.list = list;
    }

    @Override
    public int[] sort() {
        return list;
    }
}
