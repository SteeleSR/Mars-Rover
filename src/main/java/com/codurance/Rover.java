package com.codurance;

import java.util.List;
import java.util.Optional;

import static com.codurance.Command.LEFT;
import static com.codurance.Command.RIGHT;
import static com.codurance.Command.MOVE;
import static com.codurance.CommandParser.parseKnownCommands;
import static com.codurance.Direction.NORTH;

public class Rover {

    private Direction direction = NORTH;
    private Coordinate coordinate = new Coordinate();
    private String obstacleEncounteredIndicator = "";

    private final VectorResolver vectorResolver;

    public Rover(Optional<Coordinate> obstacle) {
        this.vectorResolver = new VectorResolver(obstacle);
    }

    public String execute(String command) {
        List<Command> parsedCommands = parseKnownCommands(command);

        for(Command parsedCommand : parsedCommands) {
            if (parsedCommand == RIGHT)
                rotateRight();

            if (parsedCommand == LEFT)
                rotateLeft();

            if(parsedCommand == MOVE)
                move();
        }

        return String.format("%s%d:%d:%s", obstacleEncounteredIndicator, coordinate.x, coordinate.y, direction.compass);
    }

    private void rotateLeft() {
        direction = vectorResolver.resolveNextLeftRotation(direction);
    }

    private void rotateRight() {
        direction = vectorResolver.resolveNextRightRotation(direction);
    }

    private void move() {
        try {
            coordinate = vectorResolver.resolveNextCoordinate(coordinate, direction);
        } catch(ObstacleEncounteredException exception) {
            obstacleEncounteredIndicator = "O:";
        }
    }

}

