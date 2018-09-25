package com.interview.questions.sorting;

public class SortFactory {
    public static int[] insertionSort(int[] list) {
        Sort insertionSort = new InsertionSort(list);
        return insertionSort.sort();
    }

    public static int[] mergeSort(int[] list) {
        Sort mergeSort = new MergeSort(list);
        return mergeSort.sort();
    }

    public static int[] quickSort(int[] list) {
        Sort quickSort = new QuickSort(list);
        return quickSort.sort();
    }
}
