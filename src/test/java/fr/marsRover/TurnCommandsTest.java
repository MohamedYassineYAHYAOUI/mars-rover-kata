package fr.marsRover;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TurnCommandsTest {


    @Ignore
    @ParameterizedTest
    @CsvSource({"E,N,l", "N,W,l", "W,S,l", "S,E,l"})
    void turnLeft(char initialDirection, char expectedDirection, String commands) {
        Rover rover = Rover.Create(0, 0, initialDirection);

        rover.move(commands);
        Assertions.assertEquals(expectedDirection, rover.getDirection());
    }

}
