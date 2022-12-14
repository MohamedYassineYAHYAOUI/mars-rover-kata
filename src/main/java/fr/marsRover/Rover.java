package fr.marsRover;

import java.security.InvalidParameterException;

public class Rover {

    private final Grid grid;

    private int xPosition;
    private int yPosition;
    private char currentDirection;

    private Rover(int xPosition, int yPosition, char direction, Grid grid) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.currentDirection = direction;
        this.grid = grid;
    }

    public static Rover Create(int xPosition, int yPosition, char direction, Grid grid) {

        if (isValidDirection(direction)) {
            throw new InvalidParameterException("invalid initial direction");
        }
        if (isValidPosition(xPosition, yPosition)) {
            throw new InvalidParameterException("invalid initial position");
        }
        return new Rover(xPosition, yPosition, direction, grid);
    }

    private static boolean isValidPosition(int xPosition, int yPosition) {
        return xPosition < 0 || yPosition < 0;
    }

    private static boolean isValidDirection(char direction) {
        char upperCaseChar = Character.toUpperCase(direction);
        return upperCaseChar != 'N' && upperCaseChar != 'S' && upperCaseChar != 'W' && upperCaseChar != 'E';
    }

    public void move(String commands) {
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
        if (currentDirection == 'E') {
            xPosition += step;
        } else if (currentDirection == 'N') {
            yPosition += step;
        } else if (currentDirection == 'W') {
            if (xPosition - step < 0) {
                xPosition = grid.getGridWidth();
            } else {
                xPosition -= step;
            }

        } else if (currentDirection == 'S') {
            yPosition -= step;
        }
    }

    public int getX() {
        return xPosition;
    }

    public int getY() {
        return yPosition;
    }

    public char getDirection() {
        return currentDirection;
    }
}
