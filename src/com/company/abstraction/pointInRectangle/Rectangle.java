package com.company.abstraction.pointInRectangle;

public class Rectangle {

    private Point A;
    private Point C;

    public Rectangle(Point a, Point c) {
        this.A = a;
        this.C = c;
    }

    public boolean contains(Point point){
        return point.isGreaterThan(A) && point.isLowerThan(C);
    }

}
