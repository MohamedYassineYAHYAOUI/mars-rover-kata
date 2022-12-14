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


    public int nextVerticalPoint(int yPoint, int step) {
        return nextPoint(yPoint, step, gridHeight);
    }

    public int nextHorizontalPoint(int xPoint, int step) {
        return nextPoint(xPoint, step, gridWidth);
    }

    private int nextPoint(int coordinate, int step, int gridDimension) {
        if (coordinate + step > gridDimension) {
            return 0;
        }
        if (coordinate + step < 0) {
            return gridDimension;
        }
        return coordinate + step;
    }

    public void obstacleOn(GridPoint point) {
        gridObstacles.add(point);
    }
}

