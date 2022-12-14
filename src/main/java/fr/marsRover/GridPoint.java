package fr.marsRover;

public record GridPoint(int xPoint, int yPoint) {

    @Override
    public String toString() {
        return "(" + xPoint + "," + yPoint + ")";
    }
}
