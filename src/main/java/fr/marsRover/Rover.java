package fr.marsRover;

import java.security.InvalidParameterException;

public class Rover {


    private int xPosition;
    private int yPosition;
    private char currentDirection;

    private Rover(int xPosition, int yPosition, char direction) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.currentDirection = direction;
    }

    public static Rover Create(int xPosition, int yPosition, char direction) {
        if (isValidDirection(direction)) {
            throw new InvalidParameterException("invalid initial direction");
        }
        if (isValidPosition(xPosition, yPosition)) {
            throw new InvalidParameterException("invalid initial position");
        }
        return new Rover(xPosition, yPosition, direction);
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
            if (upperCaseCommand == 'F') {
                advanceRoverByStep(1);
            }
            if (upperCaseCommand == 'B') {
                advanceRoverByStep(-1);
            }
            if (upperCaseCommand == 'L') {
                if (currentDirection == 'E') {
                    currentDirection = 'N';
                }
            }
        }
    }

    private void advanceRoverByStep(int step) {
        switch (currentDirection) {
            case 'N' -> yPosition += step;
            case 'S' -> yPosition -= step;
            case 'E' -> xPosition += step;
            case 'W' -> xPosition -= step;
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
