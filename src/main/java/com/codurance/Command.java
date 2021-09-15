package com.codurance;

public enum Command {
    LEFT("L"),
    RIGHT("R");

    public final String input;

    Command(String input) {

        this.input = input;
    }
}
