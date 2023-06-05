package com.company.polymorphism.Vehicles;


public class Truck extends Vehicle{

    protected Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }

    @Override
    public String drive(double kilometers) {
        double neededLiters = (fuelConsumption + 1.6) * kilometers;
        if (neededLiters <= fuelQuantity) {
            fuelQuantity-=neededLiters;
            return "Truck travelled " + df.format(kilometers) + " km";
        }
        return "Truck needs refueling";
    }

    @Override
    public void refuel(double fuelLiters) {
        if((0.95*fuelLiters)+fuelQuantity<=tankCapacity) {
            this.fuelQuantity += 0.95 * fuelLiters;
        } else{
            System.out.println("Cannot fit fuel in tank");
        }

    }

}

