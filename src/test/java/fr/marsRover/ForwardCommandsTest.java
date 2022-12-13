package fr.marsRover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ForwardCommandsTest {

    //TODO edge cases : chaîne nulle, commande majuscule, valeurs négative, chaines avec des éspaces


    @ParameterizedTest
    @CsvSource({"0,0,N,1,f", "0,1,N,2,f", "0,3,S,2,f", "6,4,S,3,f"})
    public void singleYMovement(int initialX, int initialY, String initialDirection
            , int expectedY, String commands) {
        Rover rover = new Rover(initialX, initialY, initialDirection);
        rover.move(commands);

        Assertions.assertEquals(expectedY, rover.getY());
    }

    @ParameterizedTest
    @CsvSource({"2,1,E,3,f"})
    public void singleXMovement(int initialX, int initialY, String initialDirection
            , int expectedX, String commands) {
        Rover rover = new Rover(initialX, initialY, initialDirection);
        rover.move(commands);

        Assertions.assertEquals(expectedX, rover.getX());
    }


    //"2,1,N,2,4", "0,0,N,0,3"
    @ParameterizedTest
    @CsvSource({"1,3,N,1,6"})
    public void multipleCommands(int initialX, int initialY, String initialDirection
            , int expectedX, int expectedY) {
        Rover rover = new Rover(initialX, initialY, initialDirection);
        rover.move("fff");

        Assertions.assertEquals(expectedX, rover.getX());
        Assertions.assertEquals(expectedY, rover.getY());
    }


}
