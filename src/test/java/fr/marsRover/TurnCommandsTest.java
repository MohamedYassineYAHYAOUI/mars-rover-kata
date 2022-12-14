package fr.marsRover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TurnCommandsTest {


    @ParameterizedTest
    @CsvSource({"E,N,l", "N,W,l", "W,S,l", "S,E,l"})
    void turnLeftOnce(char initialDirection, char expectedDirection, String commands) {
        Rover rover = Rover.Create(0, 0, initialDirection);

        rover.move(commands);
        Assertions.assertEquals(expectedDirection, rover.getDirection());
    }


    @ParameterizedTest
    @CsvSource({"E,S,r", "N,E,r", "W,N,r", "S,W,r"})
    void turnRightOnce(char initialDirection, char expectedDirection, String commands) {
        turnLeftOnce(initialDirection, expectedDirection, commands);
    }

    @ParameterizedTest
    @CsvSource({"E,E,rrrr", "N,E,lll", "N,S,lrrrrl"})
    void multipleTurns(char initialDirection, char expectedDirection, String commands) {
        turnLeftOnce(initialDirection, expectedDirection, commands);
    }

}
