package fr.marsRover;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.security.InvalidParameterException;

public class ForwardCommandsTest {

    private final Grid testGrid = new Grid(10, 10);

    @ParameterizedTest
    @CsvSource({"0,0,L", "0,0,*", "0,0,!", "-1,5,W", "1,-8,N",})
    public void should_throw_on_invalid_direction_or_invalid_initial_point(int initialX, int initialY, char initialDirection) {
        GridPoint initialPoint = new GridPoint(initialX, initialY);
        Assertions.assertThrows(InvalidParameterException.class, () -> Rover.Create(initialPoint, initialDirection, testGrid));
    }

    @ParameterizedTest
    @CsvSource({"0,0,N,0,1,f", "0,1,N,0,2,f", "0,3,S,0,2,f", "6,4,S,6,3,f"})
    public void should_return_correct_point_after_one_forward_vertical_movement(int initialX, int initialY, char initialDirection,
                                                                                int expectedX, int expectedY, String commands) {
        GridPoint initialPoint = new GridPoint(initialX, initialY);
        Rover rover = Rover.Create(initialPoint, initialDirection, testGrid);
        rover.move(commands);

        Assertions.assertEquals(new GridPoint(expectedX, expectedY), rover.getPoint());
    }

    @ParameterizedTest
    @CsvSource({"2,1,E,3,1,f", "5,2,W,4,2,f"})
    public void should_return_correct_point_after_one_horizontal_forward_movement(int initialX, int initialY, char initialDirection,
                                                                                  int expectedX, int expectedY, String commands) {
        should_return_correct_point_after_one_forward_vertical_movement(initialX, initialY, initialDirection, expectedX, expectedY, commands);
    }

    @ParameterizedTest
    @CsvSource({"1,3,N,1,6,fff", "1,3,S,1,1,ff", "1,3,E,5,3,ffff", "3,3,W,0,3,fff"})
    public void should_return_correct_point_after_multiple_forward_commands(int initialX, int initialY, char initialDirection
            , int expectedX, int expectedY, String commands) {
        should_return_correct_point_after_one_forward_vertical_movement(initialX, initialY, initialDirection, expectedX, expectedY, commands);
    }

    @Test
    public void should_throw_on_null_command() {
        GridPoint initialPoint = new GridPoint(0, 0);
        Rover rover = Rover.Create(initialPoint, 'N', testGrid);
        Assertions.assertThrows(IllegalArgumentException.class, () -> rover.move(null));

    }


}
