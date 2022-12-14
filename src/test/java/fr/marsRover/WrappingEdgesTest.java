package fr.marsRover;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WrappingEdgesTest {

    private static final int TEST_GRID_WIDTH = 10;
    private static final int TEST_GRID_HEIGHT = 10;
    private final Grid testGrid = new Grid(TEST_GRID_WIDTH, TEST_GRID_HEIGHT);

    private void wrappingTest(int initialXPosition, int initialYPosition, char initialDirection, String commands,
                              int expectedXPosition, int expectedYPosition, char expectedDirection) {
        Rover rover = Rover.Create(new GridPosition(initialXPosition, initialYPosition), initialDirection, testGrid);

        rover.move(commands);

        Assertions.assertEquals(new GridPosition(expectedXPosition, expectedYPosition), rover.getPosition());
        Assertions.assertEquals(expectedDirection, rover.getDirection());
    }

    @Test
    public void wrappingWestToEastFacingWest() {

        wrappingTest(0, 0, 'N', "LF", TEST_GRID_WIDTH, 0, 'W');
    }


    @Test
    public void wrappingWestToEastFacingEast() {
        wrappingTest(1, 5, 'N', "RBB", TEST_GRID_WIDTH, 5, 'E');
    }

    @Test
    public void wrappingEastToWestFacingEast() {
        wrappingTest(TEST_GRID_WIDTH, 0, 'N', "RF", 0, 0, 'E');
    }

    @Test
    public void wrappingEastToWestFacingWest() {
        wrappingTest(7, 3, 'E', "RRBBBB", 0, 3, 'W');
    }

    @Test
    public void wrappingNorthToSouthFacingNorth() {
        wrappingTest(7, 8, 'N', "FFFF", 7, 1, 'N');
    }

    @Test
    public void wrappingNorthToSouthFacingSouth() {
        wrappingTest(7, 8, 'N', "FFLFLB", 6, 0, 'S');
    }

    @Test
    public void wrappingSouthToNorthFacingSouth() {
        wrappingTest(6, 2, 'N', "RRFFF", 6, TEST_GRID_HEIGHT, 'S');
    }

    @Test
    public void wrappingSouthToNorthFacingNorth() {
        wrappingTest(5, 1, 'S', "RRBB", 5, TEST_GRID_HEIGHT, 'N');
    }


}
