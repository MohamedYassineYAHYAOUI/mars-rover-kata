package fr.marsRover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TurnCommandsTest {

    private final Grid testGrid = new Grid(10, 10);

    @ParameterizedTest
    @CsvSource({"E,N,l", "N,W,l", "W,S,l", "S,E,l"})
    void should_return_expected_direction_after_turning_left_once(char initialDirection, char expectedDirection, String commands) {
        GridPoint initialPoint = new GridPoint(0, 0);
        Rover rover = Rover.Create(initialPoint, initialDirection, testGrid);

        rover.move(commands);
        Assertions.assertEquals(expectedDirection, rover.getDirection());
    }


    @ParameterizedTest
    @CsvSource({"E,S,r", "N,E,r", "W,N,r", "S,W,r"})
    void should_return_expected_direction_after_turning_right_once(char initialDirection, char expectedDirection, String commands) {
        should_return_expected_direction_after_turning_left_once(initialDirection, expectedDirection, commands);
    }

    @ParameterizedTest
    @CsvSource({"E,E,rrrr", "N,E,lll", "N,S,lrrrrl"})
    void should_return_expected_direction_after_turning_multiple_times(char initialDirection, char expectedDirection, String commands) {
        should_return_expected_direction_after_turning_left_once(initialDirection, expectedDirection, commands);
    }

}
