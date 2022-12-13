package fr.marsRover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BackwardCommandsTest {


    @ParameterizedTest
    @CsvSource({"1,1,N,1,0,b", "0,1,N,0,0,b", "0,3,S,0,4,b", "6,4,S,6,5,b"})
    public void singleYMovement(int initialX, int initialY, char initialDirection,
                                int expectedX, int expectedY, String commands) {
        Rover rover = Rover.Create(initialX, initialY, initialDirection);
        rover.move(commands);

        Assertions.assertEquals(expectedY, rover.getY());
        Assertions.assertEquals(expectedX, rover.getX());
    }

}
