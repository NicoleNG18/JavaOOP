package com.company.abstraction.cardSuit.TraficLights;

public class TrafficLight {

    private String color;

    public TrafficLight(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String nextColor() {

        if (color.equals("RED")) {
            return "GREEN";

        } else if (color.equals("GREEN")) {
            return "YELLOW";

        } else if (color.equals("YELLOW")) {
            return "RED";
        }

        return null;

    }
}

