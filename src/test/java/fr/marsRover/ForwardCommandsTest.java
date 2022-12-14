package fr.marsRover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.security.InvalidParameterException;

public class ForwardCommandsTest {

    private final Grid testGrid = new Grid(10, 10);

    @ParameterizedTest
    @CsvSource({"0,0,L", "0,0,*", "0,0,!", "-1,5,W", "1,-8,N",})
    public void invalidInitialDirection(int initialX, int initialY, char initialDirection) {
        GridPosition initialPosition = new GridPosition(initialX, initialY);
        Assertions.assertThrows(InvalidParameterException.class, () -> Rover.Create(initialPosition, initialDirection, testGrid));
    }

    @ParameterizedTest
    @CsvSource({"0,0,N,0,1,f", "0,1,N,0,2,f", "0,3,S,0,2,f", "6,4,S,6,3,f"})
    public void singleYMovement(int initialX, int initialY, char initialDirection,
                                int expectedX, int expectedY, String commands) {
        GridPosition initialPosition = new GridPosition(initialX, initialY);
        Rover rover = Rover.Create(initialPosition, initialDirection, testGrid);
        rover.move(commands);

        Assertions.assertEquals(new GridPosition(expectedX, expectedY), rover.getPosition());
    }

    @ParameterizedTest
    @CsvSource({"2,1,E,3,1,f", "5,2,W,4,2,f"})
    public void singleXMovement(int initialX, int initialY, char initialDirection,
                                int expectedX, int expectedY, String commands) {
        singleYMovement(initialX, initialY, initialDirection, expectedX, expectedY, commands);
    }

    @ParameterizedTest
    @CsvSource({"1,3,N,1,6,fff", "1,3,S,1,1,ff", "1,3,E,5,3,ffff", "3,3,W,0,3,fff"})
    public void multipleCommands(int initialX, int initialY, char initialDirection
            , int expectedX, int expectedY, String commands) {
        singleYMovement(initialX, initialY, initialDirection, expectedX, expectedY, commands);
    }


}
