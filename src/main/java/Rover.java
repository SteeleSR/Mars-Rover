public class Rover {
    private Direction direction = Direction.NORTH;
    public String execute(String command) {
        rotateRight();
        return direction.compass;
    }

    private void rotateRight() {
        int nextDirectionIndex = direction.ordinal() + 1;
        Direction[] directions = Direction.values();
        direction = directions[nextDirectionIndex % directions.length];
    }
}

enum Direction {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    public String compass;

    Direction(String compass) {
        this.compass = compass;
    }
}
