package com.company.solid.exercise;

import com.company.solid.products.Product;

import java.util.List;

public class QuantityCalculator implements IQuantityCalculator {

    @Override
    public double getKilograms(List<Product> products) {
        double sumGrams= products.stream().mapToDouble(Product::getGrams).sum();
        return sumGrams/1000;
    }

}

