package com.interview.questions.sorting;

public class MergeSort implements Sort {
    private int[] list;

    public MergeSort(int[] list) {
        this.list = list;
    }

    @Override
    public int[] sort() {
        return list;
    }
}
