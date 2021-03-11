package org.demo2.enums;

public enum Color {
    RED("RED"), GREEN("GREEN"), BLACK("BLACK"), YELLOW("YELLOW");
    private String color;
    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
