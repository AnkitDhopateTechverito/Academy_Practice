package com.tv.rectangle;

public class Rectangle {
    private final int length;
    private final int breadth;

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }

    public int area() {
        return length * breadth;
    }

    public int perimeter() {
        return 2 * (length + breadth);
    }

    public void render() {

    }

    private boolean isAreaGreaterThan100() {
        return true;
    }
}
