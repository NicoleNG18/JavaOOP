package com.company.solid.exercise;

import com.company.solid.products.Product;

import java.util.List;

public interface IQuantityCalculator {

    double getKilograms(List<Product> products);
}

