package com.company.polymorphism.Shape;

public class Rectangle extends Shape {
    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height=height;
        this.width=width;
    }

    final Double getHeight() {
        return height;
    }

    final Double getWidth() {
        return width;
    }

    @Override
    public Double calculatePerimeter() {
        if (perimeter==null){
            perimeter=2 * (height + width);
        }
        return perimeter;
    }

    @Override
    public Double calculateArea() {
        if(area==null){
            area=height * width;
        }
        return area;
    }
}
