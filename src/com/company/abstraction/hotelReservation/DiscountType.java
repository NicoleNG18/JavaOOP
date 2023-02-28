package com.company.abstraction.hotelReservation;

public enum DiscountType {

    VIP(0.8),
    SecondVisit(0.9),
    None(1);

    private double discount;

    DiscountType(double discount){
        this.discount=discount;
    }

    public double getDiscount() {
        return discount;
    }
}

