package fr.marsRover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObstaclesDetectionsTest {

    @Test
    public void NoObstaclesEncountered() {
        Grid testGrid = new Grid(10, 10);

        testGrid.obstacleOn(new GridPoint(0, 3));
        testGrid.obstacleOn(new GridPoint(1, 1));
        testGrid.obstacleOn(new GridPoint(3, 2));
        testGrid.obstacleOn(new GridPoint(3, 3));
        testGrid.obstacleOn(new GridPoint(1, 4));


        GridPoint initialPoint = new GridPoint(0, 0);
        Rover rover = Rover.Create(initialPoint, 'N', testGrid);

        rover.move("LLBBLFFRBBBRFFLF");

        Assertions.assertEquals(new GridPoint(0, 4), rover.getPoint());
        Assertions.assertEquals('S', rover.getDirection());
    }

    @Test
    public void obstaclesForward() {
        Grid testGrid = new Grid(10, 10);
        testGrid.obstacleOn(new GridPoint(2, 2));

        GridPoint initialPoint = new GridPoint(0, 0);
        Rover rover = Rover.Create(initialPoint, 'N', testGrid);

        Assertions.assertThrows(IllegalStateException.class, () -> rover.move("FFRFFF"));
        Assertions.assertEquals(new GridPoint(1, 2), rover.getPoint());
        Assertions.assertEquals('E', rover.getDirection());
    }

    @Test
    public void obstaclesBackwards() {
        Grid testGrid = new Grid(10, 10);

        testGrid.obstacleOn(new GridPoint(3, 2));
        Rover rover = Rover.Create(new GridPoint(3, 0), 'N', testGrid);

        Assertions.assertThrows(IllegalStateException.class, () -> rover.move("RRBBB"));
        Assertions.assertEquals(new GridPoint(3, 1), rover.getPoint());
        Assertions.assertEquals('S', rover.getDirection());
    }

    @Test
    public void obstaclesOnWrappingForward() {
        Grid testGrid = new Grid(10, 10);
        testGrid.obstacleOn(new GridPoint(5, 0));

        Rover rover = Rover.Create(new GridPoint(5, 10), 'N', testGrid);

        Assertions.assertThrows(IllegalStateException.class, () -> rover.move("F"));
        Assertions.assertEquals(new GridPoint(5, 10), rover.getPoint());

    }

    @Test
    public void obstaclesOnWrappingBackwards() {
        Grid testGrid = new Grid(10, 10);
        testGrid.obstacleOn(new GridPoint(0, 6));

        Rover rover = Rover.Create(new GridPoint(10, 6), 'W', testGrid);

        Assertions.assertThrows(IllegalStateException.class, () -> rover.move("B"));
        Assertions.assertEquals(new GridPoint(10, 6), rover.getPoint());
    }
}
