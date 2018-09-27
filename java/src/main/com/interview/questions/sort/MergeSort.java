package com.interview.questions.sort;

public class MergeSort implements Sort {
    @Override
    public Double[] sort(Double[] list) {
        int half = list.length / 2;

        mergeSort(0, half);
        mergeSort(half + 1, list.length);

        return list;
    }

    @Override
    public String getName() {
        return "Merge sort";
    }

    private void mergeSort(int start, int end) {
        if (start > end) {
            merge(start, end);
        }

        int half = end - start;

        mergeSort(start, half);
        mergeSort(half + 1, end);
    }

    private void merge(int start, int end) {
        if (start < end) {

        }
    }
}
