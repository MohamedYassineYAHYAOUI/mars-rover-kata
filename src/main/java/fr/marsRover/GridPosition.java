package fr.marsRover;

public record GridPosition(int xPosition, int yPosition) {

    @Override
    public String toString() {
        return "(" + xPosition + "," + yPosition + ")";
    }
}
