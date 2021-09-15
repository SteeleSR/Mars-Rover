package com.codurance;

import java.util.List;

import static com.codurance.Command.LEFT;
import static com.codurance.Command.RIGHT;
import static com.codurance.CommandParser.parseKnownCommands;
import static com.codurance.Direction.NORTH;
import static com.codurance.DirectionResolver.resolveNextLeftRotation;
import static com.codurance.DirectionResolver.resolveNextRightRotation;

public class Rover {
    private Direction direction = NORTH;
    
    public String execute(String command) {
        List<Command> parsedCommands = parseKnownCommands(command);

        for(Command parsedCommand : parsedCommands) {
            if (parsedCommand == RIGHT)
                rotateRight();

            if (parsedCommand == LEFT)
                rotateLeft();
        }

        return direction.compass;
    }

    private void rotateLeft() {
        direction = resolveNextLeftRotation(direction);
    }

    private void rotateRight() {
        direction = resolveNextRightRotation(direction);
    }
}
