package fr.marsRover;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final int gridWidth;
    private final int gridHeight;

    private final List<GridPosition> gridObstacles = new ArrayList<>();


    public Grid(int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    public boolean isValidPosition(GridPosition position) {
        return !isPositionInGrid(position.xPosition(), position.yPosition()) || !positionWithNoObstacles(position);
    }

    private boolean positionWithNoObstacles(GridPosition position) {
        return gridObstacles.stream().noneMatch(position::equals);
    }

    private boolean isPositionInGrid(int xPosition, int yPosition) {
        return xPosition >= 0 && yPosition >= 0 && xPosition <= gridWidth && yPosition <= gridHeight;
    }


    public int nextVerticalPosition(int yPosition, int step) {
        if (yPosition + step > gridHeight) { // TODO refacto
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

    public void obstacleOn(GridPosition position) {
        gridObstacles.add(position);
    }
}

