package com.company.solid.exercise;


import com.company.solid.products.IProduct;
import com.company.solid.products.Product;

import java.util.List;

public class CaloriesCalculator {

    public double sum(List<Product> products) {
        return products.stream().mapToDouble(IProduct::calculateCalories).sum();
    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}


