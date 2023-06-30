package com.company.solid.products;

public class Chips extends Product {

    private static final double CALORIES_PER_100_GRAMS = 529.0;

    public Chips(double grams) {
        super(grams);
    }

    @Override
    public double calculateCalories() {
        return  (CALORIES_PER_100_GRAMS / 100) * getGrams();
    }
}

