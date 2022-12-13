package fr.marsRover;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TurnCommandsTest {


    @Ignore
    @ParameterizedTest
    @CsvSource({"2,1,E,3,1,N,l"})
    void turnLeft(int initialX, int initialY, char initialDirection,
                  int expectedX, int expectedY, char expectedDirection, String commands) {

    }

}
