package fr.marsRover;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WrappingEdgesTest {

    private static final int TEST_GRID_WIDTH = 10;
    private static final int TEST_GRID_HEIGHT = 10;
    private final Grid testGrid = new Grid(TEST_GRID_WIDTH, TEST_GRID_HEIGHT);


    @Test
    public void should_return_correct_point_and_direction_when_wrapping_west_to_east_while_facing_west() {

        Rover rover = Rover.Create(new GridPoint(0, 0), 'N', testGrid);

        rover.move("LF");

        Assertions.assertEquals(new GridPoint(TEST_GRID_WIDTH, 0), rover.getPoint());
        Assertions.assertEquals('W', rover.getDirection());
    }


    @Test
    public void should_return_correct_point_and_direction_when_wrapping_west_to_east_while_facing_east() {
        Rover rover = Rover.Create(new GridPoint(1, 5), 'N', testGrid);

        rover.move("RBB");

        Assertions.assertEquals(new GridPoint(TEST_GRID_WIDTH, 5), rover.getPoint());
        Assertions.assertEquals('E', rover.getDirection());
    }

    @Test
    public void should_return_correct_point_and_direction_when_wrapping_east_to_west_while_facing_east() {
        Rover rover = Rover.Create(new GridPoint(TEST_GRID_WIDTH, 0), 'N', testGrid);

        rover.move("RF");

        Assertions.assertEquals(new GridPoint(0, 0), rover.getPoint());
        Assertions.assertEquals('E', rover.getDirection());
    }

    @Test
    public void should_return_correct_point_and_direction_when_wrapping_east_to_west_while_facing_west() {
        Rover rover = Rover.Create(new GridPoint(7, 3), 'E', testGrid);

        rover.move("RRBBBB");

        Assertions.assertEquals(new GridPoint(0, 3), rover.getPoint());
        Assertions.assertEquals('W', rover.getDirection());
    }

    @Test
    public void should_return_correct_point_and_direction_when_wrapping_north_to_south_while_facing_north() {
        Rover rover = Rover.Create(new GridPoint(7, 8), 'N', testGrid);

        rover.move("FFFF");

        Assertions.assertEquals(new GridPoint(7, 1), rover.getPoint());
        Assertions.assertEquals('N', rover.getDirection());
    }

    @Test
    public void should_return_correct_point_and_direction_when_wrapping_north_to_south_while_facing_south() {
        Rover rover = Rover.Create(new GridPoint(7, 8), 'N', testGrid);

        rover.move("FFLFLB");

        Assertions.assertEquals(new GridPoint(6, 0), rover.getPoint());
        Assertions.assertEquals('S', rover.getDirection());
    }

    @Test
    public void should_return_correct_point_and_direction_when_wrapping_south_to_north_while_facing_south() {
        Rover rover = Rover.Create(new GridPoint(6, 2), 'N', testGrid);

        rover.move("RRFFF");

        Assertions.assertEquals(new GridPoint(6, TEST_GRID_HEIGHT), rover.getPoint());
        Assertions.assertEquals('S', rover.getDirection());
    }

    @Test
    public void should_return_correct_point_and_direction_when_wrapping_south_to_north_while_facing_north() {
        Rover rover = Rover.Create(new GridPoint(5, 1), 'S', testGrid);

        rover.move("RRBB");

        Assertions.assertEquals(new GridPoint(5, TEST_GRID_HEIGHT), rover.getPoint());
        Assertions.assertEquals('N', rover.getDirection());
    }


}
