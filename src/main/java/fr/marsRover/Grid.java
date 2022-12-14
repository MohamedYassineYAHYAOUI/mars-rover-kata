package fr.marsRover;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final int gridWidth;
    private final int gridHeight;

    private final List<GridPoint> gridObstacles = new ArrayList<>();


    public Grid(int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    public boolean isValidPoint(GridPoint point) {
        return !isPointInGrid(point.xPoint(), point.yPoint()) || !pointWithNoObstacles(point);
    }

    private boolean pointWithNoObstacles(GridPoint point) {
        return gridObstacles.stream().noneMatch(point::equals);
    }

    private boolean isPointInGrid(int xPoint, int yPoint) {
        return xPoint >= 0 && yPoint >= 0 && xPoint <= gridWidth && yPoint <= gridHeight;
    }


    public int nextVerticalPoint(int ypoint, int step) {
        if (ypoint + step > gridHeight) {
            return 0;
        }
        if (ypoint + step < 0) {
            return gridHeight;
        }
        return ypoint + step;
    }

    public int nextHorizontalPoint(int xpoint, int step) {
        if (xpoint + step > gridWidth) {
            return 0;
        }
        if (xpoint + step < 0) {
            return gridWidth;
        }
        return xpoint + step;
    }

    public void obstacleOn(GridPoint point) {
        gridObstacles.add(point);
    }
}

