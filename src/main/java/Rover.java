public class Rover {
    private Direction direction = Direction.NORTH;
    public String execute(String command) {
        String nextCompass = direction.rightOf;
        direction = Direction.valueOf(nextCompass);
        return direction.compass;
    }
}

enum Direction {
    NORTH("N", "WEST", "EAST"),
    EAST("E", "NORTH", "SOUTH"),
    SOUTH("S", "EAST", "WEST"),
    WEST("W", "SOUTH", "NORTH");

    public String compass;
    public String leftOf;
    public String rightOf;

    Direction(String compass, String leftOf, String rightOf) {
        this.compass = compass;
        this.leftOf = leftOf;
        this.rightOf = rightOf;
    }
}
