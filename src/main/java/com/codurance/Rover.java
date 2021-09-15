package com.codurance;

import java.util.List;

import static com.codurance.Command.LEFT;
import static com.codurance.Command.RIGHT;
import static com.codurance.Command.MOVE;
import static com.codurance.CommandParser.parseKnownCommands;
import static com.codurance.Direction.NORTH;
import static com.codurance.VectorResolver.resolveNextCoordinate;
import static com.codurance.VectorResolver.resolveNextLeftRotation;
import static com.codurance.VectorResolver.resolveNextRightRotation;

public class Rover {

    private Direction direction = NORTH;
    private Coordinate coordinate = new Coordinate();

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

        return String.format("%d:%d:%s", coordinate.x, coordinate.y, direction.compass);
    }

    private void rotateLeft() {
        direction = resolveNextLeftRotation(direction);
    }

    private void rotateRight() {
        direction = resolveNextRightRotation(direction);
    }

    private void move() {
        coordinate = resolveNextCoordinate(coordinate, direction);
    }
}

