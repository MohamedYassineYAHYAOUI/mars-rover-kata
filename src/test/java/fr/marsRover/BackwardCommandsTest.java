package fr.marsRover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BackwardCommandsTest {

    private final Grid testGrid = new Grid(10, 10);

    @ParameterizedTest
    @CsvSource({"1,1,N,1,0,b", "0,1,N,0,0,b", "0,3,S,0,4,b", "6,4,S,6,5,b"})
    public void should_return_correct_point_after_one_vertical_movement(int initialX, int initialY, char initialDirection,
                                                                        int expectedX, int expectedY, String commands) {
        GridPoint initialPoint = new GridPoint(initialX, initialY);
        Rover rover = Rover.Create(initialPoint, initialDirection, testGrid);
        rover.move(commands);

        Assertions.assertEquals(new GridPoint(expectedX, expectedY), rover.getPoint());
    }

    @ParameterizedTest
    @CsvSource({"1,1,N,1,0,b", "0,1,N,0,0,b", "0,3,S,0,4,b", "6,4,S,6,5,b"})
    public void should_return_correct_point_after_one_horizontal_movement(int initialX, int initialY, char initialDirection,
                                                                          int expectedX, int expectedY, String commands) {
        should_return_correct_point_after_one_vertical_movement(initialX, initialY, initialDirection, expectedX, expectedY, commands);
    }

    @ParameterizedTest
    @CsvSource({"1,3,N,1,0,bbb", "1,3,S,1,5,bb", "4,4,E,0,4,bbbb", "3,3,W,6,3,bbb"})
    public void should_return_correct_point_after_multiple_backwards(int initialX, int initialY, char initialDirection
            , int expectedX, int expectedY, String commands) {
        should_return_correct_point_after_one_vertical_movement(initialX, initialY, initialDirection, expectedX, expectedY, commands);
    }

}
