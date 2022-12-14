package fr.marsRover;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ObstaclesDetectionsTest {


    /* todo
         Encounter obstacles on forward
         Encounter obstacles on backward
         Encounter obstacles on forward wrapping
         Encounter obstacles on backward wrapping
         Encounter -> sequence abort and return
     */


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

        Assertions.assertEquals(0, rover.getX());
        Assertions.assertEquals(4, rover.getY());
        Assertions.assertEquals('S', rover.getDirection());
    }
}
