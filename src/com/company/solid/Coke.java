package com.company.solid;

public class Coke extends Product{

    private static final double CALORIES_PER_100_GRAMS = 44.0;
    private static final double DENSITY = 0.6;
    private double grams;

    public Coke(double milliliters) {
        super(milliliters*DENSITY);
    }

    public double getGrams(){
        return this.grams;
    }

    @Override
    public double calculateCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * (grams);
    }
}

