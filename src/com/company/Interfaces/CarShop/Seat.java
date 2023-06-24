package com.company.Interfaces.CarShop;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower,String countryProduced, Double price) {
        super(model,color,horsePower,countryProduced);
        this.price = price;
    }

    @Override
    public String toString(){
        return String.format(
                "%s%n%s sells for %f",
                super.toString(),
                this.getModel(),
                this.getPrice());
    }

    @Override
    public Double getPrice() {
        return price;
    }
}

