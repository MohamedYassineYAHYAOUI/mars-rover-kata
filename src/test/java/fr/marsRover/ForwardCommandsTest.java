package fr.marsRover;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class ForwardCommandsTest {

    @Test
    public void singleCommand() {
        Rover rover = new Rover(0, 0, "N");
        rover.move("f");

        Assertions.assertEquals(0, rover.getX());
        Assertions.assertEquals(1, rover.getY());
        Assertions.assertEquals("N", rover.getDirection());
    }


    @Test
    public void singleCommand2() {
        Rover rover = new Rover(0, 1, "N");
        rover.move("f");

        Assertions.assertEquals(0, rover.getX());
        Assertions.assertEquals(2, rover.getY());
        Assertions.assertEquals("N", rover.getDirection());
    }

    @Test
    public void singleCommand3() {
        Rover rover = new Rover(0, 3, "N");
        rover.move("f");

        Assertions.assertEquals(0, rover.getX());
        Assertions.assertEquals(4, rover.getY());
        Assertions.assertEquals("N", rover.getDirection());
    }
}
