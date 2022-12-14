package fr.marsRover;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WrappingEdgesTest {

    private static final int TEST_GRID_WIDTH = 10;
    private static final int TEST_GRID_HEIGHT = 10;
    private final Grid testGrid = new Grid(TEST_GRID_WIDTH, TEST_GRID_HEIGHT);

    @Test
    public void wrappingWestToEastFacingWest() {
        Rover rover = Rover.Create(0, 0, 'N', testGrid);

        rover.move("LF");
        Assertions.assertEquals(TEST_GRID_WIDTH, rover.getX());
        Assertions.assertEquals(0, rover.getY());
        Assertions.assertEquals('W', rover.getDirection());
    }


    @Test
    public void wrappingWestToEastFacingEast() {
        Rover rover = Rover.Create(1, 5, 'N', testGrid);

        rover.move("RBB");
        Assertions.assertEquals(TEST_GRID_WIDTH, rover.getX());
        Assertions.assertEquals(5, rover.getY());
        Assertions.assertEquals('E', rover.getDirection());
    }

    @Test
    public void wrappingEastToWestFacingEast() {
        Rover rover = Rover.Create(10, 0, 'N', testGrid);

        rover.move("RF");
        Assertions.assertEquals(0, rover.getX());
        Assertions.assertEquals(0, rover.getY());
        Assertions.assertEquals('E', rover.getDirection());
    }

    @Test
    public void wrappingEastToWestFacingWest() {
        Rover rover = Rover.Create(7, 3, 'E', testGrid);

        rover.move("RRBBBB");
        Assertions.assertEquals(0, rover.getX());
        Assertions.assertEquals(3, rover.getY());
        Assertions.assertEquals('W', rover.getDirection());
    }

    @Test
    public void wrappingNorthToSouthFacingNorth() {
        Rover rover = Rover.Create(7, 8, 'N', testGrid);

        rover.move("FFFF");

        Assertions.assertEquals(7, rover.getX());
        Assertions.assertEquals(1, rover.getY());
        Assertions.assertEquals('N', rover.getDirection());
    }

    @Test
    public void wrappingNorthToSouthFacingSouth() {
        Rover rover = Rover.Create(7, 8, 'N', testGrid);

        rover.move("FFLFLB");

        Assertions.assertEquals(6, rover.getX());
        Assertions.assertEquals(0, rover.getY());
        Assertions.assertEquals('S', rover.getDirection());
    }

    @Test
    public void wrappingSouthToNorthFacingSouth() {
        Rover rover = Rover.Create(6, 2, 'N', testGrid);

        rover.move("RRFFF");

        Assertions.assertEquals(6, rover.getX());
        Assertions.assertEquals(TEST_GRID_HEIGHT, rover.getY());
        Assertions.assertEquals('S', rover.getDirection());
    }

    @Test
    public void wrappingSouthToNorthFacingNorth() {
        Rover rover = Rover.Create(5, 1, 'S', testGrid);

        rover.move("RRBB");

        Assertions.assertEquals(5, rover.getX());
        Assertions.assertEquals(TEST_GRID_HEIGHT, rover.getY());
        Assertions.assertEquals('N', rover.getDirection());
    }


}
