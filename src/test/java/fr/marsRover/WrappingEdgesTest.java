package fr.marsRover;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WrappingEdgesTest {

    private static final int TEST_GRID_WIDTH = 10;
    private static final int TEST_GRID_HEIGHT = 10;
    private final Grid testGrid = new Grid(TEST_GRID_WIDTH, TEST_GRID_HEIGHT);


    @Test
    public void wrappingWestToEastFacingWest() {

        Rover rover = Rover.Create(new GridPoint(0, 0), 'N', testGrid);

        rover.move("LF");

        Assertions.assertEquals(new GridPoint(TEST_GRID_WIDTH, 0), rover.getPoint());
        Assertions.assertEquals('W', rover.getDirection());
    }


    @Test
    public void wrappingWestToEastFacingEast() {
        Rover rover = Rover.Create(new GridPoint(1, 5), 'N', testGrid);

        rover.move("RBB");

        Assertions.assertEquals(new GridPoint(TEST_GRID_WIDTH, 5), rover.getPoint());
        Assertions.assertEquals('E', rover.getDirection());
    }

    @Test
    public void wrappingEastToWestFacingEast() {
        Rover rover = Rover.Create(new GridPoint(TEST_GRID_WIDTH, 0), 'N', testGrid);

        rover.move("RF");

        Assertions.assertEquals(new GridPoint(0, 0), rover.getPoint());
        Assertions.assertEquals('E', rover.getDirection());
    }

    @Test
    public void wrappingEastToWestFacingWest() {
        Rover rover = Rover.Create(new GridPoint(7, 3), 'E', testGrid);

        rover.move("RRBBBB");

        Assertions.assertEquals(new GridPoint(0, 3), rover.getPoint());
        Assertions.assertEquals('W', rover.getDirection());
    }

    @Test
    public void wrappingNorthToSouthFacingNorth() {
        Rover rover = Rover.Create(new GridPoint(7, 8), 'N', testGrid);

        rover.move("FFFF");

        Assertions.assertEquals(new GridPoint(7, 1), rover.getPoint());
        Assertions.assertEquals('N', rover.getDirection());
    }

    @Test
    public void wrappingNorthToSouthFacingSouth() {
        Rover rover = Rover.Create(new GridPoint(7, 8), 'N', testGrid);

        rover.move("FFLFLB");

        Assertions.assertEquals(new GridPoint(6, 0), rover.getPoint());
        Assertions.assertEquals('S', rover.getDirection());
    }

    @Test
    public void wrappingSouthToNorthFacingSouth() {
        Rover rover = Rover.Create(new GridPoint(6, 2), 'N', testGrid);

        rover.move("RRFFF");

        Assertions.assertEquals(new GridPoint(6, TEST_GRID_HEIGHT), rover.getPoint());
        Assertions.assertEquals('S', rover.getDirection());
    }

    @Test
    public void wrappingSouthToNorthFacingNorth() {
        Rover rover = Rover.Create(new GridPoint(5, 1), 'S', testGrid);

        rover.move("RRBB");

        Assertions.assertEquals(new GridPoint(5, TEST_GRID_HEIGHT), rover.getPoint());
        Assertions.assertEquals('N', rover.getDirection());
    }


}
