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
                switch (currentDirection) {
                    case 'N' -> yPosition++;
                    case 'S' -> yPosition--;
                    case 'E' -> xPosition++;
                    case 'W' -> xPosition--;
                }
            }
            if (upperCaseCommand == 'B') {
                switch (currentDirection) {
                    case 'N' -> yPosition--;
                    case 'S' -> yPosition++;
                    case 'E' -> xPosition--;
                    case 'W' -> xPosition++;
                }
            }
        }
    }

    public int getX() {
        return xPosition;
    }

    public int getY() {
        return yPosition;
    }

}
