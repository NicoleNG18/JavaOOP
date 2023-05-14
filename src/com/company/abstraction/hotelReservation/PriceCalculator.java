package com.company.abstraction.hotelReservation;

public class PriceCalculator {

    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private DiscountType discount;

//    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, DiscountType discount) {
//        this.pricePerDay = pricePerDay;
//        this.numberOfDays = numberOfDays;
//        this.season = season;
//        this.discount = discount;
//    }

    public double returnThePrice() {
        return pricePerDay * numberOfDays * season.getMultiplier() * discount.getDiscount();
    }

}

