package com.botvin.exception;

public class IncorrectLineException extends RuntimeException {

    private String incorrectLine;

    public IncorrectLineException(final String incorrectString) {
        System.out.println(IncorrectLineException.class.getName());
        this.incorrectLine = incorrectLine;
    }

    @Override
    public String toString() {
        return "Incorrect line: " + incorrectLine + "! Maybe one value was missed!";
    }
}