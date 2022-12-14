package fr.marsRover;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ObstaclesDetectionsTest {

    @Test
    public void NoObstaclesEncountered() {
        Grid testGrid = new Grid(10, 10);

        testGrid.obstacleOn(new GridPosition(0, 3));
        testGrid.obstacleOn(new GridPosition(1, 1));
        testGrid.obstacleOn(new GridPosition(3, 2));
        testGrid.obstacleOn(new GridPosition(3, 3));
        testGrid.obstacleOn(new GridPosition(1, 4));


        GridPosition initialPosition = new GridPosition(0, 0);
        Rover rover = Rover.Create(initialPosition, 'N', testGrid);

        rover.move("LLBBLFFRBBBRFFLF");

        Assertions.assertEquals(new GridPosition(0, 4), rover.getPosition());
        Assertions.assertEquals('S', rover.getDirection());
    }

    @Test
    public void obstaclesForward() {
        Grid testGrid = new Grid(10, 10);
        testGrid.obstacleOn(new GridPosition(2, 2));

        GridPosition initialPosition = new GridPosition(0, 0);
        Rover rover = Rover.Create(initialPosition, 'N', testGrid);

        Assertions.assertThrows(IllegalStateException.class, () -> rover.move("FFRFFF"));
        Assertions.assertEquals(new GridPosition(1, 2), rover.getPosition());
        Assertions.assertEquals('E', rover.getDirection());
    }

    @Test
    public void obstaclesBackwards() {
        Grid testGrid = new Grid(10, 10);

        testGrid.obstacleOn(new GridPosition(3, 2));
        Rover rover = Rover.Create(new GridPosition(3, 0), 'N', testGrid);

        Assertions.assertThrows(IllegalStateException.class, () -> rover.move("RRBBB"));
        Assertions.assertEquals(new GridPosition(3, 1), rover.getPosition());
        Assertions.assertEquals('S', rover.getDirection());
    }

    @Test
    public void obstaclesOnWrappingForward() {
        Grid testGrid = new Grid(10, 10);
        testGrid.obstacleOn(new GridPosition(5, 0));

        Rover rover = Rover.Create(new GridPosition(5, 10), 'N', testGrid);

        Assertions.assertThrows(IllegalStateException.class, () -> rover.move("F"));
        Assertions.assertEquals(new GridPosition(5, 10), rover.getPosition());

    }

    @Test
    public void obstaclesOnWrappingBackwards() {
        Grid testGrid = new Grid(10, 10);
        testGrid.obstacleOn(new GridPosition(0, 6));

        Rover rover = Rover.Create(new GridPosition(10, 6), 'W', testGrid);

        Assertions.assertThrows(IllegalStateException.class, () -> rover.move("B"));
        Assertions.assertEquals(new GridPosition(10, 6), rover.getPosition());
    }
}
