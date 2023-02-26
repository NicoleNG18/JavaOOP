package com.company.abstraction.cardSuit.TraficLights;

public enum Color {

    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");

    private String nextColor;

    Color(String nextColor) {
        this.nextColor = nextColor;
    }

    public String getNextColor() {
        return nextColor;
    }

}
