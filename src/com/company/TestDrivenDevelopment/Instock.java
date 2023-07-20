package com.company.TestDrivenDevelopment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    List<Product> products;

    public Instock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.products.contains(product);
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public void changeQuantity(String label, int quantity) {
        Product productToChange = findByLabel(label);
        productToChange.setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        if (index < 0 || index >= this.products.size()) {
            throw new IndexOutOfBoundsException();
        }
        return this.products.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        return this.products.stream().filter(e -> e.getLabel().equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count < 1 || count > this.products.size()) {
            return new ArrayList<>();
        }
        return this.products.stream()
                .limit(count)
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.products.stream()
                .filter(e -> e.getPrice() > lo && e.getPrice() <= hi)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.products.stream()
                .filter(e -> e.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count > getCount()) {
            throw new IllegalArgumentException();
        }
        return this.products.stream()
                .limit(count)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.products.stream()
                .filter(e -> e.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.iterator();
    }
}

