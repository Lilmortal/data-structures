package com.data.structures.sort;

public class SortFactory {
    public Sort getSort(String sort) {
        switch (sort) {
            case "insertion": {
                return new InsertionSort();
            }
            case "merge": {
                return new MergeSort();
            }
            case "quick": {
                return new QuickSort();
            }
        }
        return null;
    }
}
