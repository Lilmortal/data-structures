package com.interview.questions.sorting;

public class SortAlgorithmFactory {
    public SortAlgorithm getSort(String sort) {
        switch (sort) {
            case "insertion": {
                return new InsertionSortAlgorithm();
            }
            case "merge": {
                return new MergeSortAlgorithm();
            }
            case "quick": {
                return new QuickSortAlgorithm();
            }
        }
        return null;
    }
}
