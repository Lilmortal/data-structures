package com.interview.questions.sorting;

import java.util.Arrays;

public class SortResource {
    private SortAlgorithm sortAlgorithm;

    public Integer[] getSortedUserInput(String input) {
        Integer[] unsortedList = Arrays.stream(input.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        return sortAlgorithm.sort(unsortedList);
    }

    public String getSortingAlgorithmName() {
        return sortAlgorithm.getName();
    }

    public void setSortingAlgorithm(String sortingAlgorithm) {
        SortAlgorithmFactory sortAlgorithmFactory = new SortAlgorithmFactory();

        switch (sortingAlgorithm) {
            case "1": {
                this.sortAlgorithm = sortAlgorithmFactory.getSort("insertion");
                break;
            }
            case "2": {
                this.sortAlgorithm = sortAlgorithmFactory.getSort("merge");
                break;
            }
            case "3": {
                this.sortAlgorithm = sortAlgorithmFactory.getSort("quick");
                break;
            }
            default: {
                throw new InvalidInputException("Invalid input.");
            }
        }
    }
}
