package fr.marsRover;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.security.InvalidParameterException;

public class ForwardCommandsTest {

    //TODO edge cases : chaîne nulle, commande majuscule, valeurs négative, chaines avec des éspaces


    @ParameterizedTest
    @CsvSource({"0,0,N,1,f", "0,1,N,2,f", "0,3,S,2,f", "6,4,S,3,f"})
    public void singleYMovement(int initialX, int initialY, char initialDirection
            , int expectedY, String commands) {
        Rover rover = Rover.Create(initialX, initialY, initialDirection);
        rover.move(commands);

        Assertions.assertEquals(expectedY, rover.getY());
    }

    @ParameterizedTest
    @CsvSource({"2,1,E,3,f", "5,2,W,4,f"})
    public void singleXMovement(int initialX, int initialY, char initialDirection
            , int expectedX, String commands) {
        Rover rover = Rover.Create(initialX, initialY, initialDirection);
        rover.move(commands);

        Assertions.assertEquals(expectedX, rover.getX());
    }

    @ParameterizedTest
    @CsvSource({"0,0,L", "0,0,*", "0,0,!", "-1,5,W", "1,-8,N",})
    public void invalidInitialDirection(int initialX, int initialY, char initialDirection) {
        Assertions.assertThrows(InvalidParameterException.class, () -> Rover.Create(initialX, initialY, initialDirection));
        Assertions.assertAll(() -> {
            Assertions.assertThrows(InvalidParameterException.class, () -> Rover.Create(0, 0, 'L'));
            Assertions.assertThrows(InvalidParameterException.class, () -> Rover.Create(0, 0, '\t'));
            Assertions.assertThrows(InvalidParameterException.class, () -> Rover.Create(0, 0, '*'));
        });
    }


    @ParameterizedTest
    @CsvSource({"1,3,N,1,6,fff"})
    public void multipleCommands(int initialX, int initialY, char initialDirection
            , int expectedX, int expectedY, String commands) {
        Rover rover = Rover.Create(initialX, initialY, initialDirection);
        rover.move(commands);

        Assertions.assertEquals(expectedX, rover.getX());
        Assertions.assertEquals(expectedY, rover.getY());
    }


}
