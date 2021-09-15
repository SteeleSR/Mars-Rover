package com.codurance;

import java.util.Optional;

import static com.codurance.Direction.EAST;
import static com.codurance.Direction.NORTH;
import static com.codurance.Direction.SOUTH;
import static com.codurance.Direction.WEST;
import static com.codurance.Direction.values;

public class VectorResolver {

    private static final int GRID_BOUNDARY = 10;
    private Optional<Coordinate> obstacle;

    public VectorResolver(Optional<Coordinate> obstacle) {
        this.obstacle = obstacle;
    }

    public Direction resolveNextRightRotation(Direction currentDirection) {
        Direction[] directions = values();
        int currentIndex = currentDirection.ordinal();
        int nextIndex = incrementWithinRange(currentIndex, directions.length);

        return directions[nextIndex];
    }

    private int incrementWithinRange(int value, int range) {
        return (value + 1) % range;
    }

    public Direction resolveNextLeftRotation(Direction currentDirection) {
        Direction[] directions = values();
        int currentIndex = currentDirection.ordinal();
        int previousIndex = decrementWithinRange(currentIndex, directions.length);

        return directions[previousIndex];
    }

    private int decrementWithinRange(int value, int range) {
        return (value - 1 + range) % range;
    }

    public Coordinate resolveNextCoordinate(Coordinate currentCoordinate, Direction currentDirection) throws ObstacleEncounteredException {
        Coordinate nextCoordinate = resolveNextPotentialCoordinate(currentCoordinate, currentDirection);

        if (obstacle.isPresent()) {
            Coordinate tempObstacle = obstacle.get();
            if(nextCoordinate.x == tempObstacle.x && nextCoordinate.y == tempObstacle.y) {
                throw new ObstacleEncounteredException();
            }
        }

        return nextCoordinate;
    }

    public Coordinate resolveNextPotentialCoordinate(Coordinate currentCoordinate, Direction currentDirection) {
        int x = currentCoordinate.x;
        int y = currentCoordinate.y;

        if (currentDirection == NORTH)
            y = incrementWithinRange(y, GRID_BOUNDARY);

        if (currentDirection == SOUTH)
            y = decrementWithinRange(y, GRID_BOUNDARY);

        if (currentDirection == EAST)
            x = incrementWithinRange(x, GRID_BOUNDARY);

        if(currentDirection == WEST)
            x = decrementWithinRange(x, GRID_BOUNDARY);

        return new Coordinate(x, y);
    }

}
