package com.codurance;

import com.codurance.error.ObstacleEncounteredException;
import com.codurance.model.Command;
import com.codurance.model.Coordinate;
import com.codurance.model.Direction;
import com.codurance.model.Grid;
import com.codurance.service.VectorResolver;

import java.util.List;

import static com.codurance.model.Command.LEFT;
import static com.codurance.model.Command.MOVE;
import static com.codurance.model.Command.RIGHT;
import static com.codurance.service.CommandParser.parseKnownCommands;
import static com.codurance.model.Direction.NORTH;
import static java.lang.String.format;

public class Rover {

    private Direction direction = NORTH;
    private Coordinate coordinate = new Coordinate();
    private String obstacleEncounteredIndicator = "";

    private final VectorResolver vectorResolver;

    public Rover(Grid grid) {
        this.vectorResolver = new VectorResolver(grid);
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

        return format("%s%d:%d:%s", obstacleEncounteredIndicator, coordinate.x, coordinate.y, direction.compass);
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

