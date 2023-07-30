package com.tv.robot;

public enum Direction {
    NORTH{
        public Coordinate moveForwardFrom(Coordinate coordinate) {
            return coordinate.above();
        }

        @Override
        public Direction left() {
            return WEST;
        }

        @Override
        public Direction right() {
            return EAST;
        }
    },
    EAST {
        @Override
        public Coordinate moveForwardFrom(Coordinate coordinate) {
            return coordinate.right();
        }

        @Override
        public Direction left() {
            return NORTH;
        }

        @Override
        public Direction right() {
            return SOUTH;
        }
    },
    SOUTH {
        @Override
        public Coordinate moveForwardFrom(Coordinate coordinate) {
            return coordinate.below();
        }

        @Override
        public Direction left() {
            return EAST;
        }

        @Override
        public Direction right() {
            return WEST;
        }
    },
    WEST {
        @Override
        public Coordinate moveForwardFrom(Coordinate coordinate) {
            return coordinate.left();
        }

        @Override
        public Direction left() {
            return SOUTH;
        }

        @Override
        public Direction right() {
            return NORTH;
        }
    };


    public abstract Coordinate moveForwardFrom(Coordinate coordinate);
    public abstract Direction left();
    public abstract Direction right();
}
