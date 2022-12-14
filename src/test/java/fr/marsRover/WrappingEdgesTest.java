package fr.marsRover;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WrappingEdgesTest {

    private final Grid testGrid = new Grid(10, 10);

    @Test
    public void wrappingLeftToRightOnForward() {
        Rover rover = Rover.Create(0, 0, 'N', testGrid);

        rover.move("LF");
        Assertions.assertEquals(10, rover.getX());
        Assertions.assertEquals(0, rover.getY());
        Assertions.assertEquals('W', rover.getDirection());
    }


    @Test
    public void wrappingRightToLeftOnForward() {
        Rover rover = Rover.Create(10, 0, 'N', testGrid);

        rover.move("RF");
        Assertions.assertEquals(0, rover.getX());
        Assertions.assertEquals(0, rover.getY());
        Assertions.assertEquals('E', rover.getDirection());
    }

    @Test
    public void wrappingUpToDownOnBackward() {
        Rover rover = Rover.Create(7, 8, 'N', testGrid);

        rover.move("FFLFLB");

        Assertions.assertEquals(6, rover.getX());
        Assertions.assertEquals(0, rover.getY());
        Assertions.assertEquals('S', rover.getDirection());
    }


}
