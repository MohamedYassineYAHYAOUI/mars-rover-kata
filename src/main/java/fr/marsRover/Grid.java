package fr.marsRover;

public class Grid {

    private final int gridWidth;
    private final int gridHeight;


    public Grid(int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    public boolean isValidPosition(int xPosition, int yPosition) {
        return isPositionInGrid(xPosition, yPosition);
    }

    private boolean isPositionInGrid(int xPosition, int yPosition) {
        return xPosition >= 0 && yPosition >= 0 && xPosition <= gridWidth && yPosition <= gridHeight;
    }


    public int nextVerticalPosition(int yPosition, int step) {
        if (yPosition + step > gridHeight) {
            return 0;
        }
        if (yPosition + step < 0) {
            return gridHeight;
        }
        return yPosition + step;
    }

    public int nextHorizontalPosition(int xPosition, int step) {
        if (xPosition + step > gridWidth) {
            return 0;
        }
        if (xPosition + step < 0) {
            return gridWidth;
        }
        return xPosition + step;
    }

}

