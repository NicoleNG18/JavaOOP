package com.company.inheritance.Restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage{
    private double caffeine;
    final static double COFFEE_PRICE=3.50;
    final static double COFFEE_MILLILITERS=50;

    public Coffee(String name,double caffeine) {
        super(name, BigDecimal.valueOf(COFFEE_PRICE), COFFEE_MILLILITERS);
        setCaffeine(caffeine);
    }

    public double getCaffeine() {
        return caffeine;
    }

    public void setCaffeine(double caffeine) {
        this.caffeine = caffeine;
    }
}
