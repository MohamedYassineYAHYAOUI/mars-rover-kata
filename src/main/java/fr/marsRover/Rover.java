package fr.marsRover;

import java.security.InvalidParameterException;

public class Rover {

    private final Grid grid;
    private GridPosition position;
    private char currentDirection;

    private Rover(GridPosition position, char direction, Grid grid) {
        this.position = position;
        this.currentDirection = direction;
        this.grid = grid;
    }

    public static Rover Create(GridPosition position, char direction, Grid grid) {

        if (isValidDirection(direction)) {
            throw new InvalidParameterException("invalid initial direction");
        }
        if (grid.isValidPosition(position)) {
            throw new InvalidParameterException("invalid initial position");
        }
        return new Rover(position, direction, grid);
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
        int newXPos = position.xPosition();
        int newYPos = position.yPosition();
        if (currentDirection == 'E') { // TODO refacto methode
            newXPos = grid.nextHorizontalPosition(position.xPosition(), step);
        }
        if (currentDirection == 'N') {
            newYPos = grid.nextVerticalPosition(newYPos, step);
        }
        if (currentDirection == 'W') {
            newXPos = grid.nextHorizontalPosition(newXPos, -step);
        }
        if (currentDirection == 'S') {
            newYPos = grid.nextVerticalPosition(newYPos, -step);
        }
        var newPos = new GridPosition(newXPos, newYPos);
        if (grid.isValidPosition(newPos)) {
            throw new IllegalStateException("Obstacle on next position " + newPos);
        }
        position = new GridPosition(newXPos, newYPos);

    }

    public GridPosition getPosition() {
        return position;
    }

    public char getDirection() {
        return currentDirection;
    }
}
