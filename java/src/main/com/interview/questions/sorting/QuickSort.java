package com.interview.questions.sorting;

public class QuickSort implements Sort {
    private int[] list;

    public QuickSort(int[] list) {
        this.list = list;
    }

    @Override
    public int[] sort() {
        return list;
    }
}
