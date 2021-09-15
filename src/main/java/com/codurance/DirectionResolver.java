package com.codurance;

import static com.codurance.Direction.values;

public class DirectionResolver {

    public static Direction resolveNextRightRotation(Direction currentDirection) {
        Direction[] directions = values();
        int nextDirectionIndex = (currentDirection.ordinal() + 1) % directions.length;
        return directions[nextDirectionIndex];
    }

    public static Direction resolveNextLeftRotation(Direction currentDirection) {
        Direction[] directions = values();
        int previousDirectionIndex = (currentDirection.ordinal() - 1 + directions.length) % directions.length;
        return directions[previousDirectionIndex];
    }

}
