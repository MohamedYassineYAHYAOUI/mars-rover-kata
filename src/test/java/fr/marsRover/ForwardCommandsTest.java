package fr.marsRover;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class ForwardCommandsTest {

    @Test
    public void singleCommand(){
        Rover rover = new Rover();
        rover.move("f");

        Assertions.assertEquals(1,rover.getX());
        Assertions.assertEquals(0,rover.getY());
    }
}
