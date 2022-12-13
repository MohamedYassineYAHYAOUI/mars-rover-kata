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
        if (direction != 'N' && direction != 'S' && direction != 'W' && direction != 'E') {
            throw new InvalidParameterException("invalid initial direction");
        }
        if (xPosition < 0 || yPosition < 0) {
            throw new InvalidParameterException("invalid initial position");
        }
        return new Rover(xPosition, yPosition, direction);
    }

    public void move(String commands) {
        for (char command : commands.toCharArray()) {
            if ('N' == currentDirection) {
                yPosition++;
            } else if ('S' == currentDirection) {
                yPosition--;
            } else if ('E' == currentDirection) {
                xPosition++;
            } else if ('W' == currentDirection) {
                xPosition--;
            }
        }
    }

    public int getX() {
        return xPosition;
    }

    public int getY() {
        return yPosition;
    }

    public String getDirection() {
        return "N";
    }
}
