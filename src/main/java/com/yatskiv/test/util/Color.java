package com.yatskiv.test.util;

public enum Color {
    GREEN("Green"),
    RED("Red"),
    BLUE("Blue"),
    WHITE("White"),
    BLACK("Black");

    private String value;

    public String getValue() {
        return value;
    }

    Color(String value) {
        this.value = value;
    }
}
