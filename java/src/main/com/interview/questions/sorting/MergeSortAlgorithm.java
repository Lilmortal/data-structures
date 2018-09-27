package com.interview.questions.sorting;

public class MergeSortAlgorithm implements SortAlgorithm {
    @Override
    public Double[] sort(Double[] list) {
        int half = list.length / 2;

//        sort(0, half);
//        sort(half + 1, list.length);
        return list;
    }

    @Override
    public String getName() {
        return "Merge sort";
    }


}
