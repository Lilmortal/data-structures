package com.interview.questions.sort;

import com.interview.questions.InvalidInputException;

import java.util.Arrays;

public class SortResource {
    private Sort sort;

    public Double[] getSortedUserInput(String input) {
        Double[] unsortedList = Arrays.stream(input.split(" ")).map(Double::parseDouble).toArray(Double[]::new);
        return sort.sort(unsortedList);
    }

    public String getSortName() {
        return sort.getName();
    }

    public void setSort(String sort) {
        SortFactory sortFactory = new SortFactory();

        switch (sort) {
            case "1": {
                this.sort = sortFactory.getSort("insertion");
                break;
            }
            case "2": {
                this.sort = sortFactory.getSort("merge");
                break;
            }
            case "3": {
                this.sort = sortFactory.getSort("quick");
                break;
            }
            default: {
                throw new InvalidInputException("Invalid input.");
            }
        }
    }
}
