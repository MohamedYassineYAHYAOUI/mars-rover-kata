package fr.marsRover;

import java.security.InvalidParameterException;

public class Rover {

    private final Grid grid;
    private GridPoint point;
    private char currentDirection;

    private static boolean isValidDirection(char direction) {
        char upperCaseChar = Character.toUpperCase(direction);
        return upperCaseChar != 'N' && upperCaseChar != 'S' && upperCaseChar != 'W' && upperCaseChar != 'E';
    }

    public static Rover Create(GridPoint point, char direction, Grid grid) {

        if (isValidDirection(direction)) {
            throw new InvalidParameterException("invalid initial direction");
        }
        if (grid.isValidPoint(point)) {
            throw new InvalidParameterException("invalid initial point");
        }
        return new Rover(point, direction, grid);
    }

    private Rover(GridPoint point, char direction, Grid grid) {
        this.point = point;
        this.currentDirection = direction;
        this.grid = grid;
    }

    public void move(String commands) {
        isCommandValid(commands);
        for (char command : commands.toCharArray()) {
            char upperCaseCommand = Character.toUpperCase(command);
            switch (upperCaseCommand) {
                case 'F' -> advanceRoverByStep(1);
                case 'B' -> advanceRoverByStep(-1);
                case 'L' -> turnLeft();
                case 'R' -> turnRight();
            }
        }
    }

    private void isCommandValid(String commands) {
        if (commands == null || commands.isBlank()) {
            throw new IllegalArgumentException("invalid Command");
        }
    }

    private void turnRight() {
        switch (currentDirection) {
            case 'E' -> currentDirection = 'S';
            case 'N' -> currentDirection = 'E';
            case 'W' -> currentDirection = 'N';
            case 'S' -> currentDirection = 'W';
        }
    }

    private void turnLeft() {
        switch (currentDirection) {
            case 'E' -> currentDirection = 'N';
            case 'N' -> currentDirection = 'W';
            case 'W' -> currentDirection = 'S';
            case 'S' -> currentDirection = 'E';
        }
    }

    private void advanceRoverByStep(int step) {
        int newXPos = point.xPoint();
        int newYPos = point.yPoint();
        switch (currentDirection) {
            case 'E' -> newXPos = grid.nextHorizontalPoint(point.xPoint(), step);
            case 'N' -> newYPos = grid.nextVerticalPoint(newYPos, step);
            case 'W' -> newXPos = grid.nextHorizontalPoint(newXPos, -step);
            case 'S' -> newYPos = grid.nextVerticalPoint(newYPos, -step);
        }
        point = isFacingObstacle(new GridPoint(newXPos, newYPos));

    }

    private GridPoint isFacingObstacle(GridPoint newPos) {
        if (grid.isValidPoint(newPos)) {
            throw new IllegalStateException("Obstacle on next point " + newPos);
        }
        return newPos;
    }

    public GridPoint getPoint() {
        return point;
    }

    public char getDirection() {
        return currentDirection;
    }
}
