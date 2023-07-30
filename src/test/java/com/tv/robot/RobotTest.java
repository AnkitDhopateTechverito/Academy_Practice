package com.tv.robot;

import com.tv.robot.Coordinate;
import com.tv.robot.Direction;
import com.tv.robot.Robot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    @Test
    @DisplayName("Direction should be west when turning left from north")
    public void directionShouldBeWESTWhenTurnsLEFTFromNORTH() {
        Robot robot = new Robot(Direction.NORTH);
        robot.turnLeft();
        Direction actual = robot.direction();
        assertEquals(Direction.WEST, actual);
    }

    @Test
    public void directionShouldBeSOUTHWhenTurnsLEFTFromWEST() {
        Robot robot = new Robot(Direction.WEST);
        robot.turnLeft();
        Direction actual = robot.direction();
        assertEquals(Direction.SOUTH, actual);
    }

    @Test
    public void directionShouldBeEASTWhenTurnsLEFTFromSOUTH() {
        Robot robot = new Robot(Direction.SOUTH);
        robot.turnLeft();
        Direction actual = robot.direction();
        assertEquals(Direction.EAST, actual);
    }

    @Test
    public void directionShouldBeNORTHWhenTurnsLEFTFromEAST() {
        Robot robot = new Robot(Direction.EAST);
        robot.turnLeft();
        Direction actual = robot.direction();
        assertEquals(Direction.NORTH, actual);
    }

    @Test
    public void directionShouldBeEASTWhenTurnsRIGHTFromNORTH() {
        Robot robot = new Robot(Direction.NORTH);
        robot.turnRight();
        Direction actual = robot.direction();
        assertEquals(Direction.EAST, actual);
    }

    @Test
    public void directionShouldBeSOUTHWhenTurnsRIGHTFromEAST() {
        Robot robot = new Robot(Direction.EAST);
        robot.turnRight();
        Direction actual = robot.direction();
        assertEquals(Direction.SOUTH, actual);
    }

    @Test
    public void directionShouldBeWESTWhenTurnsRIGHTFromSOUTH() {
        Robot robot = new Robot(Direction.SOUTH);
        robot.turnRight();
        Direction actual = robot.direction();
        assertEquals(Direction.WEST, actual);
    }

    @Test
    public void directionShouldBeNORTHWhenTurnsRIGHTFromWEST() {
        Robot robot = new Robot(Direction.WEST);
        robot.turnRight();
        Direction actual = robot.direction();
        assertEquals(Direction.NORTH, actual);
    }

    @Test
    public void coordinateShouldBeChangeFrom_0_0_To_0_1_WhenMoveForwardToNORTH() {
        Robot robot = new Robot(new Coordinate(0, 0), Direction.NORTH);
        robot.moveForward();
        Coordinate actual = robot.getCoordinate();
        assertEquals(new Coordinate(0, 1), actual);
    }

    @Test
    public void coordinateShouldBeChangeFrom_1_1_To_1_2_WhenMoveForwardToNORTH() {
        Robot robot = new Robot(new Coordinate(1, 1), Direction.NORTH);
        robot.moveForward();
        Coordinate actual = robot.getCoordinate();
        assertEquals(new Coordinate(1, 2), actual);
    }

    @Test
    public void coordinateShouldBeChangeFrom_0_0_To_Minus_1_0_WhenMoveForwardToWEST() {
        Robot robot = new Robot(new Coordinate(0, 0), Direction.WEST);
        robot.moveForward();
        Coordinate actual = robot.getCoordinate();
        assertEquals(new Coordinate(-1, 0), actual);
    }

    @Test
    public void coordinateShouldBeChangeFromMINUS_1_1_To_Minus_2_1_WhenMoveForwardToWEST() {
        Robot robot = new Robot(new Coordinate(-1, 1), Direction.WEST);
        robot.moveForward();
        Coordinate actual = robot.getCoordinate();
        assertEquals(new Coordinate(-2, 1), actual);
    }

    @Test
    public void coordinateShouldBeChangeFrom_0_0_To_0_Minus_1_WhenMoveForwardToSOUTH() {
        Robot robot = new Robot(new Coordinate(0, 0), Direction.SOUTH);
        robot.moveForward();
        Coordinate actual = robot.getCoordinate();
        assertEquals(new Coordinate(0, -1), actual);
    }

    @Test
    public void coordinateShouldBeChangeFrom_1_Minus_1_To_1_Minus_2_WhenMoveForwardToSOUTH() {
        Robot robot = new Robot(new Coordinate(1, -1), Direction.SOUTH);
        robot.moveForward();
        Coordinate actual = robot.getCoordinate();
        assertEquals(new Coordinate(1, -2), actual);
    }

    @Test
    public void coordinateShouldBeChangeFrom_0_0_To_1_0_WhenMoveForwardToEAST() {
        Robot robot = new Robot(new Coordinate(0, 0), Direction.EAST);
        robot.moveForward();
        Coordinate actual = robot.getCoordinate();
        assertEquals(new Coordinate(1, 0), actual);
    }

    @Test
    public void coordinateShouldBeChangeFrom_1_1_To_2_1_WhenMoveForwardToEAST() {
        Robot robot = new Robot(new Coordinate(1, 1), Direction.EAST);
        robot.moveForward();
        Coordinate actual = robot.getCoordinate();
        assertEquals(new Coordinate(2, 1), actual);
    }

    @Test
    public void robotShouldBeAliveWhenMovedForwardToNORTHFrom_10_9(){
        Robot robot = new Robot(new Coordinate(10, 9), Direction.NORTH);
        robot.moveForward();
        boolean actual = robot.isAlive();
        assertTrue(actual);
    }

    @Test
    public void robotShouldBeDeadWhenMovedForwardToNORTHFrom_10_10(){
        Robot robot = new Robot(new Coordinate(10, 10), Direction.NORTH);
        robot.moveForward();
        boolean actual = robot.isAlive();
        assertFalse(actual);
    }

    @Test
    public void robotShouldBeAliveWhenMovedForwardToEAST_3_4(){
        Robot robot = new Robot(new Coordinate(3, 4), Direction.EAST);
        robot.moveForward();
        boolean actual = robot.isAlive();
        assertTrue(actual);
    }

    @Test
    public void robotShouldBeDeadWhenMovedForwardToEAST_10_10(){
        Robot robot = new Robot(new Coordinate(10, 10), Direction.EAST);
        robot.moveForward();
        boolean actual = robot.isAlive();
        assertFalse(actual);
    }

    @Test
    public void robotShouldBeAliveWhenMovedForwardToSOUTH_6_10(){
        Robot robot = new Robot(new Coordinate(6, 10), Direction.SOUTH);
        robot.moveForward();
        boolean actual = robot.isAlive();
        assertTrue(actual);
    }

    @Test
    public void robotShouldBeDeadWhenMovedForwardToSOUTH_10_0(){
        Robot robot = new Robot(new Coordinate(10, 0), Direction.SOUTH);
        robot.moveForward();
        boolean actual = robot.isAlive();
        assertFalse(actual);
    }

    @Test
    public void robotShouldBeAliveWhenMovedForwardToWEST_1_10(){
        Robot robot = new Robot(new Coordinate(1, 10), Direction.WEST);
        robot.moveForward();
        boolean actual = robot.isAlive();
        assertTrue(actual);
    }

    @Test
    public void robotShouldBeDeadWhenMovedForwardToWEST_0_7(){
        Robot robot = new Robot(new Coordinate(0, 7), Direction.WEST);
        robot.moveForward();
        boolean actual = robot.isAlive();
        assertFalse(actual);
    }
}
