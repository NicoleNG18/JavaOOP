package com.company.abstraction.trafficLights;

public class TrafficLight {

    private String color;

    public TrafficLight(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String nextColor() {

        return switch (color) {
            case "RED" -> "GREEN";
            case "GREEN" -> "YELLOW";
            case "YELLOW" -> "RED";
            default -> null;
        };

    }
}

