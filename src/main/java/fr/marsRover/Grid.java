package fr.marsRover;

public class Grid {
    private final int gridWidth;
    private final int gridHeight;


    public Grid(int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public int getGridWidth() {
        return gridWidth;
    }
}

