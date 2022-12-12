package fr.marsRover;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ForwardCommandsTest {

    @ParameterizedTest
    @CsvSource({"0,0,N,0,1", "0,1,N,0,2", "0,3,N,0,4"})
    public void singleCommand(int initialX, int initialY, String initialDirection
            , int expectedX, int expectedY) {
        Rover rover = new Rover(initialX, initialY, initialDirection);
        rover.move("f");

        Assertions.assertEquals(expectedX, rover.getX());
        Assertions.assertEquals(expectedY, rover.getY());
        Assertions.assertEquals("N", rover.getDirection());
    }

    
}
