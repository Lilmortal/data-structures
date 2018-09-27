package com.interview.questions.sorting;

public class InsertionSort implements Sort {
    @Override
    public Double[] sort(Double[] list) {
        Double[] sortedList = list;

        for (int i = 0; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (sortedList[j] < sortedList[j - 1]) {
                    Double temp = sortedList[j - 1];
                    sortedList[j - 1] = sortedList[j];
                    sortedList[j] = temp;
                }
            }
        }

        return sortedList;
    }

    @Override
    public String getName() {
        return "Insertion sort";
    }
}
