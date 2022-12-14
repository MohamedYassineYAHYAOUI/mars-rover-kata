package fr.marsRover;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WrappingEdgesTest {


    @Test
    public void wrappingLeftToRight() {
        Grid grid = new Grid(10, 10);
        Rover rover = Rover.Create(0, 0, 'N', grid);

        rover.move("LF");
        Assertions.assertEquals(10, rover.getX());
        Assertions.assertEquals(0, rover.getY());
        Assertions.assertEquals('W', rover.getDirection());
    }

}
