package com.company.polymorphism.Vehicles;

public class Car extends Vehicle {

    protected Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(double kilometers) {
        double neededLiters = (fuelConsumption + 0.9) * kilometers;
        if (neededLiters <= fuelQuantity) {
            fuelQuantity -= neededLiters;
            return "Car travelled " + df.format(kilometers) + " km";
        }
        return "Car needs refueling";
    }

    @Override
    public void refuel(double fuelLiters) {
        if (fuelLiters + fuelQuantity <= tankCapacity) {
            this.fuelQuantity += fuelLiters;
        } else {
            System.out.println("Cannot fit fuel in tank");
        }
    }


}

