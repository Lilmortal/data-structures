package com.interview.questions.sorting;

public class InvalidInputException extends RuntimeException {
    private String error;

    public InvalidInputException(String error) {
        this.error = error;
    }

    public InvalidInputException(String message, String error) {
        super(message);
        this.error = error;
    }

    public InvalidInputException(String message, Throwable cause, String error) {
        super(message, cause);
        this.error = error;
    }

    public InvalidInputException(Throwable cause, String error) {
        super(cause);
        this.error = error;
    }

    public InvalidInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
    }
}
