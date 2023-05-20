package com.company.encapsulation.PizzaLab;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Veggies")
                || toppingType.equals("Cheese") || toppingType.equals("Sauce")) {

            this.toppingType = toppingType;

        } else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
    }

    public double calculateCalories() {
        switch (toppingType) {

            case "Meat":
                return 2 * 1.2 * weight;

            case "Veggies":
                return 2 * 0.8 * weight;

            case "Cheese":
                return 2 * 1.1 * weight;

            case "Sauce":
                return 2 * 0.9 * weight;

            default:
                return -1;
        }

    }
}


