package com.company.polymorphism.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected static final DecimalFormat df = new DecimalFormat("#.##");
    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity=tankCapacity;
    }

    public abstract String drive(double kilometers);

    public abstract void refuel(double fuelLiters);



}

