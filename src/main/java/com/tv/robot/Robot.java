package com.tv.robot;

public class Robot {
    private Coordinate coordinate;
    private Direction direction;
    private boolean alive;

    public Robot(Direction direction) {

        this.direction = direction;
    }

    public Robot(Coordinate coordinate, Direction direction) {

        this.coordinate = coordinate;
        this.direction = direction;
        this.alive = true;
    }

    public void turnLeft() {
        this.direction = direction.left();
    }


    public void turnRight() {
        this.direction = direction.right();
    }

    public void moveForward()
    {
        this.coordinate = direction.moveForwardFrom(coordinate);
        if(coordinate.x>10 || coordinate.y>10 || coordinate.x<0 || coordinate.y<0)
            this.alive = false;
    }

    public Direction direction() {
        return this.direction;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public boolean isAlive() {
        return alive;
    }
}
