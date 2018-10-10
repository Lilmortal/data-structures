package com.data.structures.sort;

public class SortInput {
    private final static String VALID_INPUT_REGEX = "(-?\\d(\\.\\d+)?\\s?)+$";

    public static boolean isValid(String input) {
        if (!input.isEmpty() && input.matches(VALID_INPUT_REGEX)) {
            return true;
        }
        return false;
    }
}
