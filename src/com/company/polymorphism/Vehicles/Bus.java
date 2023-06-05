package com.company.polymorphism.Vehicles;

public class Bus extends Vehicle {
    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public String driveEmpty(double kilometers) {
        double neededLiters = fuelConsumption * kilometers;
        if (neededLiters <= fuelQuantity) {
            fuelQuantity -= neededLiters;
            return "Bus travelled " + df.format(kilometers) + " km";
        }
        return "Bus needs refueling";
    }

    @Override
    public String drive(double kilometers) {
        double neededLiters = (fuelConsumption * kilometers) + (1.4 * kilometers);
        if (neededLiters <= fuelQuantity) {
            fuelQuantity -= neededLiters;
            return "Bus travelled " + df.format(kilometers) + " km";
        }
        return "Bus needs refueling";
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

