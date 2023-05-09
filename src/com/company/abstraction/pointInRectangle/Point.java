package com.company.abstraction.pointInRectangle;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isGreaterThan(Point other) {
        return this.x >= other.x && this.y >= other.y;
    }
    public boolean isLowerThan(Point other) {
        return this.x <= other.x && this.y <= other.y;
    }

}

