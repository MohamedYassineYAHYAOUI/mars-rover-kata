package fr.marsRover;

public class Rover {

    private int xPosition;
    private int yPosition;
    private String currentDirection;

    public Rover(int xPosition, int yPosition, String direction) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.currentDirection = direction;

    }

    public void move(String commands) {
        for (char command : commands.toCharArray()) {
            if ("N".equals(currentDirection)) {
                yPosition = yPosition + 1;
            }
            if ("S".equals(currentDirection)) {
                yPosition = yPosition - 1;
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
