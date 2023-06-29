package com.company.solid;

public abstract class Product implements IProduct {

    private double grams;

    protected Product(double grams) {
        setGrams(grams);
    }

    public double getGrams() {
        return grams;
    }

    public void setGrams(double grams) {
        this.grams = grams;
    }
}

