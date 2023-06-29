package com.company.solid;

public class Lemonade extends Product {

    private static final double CALORIES_PER_100_GRAMS = 53.0;
    private static final double DENSITY = 0.7;
    private double grams;

    public Lemonade(double milliliters) {
        super(milliliters*DENSITY);
    }

    @Override
    public double getGrams() {
        return this.grams;
    }

    @Override
    public double calculateCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * (grams);
    }
}

