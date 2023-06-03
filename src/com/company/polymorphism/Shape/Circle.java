package com.company.polymorphism.Shape;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius=radius;
    }

    final Double getRadius() {
        return radius;
    }

    @Override
    public Double calculatePerimeter() {
        if(perimeter==null){
            perimeter=2 * Math.PI * radius;
        }
        return perimeter;
    }

    @Override
    public Double calculateArea() {
        if(area==null){
            area=Math.PI * radius * radius;
        }
        return area;
    }
}

