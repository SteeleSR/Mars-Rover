import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverShould {

    private Rover target = new Rover();

    @Test void
    rotate_right() {
        assertEquals("E", target.execute("R"));
        assertEquals("S", target.execute("R"));
        assertEquals("W", target.execute("R"));
        assertEquals("N", target.execute("R"));
    }
}
